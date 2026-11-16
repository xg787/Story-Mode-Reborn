package net.xg787.story_mode_reborn.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.xg787.story_mode_reborn.registry.StoryModeRebornBlockEntities;

public class RedstoneHeartBlock extends BaseEntityBlock {
    public static final BooleanProperty BEAT_SOUND = BooleanProperty.create("beat_sound");
    public static final BooleanProperty INVERTED = BooleanProperty.create("inverted");
    public static final BooleanProperty BEAT = BooleanProperty.create("beat");
    public static final MapCodec<RedstoneHeartBlock> CODEC = simpleCodec(RedstoneHeartBlock::new);

    @Override
    public MapCodec<RedstoneHeartBlock> codec() {
        return CODEC;
    }

    public RedstoneHeartBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    protected int getSignal(BlockState blockState, BlockGetter blockAccess, BlockPos pos, Direction side) {
        return blockState.getValue(BEAT) ? 15 : 0;
    }

    @Override
    protected int getDirectSignal(BlockState blockState, BlockGetter blockAccess, BlockPos pos, Direction side) {
        return blockState.getValue(BEAT) ? 15 : 0;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BEAT_SOUND, INVERTED, BEAT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(BEAT_SOUND, true).setValue(INVERTED, false).setValue(BEAT, false);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            if (player.isCrouching()) {
                state = state.cycle(BEAT_SOUND);
            } else {
                state = state.cycle(INVERTED);
            }
            updateState(level, pos, state);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }
    
    public void updateState(Level level, BlockPos pos, BlockState state) {
        level.setBlock(pos, state, 3);
        this.updateNeighbours(level, pos);
    }

    private void updateNeighbours(Level level, BlockPos pos) {
        level.updateNeighborsAt(pos, this);
        level.updateNeighborsAt(pos.above(), this);
        level.updateNeighborsAt(pos.north(), this);
        level.updateNeighborsAt(pos.south(), this);
        level.updateNeighborsAt(pos.east(), this);
        level.updateNeighborsAt(pos.west(), this);
        level.updateNeighborsAt(pos.below(), this);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new RedstoneHeartBlockEntity(blockPos, blockState);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, StoryModeRebornBlockEntities.REDSTONE_HEART_BLOCK_ENTITY.get(), (level1, blockPos, blockState, blockEntity) -> RedstoneHeartBlockEntity.tick(level1, blockPos, blockState));
    }
}
