package net.xg787.xgsmi.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.xg787.xgsmi.registry.StoryModeRebornBlocks;

import static net.xg787.xgsmi.util.StoryModeRebornTags.Blocks.ENCHANTED_FIRE;

public class EnchantedFireDiamondBlock extends AbstractEnchantedFireBlock {
    public static final MapCodec<EnchantedFireDiamondBlock> CODEC = simpleCodec(EnchantedFireDiamondBlock::new);

    public EnchantedFireDiamondBlock(Properties properties) {
        super(properties);
    }

    public static BlockState getState(BlockGetter reader, BlockPos pos) {
        return ((AbstractEnchantedFireBlock)StoryModeRebornBlocks.ENCHANTED_FIRE_DIAMOND.get()).getStateForPlacement(reader, pos);
    }

    @Override
    public BlockState getStateWithAge(LevelAccessor level, BlockPos pos, int age) {
        BlockState blockstate = getState(level, pos);
        return blockstate.is(StoryModeRebornBlocks.ENCHANTED_FIRE_DIAMOND) ? blockstate.setValue(AGE, Integer.valueOf(age)) : blockstate;
    }

    @Override
    public void placeExtension(Level level, BlockPos pos) {
        if (level.getBlockState(pos.above()).isAir() || level.getBlockState(pos.above(2)).isAir() && level.getBlockState(pos.above()).is(ENCHANTED_FIRE)) {
            if (level.getBlockState(pos.above()).isAir()) {
                level.setBlock(pos.above(), StoryModeRebornBlocks.ENCHANTED_FIRE_DIAMOND_EXTENSION.get().defaultBlockState(), 2);
            }
            if (level.getBlockState(pos.above()).is(ENCHANTED_FIRE) && level.getBlockState(pos.above(2)).isAir()) {
                level.setBlock(pos.above(2), StoryModeRebornBlocks.ENCHANTED_FIRE_DIAMOND_EXTENSION.get().defaultBlockState(), 2);
            }
        }
    }

    @Override
    public MapCodec<EnchantedFireDiamondBlock> codec() {
        return CODEC;
    }
}
