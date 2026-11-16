package net.xg787.story_mode_reborn.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.xg787.story_mode_reborn.entity.RedstoneHeart;
import net.xg787.story_mode_reborn.registry.StoryModeRebornBlockEntities;
import net.xg787.story_mode_reborn.registry.StoryModeRebornEntities;
import net.xg787.story_mode_reborn.registry.StoryModeRebornSounds;

import java.util.List;

public class RedstoneHeartBlockEntity extends BlockEntity {

    public RedstoneHeartBlockEntity(BlockPos pos, BlockState blockState) {
        super(StoryModeRebornBlockEntities.REDSTONE_HEART_BLOCK_ENTITY.get(), pos, blockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if (!level.isClientSide() && level.getGameTime() % 10 == 0 && blockState.getBlock() instanceof RedstoneHeartBlock redstoneHeartBlock) {
            if (blockState.getValue(RedstoneHeartBlock.INVERTED)) {
                blockState = blockState.setValue(RedstoneHeartBlock.BEAT, true);
            } else {
                blockState = blockState.setValue(RedstoneHeartBlock.BEAT, false);
            }
            redstoneHeartBlock.updateState(level, blockPos, blockState);
        }
        if (!level.isClientSide() && level.getGameTime() % 30 == 0 && blockState.getBlock() instanceof RedstoneHeartBlock redstoneHeartBlock) {
            if (blockState.getValue(RedstoneHeartBlock.INVERTED)) {
                blockState = blockState.setValue(RedstoneHeartBlock.BEAT, false);
            } else {
                blockState = blockState.setValue(RedstoneHeartBlock.BEAT, true);
            }
            redstoneHeartBlock.updateState(level, blockPos, blockState);
        }
        if (level.isClientSide()) {
            if (level.getGameTime() % 30 == 0) {
                if (blockState.getValue(RedstoneHeartBlock.BEAT_SOUND)) {
                    level.playLocalSound(
                            (double) blockPos.getX() + 0.5,
                            (double) blockPos.getY() + 0.5,
                            (double) blockPos.getZ() + 0.5,
                            StoryModeRebornSounds.REDSTONE_HEART_HEARTBEAT.get(),
                            SoundSource.BLOCKS,
                            4.0F,
                            1.0F,
                            false
                    );
                }
            }
        }
        if (!level.isClientSide()) {
            List<RedstoneHeart> redstoneHearts = level.getEntitiesOfClass(RedstoneHeart.class, new AABB(blockPos), entity -> true);
            if (redstoneHearts.isEmpty()) {
                RedstoneHeart entity = StoryModeRebornEntities.REDSTONE_HEART_ENTITY.get().create(level);
                if (entity != null) {
                    entity.setPos((blockPos.getX() + 0.5), blockPos.getY(), (blockPos.getZ() + 0.5));
                    level.addFreshEntity(entity);
                }
            }
        }
    }
}
