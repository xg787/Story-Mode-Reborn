package net.xg787.xgsmi.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.portal.PortalShape;

import static net.xg787.xgsmi.util.StoryModeRebornTags.Blocks.ENCHANTED_FIRE;

public abstract class AbstractEnchantedFireBlock extends BaseFireBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;

    public AbstractEnchantedFireBlock(BlockBehaviour.Properties properties) {
        super(properties, 4.0F);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).isFaceSturdy(level, pos.below(), Direction.UP) || this.isValidFireLocation(level, pos) && !level.getBlockState(pos.below()).is(ENCHANTED_FIRE);
    }

    public static boolean canBePlacedAt(Level level, BlockPos pos, Direction direction, ItemStack itemStack) {
        BlockState blockstate = level.getBlockState(pos);
        return !level.getBlockState(pos.below()).isAir() && getState(level, pos).canSurvive(level, pos) && !level.getBlockState(pos.below()).is(ENCHANTED_FIRE) && level.getBlockState(pos).canBeReplaced() || isPortal(level, pos, direction) && level.getBlockState(pos).canBeReplaced() || isEnchantedPortal(level, pos, direction, itemStack) && level.getBlockState(pos).canBeReplaced();
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return this.canSurvive(state, level, currentPos) ? this.getStateWithAge(level, currentPos, state.getValue(AGE)) : Blocks.AIR.defaultBlockState();
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.scheduleTick(pos, this, getFireTickDelay(level.random));
        this.placeExtension(level, pos);
        if (level.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            int i = state.getValue(AGE);
            int j = Math.min(15, i + random.nextInt(3) / 2);
            if (i != j) {
                state = state.setValue(AGE, Integer.valueOf(j));
                level.setBlock(pos, state, 4);
            }

            boolean flag1 = level.getBiome(pos).is(BiomeTags.INCREASED_FIRE_BURNOUT);
            int k = flag1 ? -50 : 0;
            this.checkBurnOut(level, pos.east(), 300 + k, random, i, Direction.WEST);
            this.checkBurnOut(level, pos.west(), 300 + k, random, i, Direction.EAST);
            this.checkBurnOut(level, pos.below(), 250 + k, random, i, Direction.UP);
            this.checkBurnOut(level, pos.above(), 250 + k, random, i, Direction.DOWN);
            this.checkBurnOut(level, pos.north(), 300 + k, random, i, Direction.SOUTH);
            this.checkBurnOut(level, pos.south(), 300 + k, random, i, Direction.NORTH);
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for (int l = -1; l <= 1; l++) {
                for (int i1 = -1; i1 <= 1; i1++) {
                    for (int j1 = -1; j1 <= 4; j1++) {
                        if (l != 0 || j1 != 0 || i1 != 0) {
                            int k1 = 100;
                            if (j1 > 1) {
                                k1 += (j1 - 1) * 100;
                            }

                            blockpos$mutableblockpos.setWithOffset(pos, l, j1, i1);
                            int l1 = this.getIgniteOdds(level, blockpos$mutableblockpos);
                            if (l1 > 0) {
                                int i2 = (l1 + 40 + level.getDifficulty().getId() * 7) / (i + 30);
                                if (flag1) {
                                    i2 /= 2;
                                }

                                if (i2 > 0
                                        && random.nextInt(k1) <= i2
                                        && (!level.isRaining() || !this.isNearRain(level, blockpos$mutableblockpos))) {
                                    int j2 = Math.min(15, i + random.nextInt(5) / 4);
                                    level.setBlock(blockpos$mutableblockpos, this.getVanillaStateWithAge(level, blockpos$mutableblockpos, j2), 3);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    protected boolean isNearRain(Level level, BlockPos pos) {
        return level.isRainingAt(pos)
                || level.isRainingAt(pos.west())
                || level.isRainingAt(pos.east())
                || level.isRainingAt(pos.north())
                || level.isRainingAt(pos.south());
    }

    private void checkBurnOut(Level level, BlockPos pos, int chance, RandomSource random, int age, Direction face) {
        int i = level.getBlockState(pos).getFlammability(level, pos, face);
        if (random.nextInt(chance) < i) {
            BlockState blockstate = level.getBlockState(pos);
            blockstate.onCaughtFire(level, pos, face, null);

            if (random.nextInt(age + 10) < 5 && !level.isRainingAt(pos)) {
                int j = Math.min(age + random.nextInt(5) / 4, 15);
                level.setBlock(pos, this.getVanillaStateWithAge(level, pos, j), 3);
            } else {
                level.removeBlock(pos, false);
            }
        }
    }

    private BlockState getVanillaStateWithAge(LevelAccessor level, BlockPos pos, int age) {
        BlockState blockstate = BaseFireBlock.getState(level, pos);
        return blockstate.is(Blocks.FIRE) ? blockstate.setValue(AGE, age) : blockstate;
    }

    public abstract BlockState getStateWithAge(LevelAccessor level, BlockPos pos, int age);

    private boolean isValidFireLocation(BlockGetter level, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            if (this.canCatchFire(level, pos.relative(direction), direction.getOpposite())) {
                return true;
            }
        }

        return false;
    }

    private int getIgniteOdds(LevelReader level, BlockPos pos) {
        if (!level.isEmptyBlock(pos)) {
            return 0;
        } else {
            int i = 0;

            for (Direction direction : Direction.values()) {
                BlockState blockstate = level.getBlockState(pos.relative(direction));
                i = Math.max(blockstate.getFireSpreadSpeed(level, pos.relative(direction), direction.getOpposite()), i);
            }

            return i;
        }
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        this.placeExtension(level, pos);
        level.scheduleTick(pos, this, getFireTickDelay(level.random));
    }

    public abstract void placeExtension(Level level, BlockPos pos);

    private static int getFireTickDelay(RandomSource random) {
        return 30 + random.nextInt(10);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected boolean canBurn(BlockState state) {
        return false;
    }

    public boolean canCatchFire(BlockGetter world, BlockPos pos, Direction face) {
        return world.getBlockState(pos).isFlammable(world, pos, face);
    }

    protected BlockState getStateForPlacement(BlockGetter level, BlockPos pos) {
        return this.defaultBlockState();
    }

    private static boolean inEnchantedPortalDimension(Level level) {
        return level.dimension() == Level.OVERWORLD || level.dimension() == Level.NETHER;
    }


    public static boolean isEnchantedPortal(Level level, BlockPos pos, Direction p_direction, ItemStack itemStack) {
//        if (inEnchantedPortalDimension(level))  {
//            BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();
//            boolean flag = false;
//
//            for (Direction direction : Direction.values()) {
//                if (level.getBlockState(blockpos$mutableblockpos.set(pos).move(direction)).isPortalFrame(level, blockpos$mutableblockpos)) {
//                    flag = true;
//                    break;
//                }
//            }
//
//            if (!flag) {
//                return false;
//            } else {
//                Direction.Axis direction$axis = p_direction.getAxis().isHorizontal()
//                        ? p_direction.getCounterClockWise().getAxis()
//                        : Direction.Plane.HORIZONTAL.getRandomAxis(level.random);
//                return PortalShape.findEmptyPortalShape(level, pos, direction$axis).isPresent();
//            }
//        } else {
            return false;
//        }
    }
}
