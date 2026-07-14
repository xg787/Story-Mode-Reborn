package net.xg787.xgsmi.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.xg787.xgsmi.registry.StoryModeRebornBlocks;

import java.util.Set;

import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.*;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.*;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(WHITE_PUMPKIN.get());
        dropSelf(CARVED_WHITE_PUMPKIN.get());
        dropSelf(WHITE_JACK_O_LANTERN.get());
        add(ATTACHED_WHITE_PUMPKIN_STEM.get(), block -> createAttachedStemDrops(ATTACHED_WHITE_PUMPKIN_STEM.get(), WHITE_PUMPKIN_SEEDS.get()));
        add(WHITE_PUMPKIN_STEM.get(), block -> createStemDrops(WHITE_PUMPKIN_STEM.get(), WHITE_PUMPKIN_SEEDS.get()));
        dropSelf(TITANIUM_BLOCK.get());
        add(DEEPSLATE_TITANIUM_ORE.get(), block -> createOreDrop(DEEPSLATE_TITANIUM_ORE.get(), RAW_TITANIUM.get()));
        add(NETHER_ROMEUM_ORE.get(), block -> createOreDrop(NETHER_ROMEUM_ORE.get(), RAW_ROMEUM.get()));
        dropSelf(ROMEUM_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return StoryModeRebornBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
