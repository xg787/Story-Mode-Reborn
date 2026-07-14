package net.xg787.xgsmi.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;

public class StoryModeRebornTags {
    public static class Blocks {
        public static final TagKey<Block> ENCHANTED_FIRE = createTag("enchanted_fire");

        public static final TagKey<Block> CROPS_WHITE_PUMPKIN = createCommonTag("crops/white_pumpkin");
        public static final TagKey<Block> WHITE_PUMPKINS = createCommonTag("white_pumpkins");
        public static final TagKey<Block> WHITE_PUMPKINS_NORMAL = createCommonTag("white_pumpkins/normal");
        public static final TagKey<Block> WHITE_PUMPKINS_CARVED = createCommonTag("white_pumpkins/carved");
        public static final TagKey<Block> WHITE_PUMPKINS_JACK_O_LANTERNS = createCommonTag("white_pumpkins/jack_o_lanterns");

        public static final TagKey<Block> ORES_TITANIUM = createCommonTag("ores/titanium");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_TITANIUM = createCommonTag("storage_blocks/raw_titanium");
        public static final TagKey<Block> STORAGE_BLOCKS_TITANIUM = createCommonTag("storage_blocks/titanium");

        public static final TagKey<Block> ORES_ROMEUM = createCommonTag("ores/romeum");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_ROMEUM = createCommonTag("storage_blocks/raw_romeum");
        public static final TagKey<Block> STORAGE_BLOCKS_ROMEUM = createCommonTag("storage_blocks/romeum");



        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
        }

        private static TagKey<Block> createCommonTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TNT_IGNITER = createTag("tnt_igniter");
        public static final TagKey<Item> CHARGED_IGNITER = createTag("charged_igniter");
        public static final TagKey<Item> ENCHANTED_IGNITER = createTag("enchanted_igniter");
        public static final TagKey<Item> PRISMARINE_TOOL_MATERIAL = createTag("prismarine_tool_material");
        public static final TagKey<Item> STORY_MODE_ARMOR = createTag("story_mode_armor");
        public static final TagKey<Item> BASIC_ARMOR_TEMPLATES = createTag("basic_armor_templates");
        public static final TagKey<Item> ARMOR_TEMPLATES = createTag("armor_templates");

        public static final TagKey<Item> SEEDS_WHITE_PUMPKIN = createCommonTag("seeds/white_pumpkin");
        public static final TagKey<Item> CROPS_WHITE_PUMPKIN = createCommonTag("crops/white_pumpkin");
        public static final TagKey<Item> WHITE_PUMPKINS = createCommonTag("white_pumpkins");
        public static final TagKey<Item> WHITE_PUMPKINS_NORMAL = createCommonTag("white_pumpkins/normal");
        public static final TagKey<Item> WHITE_PUMPKINS_CARVED = createCommonTag("white_pumpkins/carved");
        public static final TagKey<Item> WHITE_PUMPKINS_JACK_O_LANTERNS = createCommonTag("white_pumpkins/jack_o_lanterns");

        public static final TagKey<Item> ORES_TITANIUM = createCommonTag("ores/titanium");
        public static final TagKey<Item> RAW_MATERIALS_TITANIUM = createCommonTag("raw_materials/titanium");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_TITANIUM = createCommonTag("storage_blocks/raw_titanium");
        public static final TagKey<Item> NUGGETS_TITANIUM = createCommonTag("nuggets/titanium");
        public static final TagKey<Item> INGOTS_TITANIUM = createCommonTag("ingots/titanium");
        public static final TagKey<Item> STORAGE_BLOCKS_TITANIUM = createCommonTag("storage_blocks/titanium");

        public static final TagKey<Item> ORES_ROMEUM = createCommonTag("ores/romeum");
        public static final TagKey<Item> RAW_MATERIALS_ROMEUM = createCommonTag("raw_materials/romeum");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_ROMEUM = createCommonTag("storage_blocks/raw_romeum");
        public static final TagKey<Item> NUGGETS_ROMEUM = createCommonTag("nuggets/romeum");
        public static final TagKey<Item> INGOTS_ROMEUM = createCommonTag("ingots/romeum");
        public static final TagKey<Item> STORAGE_BLOCKS_ROMEUM = createCommonTag("storage_blocks/romeum");


        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
        }

        private static TagKey<Item> createCommonTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }
}
