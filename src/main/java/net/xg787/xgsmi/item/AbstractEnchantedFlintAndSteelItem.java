package net.xg787.xgsmi.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.xg787.xgsmi.block.AbstractEnchantedFireBlock;
import net.xg787.xgsmi.registry.StoryModeRebornSounds;

import static net.minecraft.world.level.block.Blocks.FIRE;

public abstract class AbstractEnchantedFlintAndSteelItem extends Item {

    public AbstractEnchantedFlintAndSteelItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        BlockState blockstate2 = blockstate.getToolModifiedState(context, net.neoforged.neoforge.common.ItemAbilities.FIRESTARTER_LIGHT, false);
        if (blockstate2 == null) {
            BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
            ItemStack itemstack = context.getItemInHand();

            if (AbstractEnchantedFireBlock.canBePlacedAt(level, blockpos1, context.getHorizontalDirection(), itemstack)) {
                level.playSound(player, blockpos1, StoryModeRebornSounds.ENCHANTED_FLINT_AND_STEEL_USE.get(), SoundSource.BLOCKS, 1.0F, 1);

                if (!AbstractEnchantedFireBlock.isPortal(level, blockpos1, context.getHorizontalDirection()) && !AbstractEnchantedFireBlock.isEnchantedPortal(level, blockpos1, context.getHorizontalDirection(), itemstack)) {
                    level.playSound(player, blockpos1, StoryModeRebornSounds.ENCHANTED_FLINT_AND_STEEL_PLACE_FIRE.get(), SoundSource.BLOCKS, 0.5F, 1);
                }

                level.setBlock(blockpos1, getFireBlock().defaultBlockState(), 11);
                level.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);


                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, blockpos1, itemstack);
                }

                return InteractionResult.sidedSuccess(level.isClientSide());
            } else {
                return InteractionResult.FAIL;
            }
        } else {
            level.playSound(player, blockpos, StoryModeRebornSounds.ENCHANTED_FLINT_AND_STEEL_USE.get(), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
            level.setBlock(blockpos, blockstate2, 11);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockpos);

            return InteractionResult.sidedSuccess(level.isClientSide());
        }
    }

    public abstract Block getFireBlock();

    @Override
    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
        return net.neoforged.neoforge.common.ItemAbilities.DEFAULT_FLINT_ACTIONS.contains(itemAbility);
    }
}
