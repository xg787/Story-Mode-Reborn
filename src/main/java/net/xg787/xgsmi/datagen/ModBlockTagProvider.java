package net.xg787.xgsmi.datagen;

import com.blackgear.vanillabackport.core.data.tags.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xg787.xgsmi.util.StoryModeRebornTags;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.world.level.block.Blocks.*;
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

        tag(BlockTags.CROPS)
                .add(WHITE_PUMPKIN_STEM.get());

        tag(BlockTags.MAINTAINS_FARMLAND)
                .add(MELON)
                .add(PUMPKIN)
                .add(WHITE_PUMPKIN.get())
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

        tag(StoryModeRebornTags.Blocks.STORAGE_BLOCKS_RAW_TITANIUM);

        tag(StoryModeRebornTags.Blocks.STORAGE_BLOCKS_TITANIUM).add(TITANIUM_BLOCK.get());

        tag(StoryModeRebornTags.Blocks.ORES_ROMEUM)
                .add(NETHER_ROMEUM_ORE.get());

        tag(StoryModeRebornTags.Blocks.STORAGE_BLOCKS_RAW_ROMEUM);

        tag(StoryModeRebornTags.Blocks.STORAGE_BLOCKS_ROMEUM)
                .add(ROMEUM_BLOCK.get());

        tag(BlockTags.REPLACEABLE)
                .add(ENCHANTED_FIRE_DIAMOND.get())
                .add(ENCHANTED_FIRE_EMERALD.get())
                .add(ENCHANTED_FIRE_GOLD.get())
                .add(ENCHANTED_FIRE_REDSTONE.get());

        tag(BlockTags.FIRE).addTag(StoryModeRebornTags.Blocks.ENCHANTED_FIRE);

        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_PRISMARINE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROYAL_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROMEUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_ROMEUM_TOOL);

        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_PRISMARINE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROYAL_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROMEUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_ROMEUM_TOOL);

        tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_PRISMARINE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROYAL_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROMEUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_ROMEUM_TOOL);

        tag(ModBlockTags.INCORRECT_FOR_COPPER_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_PRISMARINE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROYAL_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROMEUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_ROMEUM_TOOL);

        tag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_PRISMARINE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROYAL_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROMEUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_ROMEUM_TOOL);

        tag(StoryModeRebornTags.Blocks.INCORRECT_FOR_PRISMARINE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROYAL_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROMEUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_ROMEUM_TOOL);

        tag(StoryModeRebornTags.Blocks.INCORRECT_FOR_ROYAL_TOOL)
                .add(ANCIENT_DEBRIS)
                .addTag(Tags.Blocks.ORES_NETHERITE_SCRAP)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROMEUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_ROMEUM_TOOL);

        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROMEUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_ROMEUM_TOOL);

        tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROMEUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_ROMEUM_TOOL);

        tag(StoryModeRebornTags.Blocks.INCORRECT_FOR_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROMEUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_ROMEUM_TOOL);

        tag(StoryModeRebornTags.Blocks.INCORRECT_FOR_ENCHANTED_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ROMEUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_ROMEUM_TOOL);

        tag(StoryModeRebornTags.Blocks.INCORRECT_FOR_ROMEUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_ROMEUM_TOOL);

        tag(StoryModeRebornTags.Blocks.INCORRECT_FOR_ENCHANTED_ROMEUM_TOOL);

        tag(BlockTags.NEEDS_STONE_TOOL);

        tag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(StoryModeRebornTags.Blocks.STORAGE_BLOCKS_RAW_TITANIUM)
                .addTag(StoryModeRebornTags.Blocks.STORAGE_BLOCKS_TITANIUM)
                .addTag(StoryModeRebornTags.Blocks.STORAGE_BLOCKS_RAW_ROMEUM)
                .addTag(StoryModeRebornTags.Blocks.STORAGE_BLOCKS_ROMEUM);

        tag(StoryModeRebornTags.Blocks.NEEDS_PRISMARINE_TOOL)
                .add(PRISMARINE)
                .add(PRISMARINE_STAIRS)
                .add(PRISMARINE_SLAB)
                .add(PRISMARINE_WALL)
                .add(PRISMARINE_BRICKS)
                .add(PRISMARINE_BRICK_STAIRS)
                .add(PRISMARINE_BRICK_SLAB)
                //.add(PRISMARINE_BRICK_WALL)
                .add(DARK_PRISMARINE)
                .add(DARK_PRISMARINE_STAIRS)
                .add(DARK_PRISMARINE_SLAB)
                //.add(DARK_PRISMARINE_WALL)
                .addOptional(ResourceLocation.fromNamespaceAndPath("quark","prismarine_chest"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("quark","trapped_prismarine_chest"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("upgrade_aquatic","luminous_prismarine"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("upgrade_aquatic","luminous_prismarine_stairs"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("upgrade_aquatic","luminous_prismarine_slab"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("upgrade_aquatic","prismarine_rod_bundle"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("alloy_forgery","prismarine_bricks_forge_controller"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("cataclysm","prismarine_brick_fence"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("cataclysm","prismarine_brick_wall"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("desire","prismarine_brick_wall"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("desire","dark_prismarine_wall"));

        tag(StoryModeRebornTags.Blocks.NEEDS_ROYAL_TOOL);

        tag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(StoryModeRebornTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(StoryModeRebornTags.Blocks.ORES_TITANIUM);

        tag(StoryModeRebornTags.Blocks.NEEDS_TITANIUM_TOOL);

        tag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_TITANIUM_TOOL)
                .addTag(StoryModeRebornTags.Blocks.ORES_ROMEUM);

        tag(StoryModeRebornTags.Blocks.NEEDS_ROMEUM_TOOL);

        tag(StoryModeRebornTags.Blocks.NEEDS_ENCHANTED_ROMEUM_TOOL);
    }
}
