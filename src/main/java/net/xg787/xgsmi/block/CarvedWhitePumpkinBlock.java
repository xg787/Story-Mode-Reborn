package net.xg787.xgsmi.block;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;

import javax.annotation.Nullable;
import java.util.function.Predicate;

import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.CARVED_WHITE_PUMPKIN;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.WHITE_JACK_O_LANTERN;

public class CarvedWhitePumpkinBlock extends CarvedPumpkinBlock {
    public CarvedWhitePumpkinBlock(Properties properties) {
        super(properties);
    }
    @Nullable
    private BlockPattern snowGolemFull;
    @Nullable
    private BlockPattern ironGolemFull;

    private static final Predicate<BlockState> PUMPKINS_PREDICATE = p_51396_ -> p_51396_ != null
            && (p_51396_.is(CARVED_WHITE_PUMPKIN) || p_51396_.is(WHITE_JACK_O_LANTERN));

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!oldState.is(state.getBlock())) {
            this.trySpawnGolem(level, pos);
        }
    }

    private void trySpawnGolem(Level level, BlockPos pos) {
        BlockPattern.BlockPatternMatch blockpattern$blockpatternmatch = this.getOrCreateSnowGolemFull().find(level, pos);
        if (blockpattern$blockpatternmatch != null) {
            SnowGolem snowgolem = EntityType.SNOW_GOLEM.create(level);
            if (snowgolem != null) {
                spawnGolemInWorld(level, blockpattern$blockpatternmatch, snowgolem, blockpattern$blockpatternmatch.getBlock(0, 2, 0).getPos());
            }
        } else {
            BlockPattern.BlockPatternMatch blockpattern$blockpatternmatch1 = this.getOrCreateIronGolemFull().find(level, pos);
            if (blockpattern$blockpatternmatch1 != null) {
                IronGolem irongolem = EntityType.IRON_GOLEM.create(level);
                if (irongolem != null) {
                    irongolem.setPlayerCreated(true);
                    spawnGolemInWorld(level, blockpattern$blockpatternmatch1, irongolem, blockpattern$blockpatternmatch1.getBlock(1, 2, 0).getPos());
                }
            }
        }
    }

    private static void spawnGolemInWorld(Level level, BlockPattern.BlockPatternMatch patternMatch, Entity golem, BlockPos pos) {
        clearPatternBlocks(level, patternMatch);
        golem.moveTo((double)pos.getX() + 0.5, (double)pos.getY() + 0.05, (double)pos.getZ() + 0.5, 0.0F, 0.0F);
        level.addFreshEntity(golem);

        for (ServerPlayer serverplayer : level.getEntitiesOfClass(ServerPlayer.class, golem.getBoundingBox().inflate(5.0))) {
            CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayer, golem);
        }

        updatePatternBlocks(level, patternMatch);
    }

    private BlockPattern getOrCreateSnowGolemFull() {
        if (this.snowGolemFull == null) {
            this.snowGolemFull = BlockPatternBuilder.start()
                    .aisle("^", "#", "#")
                    .where('^', BlockInWorld.hasState(PUMPKINS_PREDICATE))
                    .where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.SNOW_BLOCK)))
                    .build();
        }

        return this.snowGolemFull;
    }

    private BlockPattern getOrCreateIronGolemFull() {
        if (this.ironGolemFull == null) {
            this.ironGolemFull = BlockPatternBuilder.start()
                    .aisle("~^~", "###", "~#~")
                    .where('^', BlockInWorld.hasState(PUMPKINS_PREDICATE))
                    .where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.IRON_BLOCK)))
                    .where('~', p_284868_ -> p_284868_.getState().isAir())
                    .build();
        }

        return this.ironGolemFull;
    }
}
