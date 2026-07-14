package net.xg787.xgsmi.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xg787.xgsmi.util.StoryModeRebornTags;

import java.util.concurrent.CompletableFuture;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.*;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(StoryModeRebornTags.Blocks.ENCHANTED_FIRE)
                .add(ENCHANTED_FIRE_DIAMOND.get())
                .add(ENCHANTED_FIRE_DIAMOND_EXTENSION.get())
                .add(ENCHANTED_FIRE_EMERALD.get())
                .add(ENCHANTED_FIRE_EMERALD_EXTENSION.get())
                .add(ENCHANTED_FIRE_GOLD.get())
                .add(ENCHANTED_FIRE_GOLD_EXTENSION.get())
                .add(ENCHANTED_FIRE_REDSTONE.get())
                .add(ENCHANTED_FIRE_REDSTONE_EXTENSION.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(WHITE_PUMPKIN_STEM.get())
                .add(ATTACHED_WHITE_PUMPKIN_STEM.get())
                .add(WHITE_PUMPKIN.get())
                .add(CARVED_WHITE_PUMPKIN.get())
                .add(WHITE_JACK_O_LANTERN.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(DEEPSLATE_TITANIUM_ORE.get())
                .add(TITANIUM_BLOCK.get())
                .add(NETHER_ROMEUM_ORE.get())
                .add(ROMEUM_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(TITANIUM_BLOCK.get())
                .add(ROMEUM_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(DEEPSLATE_TITANIUM_ORE.get())
                .add(NETHER_ROMEUM_ORE.get());

        tag(BlockTags.CROPS)
                .add(WHITE_PUMPKIN_STEM.get());

        tag(BlockTags.MAINTAINS_FARMLAND)
                .add(WHITE_PUMPKIN_STEM.get())
                .add(ATTACHED_WHITE_PUMPKIN_STEM.get());

        tag(BlockTags.BEE_GROWABLES)
                .add(WHITE_PUMPKIN_STEM.get());

        tag(StoryModeRebornTags.Blocks.WHITE_PUMPKINS)
                .add(WHITE_PUMPKIN.get())
                .add(CARVED_WHITE_PUMPKIN.get())
                .add(WHITE_JACK_O_LANTERN.get());

        tag(StoryModeRebornTags.Blocks.WHITE_PUMPKINS_NORMAL)
                .add(WHITE_PUMPKIN.get());

        tag(StoryModeRebornTags.Blocks.WHITE_PUMPKINS_CARVED)
                .add(CARVED_WHITE_PUMPKIN.get());

        tag(StoryModeRebornTags.Blocks.WHITE_PUMPKINS_JACK_O_LANTERNS)
                .add(WHITE_JACK_O_LANTERN.get());

        tag(StoryModeRebornTags.Blocks.CROPS_WHITE_PUMPKIN)
                .add(WHITE_PUMPKIN.get());

        tag(BlockTags.SWORD_EFFICIENT)
                .add(WHITE_PUMPKIN_STEM.get())
                .add(ATTACHED_WHITE_PUMPKIN_STEM.get())
                .add(WHITE_PUMPKIN.get())
                .add(CARVED_WHITE_PUMPKIN.get())
                .add(WHITE_JACK_O_LANTERN.get());

        tag(BlockTags.ENDERMAN_HOLDABLE)
                .add(WHITE_PUMPKIN.get())
                .add(CARVED_WHITE_PUMPKIN.get());

        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE)
                .add(DEEPSLATE_TITANIUM_ORE.get());

        tag(Tags.Blocks.ORES_IN_GROUND_NETHERRACK)
                .add(NETHER_ROMEUM_ORE.get());

        tag(Tags.Blocks.ORES)
                .add(DEEPSLATE_TITANIUM_ORE.get())
                .add(NETHER_ROMEUM_ORE.get());

        tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(TITANIUM_BLOCK.get())
                .add(ROMEUM_BLOCK.get());

        tag(StoryModeRebornTags.Blocks.ORES_TITANIUM)
                .add(DEEPSLATE_TITANIUM_ORE.get());

        tag(StoryModeRebornTags.Blocks.STORAGE_BLOCKS_TITANIUM).add(TITANIUM_BLOCK.get());

        tag(StoryModeRebornTags.Blocks.ORES_ROMEUM)
                .add(NETHER_ROMEUM_ORE.get());

        tag(StoryModeRebornTags.Blocks.STORAGE_BLOCKS_ROMEUM).add(ROMEUM_BLOCK.get());

        tag(BlockTags.REPLACEABLE)
                .add(ENCHANTED_FIRE_DIAMOND.get())
                .add(ENCHANTED_FIRE_EMERALD.get())
                .add(ENCHANTED_FIRE_GOLD.get())
                .add(ENCHANTED_FIRE_REDSTONE.get());

        tag(BlockTags.FIRE).addTag(StoryModeRebornTags.Blocks.ENCHANTED_FIRE);
    }
}
