package net.xg787.xgsmi.mixin;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PowerableMob;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.xg787.xgsmi.registry.StoryModeRebornItems;
import net.xg787.xgsmi.registry.StoryModeRebornSounds;
import net.xg787.xgsmi.util.StoryModeRebornTags;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Creeper.class)
public abstract class CreeperMixin extends Monster implements PowerableMob {

    @Shadow public abstract void ignite();

    @Shadow @Final private static EntityDataAccessor<Boolean> DATA_IS_POWERED;

    protected CreeperMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    protected void mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemstack = player.getItemInHand(hand);
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
                this.level().playSound(player, this.getX(), this.getY(), this.getZ(), soundevent, this.getSoundSource(), 1.0F, 1);
            } else {
                this.level().playSound(player, this.getX(), this.getY(), this.getZ(), soundevent, this.getSoundSource(), 1.0F, this.random.nextFloat() * 0.4F + 0.8F);
            }

            if (itemstack.is(StoryModeRebornTags.Items.CHARGED_IGNITER)) {
                this.entityData.set(DATA_IS_POWERED, true);
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
