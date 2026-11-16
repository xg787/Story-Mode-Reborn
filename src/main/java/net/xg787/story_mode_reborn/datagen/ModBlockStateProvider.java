package net.xg787.story_mode_reborn.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static net.minecraft.world.level.block.Blocks.DARK_PRISMARINE;
import static net.minecraft.world.level.block.Blocks.PRISMARINE_BRICKS;
import static net.xg787.story_mode_reborn.StoryModeReborn.MOD_ID;
import static net.xg787.story_mode_reborn.registry.StoryModeRebornBlocks.*;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
//        blockWithItem(SAND_PRISMARINE_ORE);
//        blockWithItem(PRISMARINE_ORE);
//        blockWithItem(DEEPSLATE_PRISMARINE_ORE);
        wallBlockWithItem(PRISMARINE_BRICK_WALL, PRISMARINE_BRICKS);
        blockWithItem(SMOOTH_PRISMARINE);
        stairsBlockWithItem(SMOOTH_PRISMARINE_STAIRS, SMOOTH_PRISMARINE.get());
        slabBlockWithItem(SMOOTH_PRISMARINE_SLAB, SMOOTH_PRISMARINE.get());
        wallBlockWithItem(SMOOTH_PRISMARINE_WALL, SMOOTH_PRISMARINE.get());
        blockWithItem(CHISELED_SMOOTH_PRISMARINE);
        directionalBlockWithItem(CARVED_PRISMARINE);
        directionalBlockWithItem(CARVED_PRISMARINE_ARROW);
        directionalBlockWithItem(CARVED_PRISMARINE_WAVE);
        blockWithItem(PRISMARINE_KEY);
        runeBlockWithItem(PRISMARINE_RUNE_BLANK);
        runeBlockWithItem(PRISMARINE_RUNE_A);
        runeBlockWithItem(PRISMARINE_RUNE_B);
        runeBlockWithItem(PRISMARINE_RUNE_C);
        runeBlockWithItem(PRISMARINE_RUNE_D);
        runeBlockWithItem(PRISMARINE_RUNE_E);
        runeBlockWithItem(PRISMARINE_RUNE_F);
        runeBlockWithItem(PRISMARINE_RUNE_G);
        runeBlockWithItem(PRISMARINE_RUNE_H);
        wallBlockWithItem(DARK_PRISMARINE_WALL, DARK_PRISMARINE);
        blockWithItem(SMOOTH_DARK_PRISMARINE);
        stairsBlockWithItem(SMOOTH_DARK_PRISMARINE_STAIRS, SMOOTH_DARK_PRISMARINE.get());
        slabBlockWithItem(SMOOTH_DARK_PRISMARINE_SLAB, SMOOTH_DARK_PRISMARINE.get());
        wallBlockWithItem(SMOOTH_DARK_PRISMARINE_WALL, SMOOTH_DARK_PRISMARINE.get());
        blockWithItem(CHISELED_SMOOTH_DARK_PRISMARINE);
        directionalBlockWithItem(CARVED_DARK_PRISMARINE);
        directionalBlockWithItem(CARVED_DARK_PRISMARINE_ARROW);
        directionalBlockWithItem(CARVED_DARK_PRISMARINE_CORNER);
        directionalBlockWithItem(CARVED_DARK_PRISMARINE_CORNER_LINE);
        directionalBlockWithItem(CARVED_DARK_PRISMARINE_SPIRAL);
        blockWithItem(DEEPSLATE_TITANIUM_ORE);
        blockWithItem(TITANIUM_BLOCK);
        blockWithItem(NETHER_ROMEUM_ORE);
        blockWithItem(ROMEUM_BLOCK);
        simpleBlock(REDSTONE_HEART.get());
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void stairsBlockWithItem(DeferredBlock<StairBlock> deferredBlock, Block baseDeferredBlock) {
        ResourceLocation texture = blockTexture(baseDeferredBlock);
        simpleBlockItem(deferredBlock.get(), models().stairs(name(deferredBlock.get()), texture, texture, texture));
        stairsBlock(deferredBlock.get(), texture, texture, texture);
    }

    private void slabBlockWithItem(DeferredBlock<SlabBlock> deferredBlock, Block baseDeferredBlock) {
        ResourceLocation texture = blockTexture(baseDeferredBlock);
        simpleBlockItem(deferredBlock.get(), models().slab(name(deferredBlock.get()), texture, texture, texture));
        slabBlock(deferredBlock.get(), texture, texture, texture, texture);
    }

    private void wallBlockWithItem(DeferredBlock<WallBlock> deferredBlock, Block baseDeferredBlock) {
        ResourceLocation texture = blockTexture(baseDeferredBlock);
        simpleBlockItem(deferredBlock.get(), models().wallInventory(name(deferredBlock.get()), texture));
        wallBlock(deferredBlock.get(), texture);
    }


    private void directionalBlockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
        directionalBlock(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void runeBlockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), models().cubeColumn(name(deferredBlock.get()), blockTexture(deferredBlock.get()), ResourceLocation.fromNamespaceAndPath(MOD_ID, "block/prismarine_rune_top")));
        directionalBlock(deferredBlock.get(), models().cubeColumn(name(deferredBlock.get()), blockTexture(deferredBlock.get()), ResourceLocation.fromNamespaceAndPath(MOD_ID, "block/prismarine_rune_top")));
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}
