package net.xg787.xgsmi.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.xg787.xgsmi.registry.StoryModeRebornBlocks;

import static net.xg787.xgsmi.util.StoryModeRebornTags.Blocks.ENCHANTED_FIRE;

public class EnchantedFireEmeraldExtensionBlock extends EnchantedFireDiamondBlock {
    public EnchantedFireEmeraldExtensionBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).is(ENCHANTED_FIRE);
    }

    public static BlockState getState(BlockGetter reader, BlockPos pos) {
        return ((AbstractEnchantedFireBlock)StoryModeRebornBlocks.ENCHANTED_FIRE_EMERALD_EXTENSION.get()).getStateForPlacement(reader, pos);
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    }

    @Override
    public BlockState getStateWithAge(LevelAccessor level, BlockPos pos, int age) {
        BlockState blockstate = getState(level, pos);
        return blockstate.is(StoryModeRebornBlocks.ENCHANTED_FIRE_EMERALD_EXTENSION) ? blockstate.setValue(AGE, Integer.valueOf(age)) : blockstate;
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
    }
}
