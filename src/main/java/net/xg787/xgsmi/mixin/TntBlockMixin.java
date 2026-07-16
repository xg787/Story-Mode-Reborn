package net.xg787.xgsmi.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.xg787.xgsmi.registry.StoryModeRebornSounds;
import net.xg787.xgsmi.util.StoryModeRebornTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TntBlock.class)
public class TntBlockMixin extends Block {

    public TntBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "useItemOn", at = @At("HEAD"), cancellable = true)
    protected void useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult, CallbackInfoReturnable<ItemInteractionResult> cir) {
        if (stack.is(StoryModeRebornTags.Items.TNT_IGNITER)) {
            SoundEvent soundevent = SoundEvents.FLINTANDSTEEL_USE;

            if (stack.is(StoryModeRebornTags.Items.FIRE_CHARGES)) {
                soundevent = SoundEvents.FIRECHARGE_USE;
            }

            if (BuiltInRegistries.ITEM.getKey(stack.getItem()).toString().equals("dungeonsdelight:rot_and_steel")) {
                soundevent = BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.fromNamespaceAndPath("dungeonsdelight","item.rot_and_steel.use"));
            }

            if (stack.is(StoryModeRebornTags.Items.ENCHANTED_IGNITER)) {
                soundevent = StoryModeRebornSounds.ENCHANTED_FLINT_AND_STEEL_USE.get();
                level.playSound(player, pos.getX(), pos.getY(), pos.getZ(), soundevent, SoundSource.BLOCKS, 1.0F, 1);
            } else {
                level.playSound(player, pos.getX(), pos.getY(), pos.getZ(), soundevent, SoundSource.BLOCKS, 1.0F, RandomSource.create().nextFloat() * 0.4F + 0.8F);
            }

            onCaughtFire(state, level, pos, hitResult.getDirection(), player);
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
            Item item = stack.getItem();
            player.awardStat(Stats.ITEM_USED.get(item));
            cir.setReturnValue(ItemInteractionResult.sidedSuccess(level.isClientSide));
        } else {
            cir.setReturnValue(super.useItemOn(stack, state, level, pos, player, hand, hitResult));
        }
    }
}
