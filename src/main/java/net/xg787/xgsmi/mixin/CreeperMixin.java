package net.xg787.xgsmi.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PowerableMob;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.xg787.xgsmi.StoryModeRebornConfig;
import net.xg787.xgsmi.registry.StoryModeRebornSounds;
import net.xg787.xgsmi.util.StoryModeRebornTags;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Creeper.class)
public abstract class CreeperMixin extends Monster implements PowerableMob {

    @Shadow
    @Final
    private static EntityDataAccessor<Boolean> DATA_IS_POWERED;

    @Shadow
    public abstract void ignite();

    @Unique
    public int aggressiveSoundTime;

    protected CreeperMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    protected void tick(CallbackInfo ci) {
        if (StoryModeRebornConfig.CREEPER_SOUNDS.get() && this.getTarget() != null) {
            if (this.isAlive() && this.random.nextInt(1000) < this.aggressiveSoundTime++) {
                this.aggressiveSoundTime = -40;
                this.playSound(this.getAggressiveSound(), 1, 1);
            }
        }
    }

    @Unique
    protected SoundEvent getAggressiveSound() {
        if (this.isPowered()) {
            return StoryModeRebornSounds.CHARGED_CREEPER_HISS.get();
        } else {
            return StoryModeRebornSounds.CREEPER_HISS.get();
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if (StoryModeRebornConfig.CREEPER_SOUNDS.get()) {
            return StoryModeRebornSounds.CREEPER_AMBIENT.get();
        } else {
            return null;
        }
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState block) {
        if (StoryModeRebornConfig.CREEPER_SOUNDS.get()) {
            this.playSound(StoryModeRebornSounds.CREEPER_STEP.get(), 0.1F, 1.0F);
        } else {
            super.playStepSound(pos, block);
        }
    }

    @Override
    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }

    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    protected void mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (itemstack.is(StoryModeRebornTags.Items.CREEPER_CHARGER)) {
            this.entityData.set(DATA_IS_POWERED, true);
        }

        if (itemstack.is(ItemTags.CREEPER_IGNITERS)) {
            SoundEvent soundevent = SoundEvents.FLINTANDSTEEL_USE;

            if (itemstack.is(StoryModeRebornTags.Items.FIRE_CHARGES)) {
                soundevent = SoundEvents.FIRECHARGE_USE;
            }

            if (BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString().equals("dungeonsdelight:rot_and_steel")) {
                soundevent = BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.fromNamespaceAndPath("dungeonsdelight","item.rot_and_steel.use"));
            }

            if (itemstack.is(StoryModeRebornTags.Items.ENCHANTED_IGNITER)) {
                soundevent = StoryModeRebornSounds.ENCHANTED_FLINT_AND_STEEL_USE.get();
                this.level().playSound(player, this.getX(), this.getY(), this.getZ(), soundevent, SoundSource.PLAYERS, 1.0F, 1);
            } else {
                this.level().playSound(player, this.getX(), this.getY(), this.getZ(), soundevent, SoundSource.PLAYERS, 1.0F, this.random.nextFloat() * 0.4F + 0.8F);
            }

            if (!this.level().isClientSide) {
                this.ignite();
                if (!itemstack.isDamageableItem() && !itemstack.is(StoryModeRebornTags.Items.ENCHANTED_IGNITER)) {
                    itemstack.shrink(1);
                } else {
                    itemstack.hurtAndBreak(1, player, getSlotForHand(hand));
                }
            }

            cir.setReturnValue(InteractionResult.sidedSuccess(this.level().isClientSide));
        } else {
            cir.setReturnValue(super.mobInteract(player, hand));
        }
    }
}
