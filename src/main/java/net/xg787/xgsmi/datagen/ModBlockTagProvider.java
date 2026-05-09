package net.xg787.xgsmi.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.TagEntry.tag;
import static net.xg787.xgsmi.Xgsmi.MOD_ID;
import static net.xg787.xgsmi.registry.XgsmiBlocks.*;
import static net.xg787.xgsmi.registry.XgsmiBlocks.ROMEUM_BLOCK;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(WHITE_PUMPKIN.get())
                .add(CARVED_WHITE_PUMPKIN.get())
                .add(WHITE_JACK_O_LANTERN.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(TITANIUM_ORE.get())
                .add(TITANIUM_BLOCK.get())
                .add(ROMEUM_ORE.get())
                .add(ROMEUM_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(TITANIUM_BLOCK.get())
                .add(ROMEUM_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(TITANIUM_ORE.get())
                .add(ROMEUM_ORE.get());
    }
}
