package net.xg787.xgsmi.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.xg787.xgsmi.registry.XgsmiBlocks;

import java.util.Set;

import static net.xg787.xgsmi.registry.XgsmiBlocks.*;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(TEST.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return XgsmiBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
