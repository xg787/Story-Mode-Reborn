package net.xg787.story_mode_reborn.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static net.xg787.story_mode_reborn.StoryModeReborn.MOD_ID;
import static net.xg787.story_mode_reborn.registry.StoryModeRebornBlocks.*;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(DEEPSLATE_TITANIUM_ORE);
        blockWithItem(TITANIUM_BLOCK);
        blockWithItem(NETHER_ROMEUM_ORE);
        blockWithItem(ROMEUM_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
