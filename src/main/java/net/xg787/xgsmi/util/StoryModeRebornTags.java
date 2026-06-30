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
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> PRISMARINE_TOOL_MATERIAL = createTag("prismarine_tool_material");
        public static final TagKey<Item> STORY_MODE_ARMOR = createTag("story_mode_armor");
        public static final TagKey<Item> BASIC_ARMOR_TEMPLATES = createTag("basic_armor_templates");
        public static final TagKey<Item> ARMOR_TEMPLATES = createTag("armor_templates");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
        }

        private static TagKey<Item> createCommonTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }
}
