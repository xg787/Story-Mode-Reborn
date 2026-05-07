package net.xg787.xgsmi.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.xg787.xgsmi.Xgsmi.MOD_ID;

public class XgsmiBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);

    public static final DeferredBlock<Block> TEST = register("test", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE)));

    private static DeferredBlock<StairBlock> registerStairs(String string, Supplier<Block> block) {
        return register(string, () -> new StairBlock(block.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(block.get())));
    }

    public static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block){
        DeferredBlock<T> blockItem = BLOCKS.register(name, block);
        registerBlockItem(name, blockItem);
        return blockItem;
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        XgsmiItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }
}
