package net.xg787.xgsmi.client.registry;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.xg787.sectioned_creative_tab_lib.tab.sections.TabSection;
import net.xg787.sectioned_creative_tab_lib.tab.sections.TabSectionRegistry;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.*;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.*;
import static net.xg787.xgsmi.registry.StoryModeRebornCreativeModeTab.STORYMODE_TAB;

public class StoryModeRebornCreativeModeTabSections {

    public static void addCreativeSections(FMLClientSetupEvent event) {
        ITEMS.add(
                () -> WHITE_PUMPKIN_SEEDS,
                () -> WHITE_PUMPKIN_PIE,
                () -> PRISMARINE_ROD,
                () -> PRISMARINE_FISHING_ROD,
                () -> PRISMARINE_SWORD,
                () -> PRISMARINE_PICKAXE,
                () -> PRISMARINE_AXE,
                () -> PRISMARINE_SHOVEL,
                () -> PRISMARINE_HOE,
                () -> PRISMARINE_BOW,
                () -> PRISMARINE_CROSSBOW,
                () -> PRISMARINE_ARROW,
                () -> ROYAL_SWORD,
                () -> ROYAL_PICKAXE,
                () -> ROYAL_AXE,
                () -> ROYAL_SHOVEL,
                () -> ROYAL_HOE,
                () -> ENCHANTED_FLINT_AND_STEEL_DIAMOND,
                () -> ENCHANTED_FLINT_AND_STEEL_EMERALD,
                () -> ENCHANTED_FLINT_AND_STEEL_GOLD,
                () -> ENCHANTED_FLINT_AND_STEEL_REDSTONE,
                () -> RAW_TITANIUM,
                () -> TITANIUM_INGOT,
                () -> TITANIUM_SWORD,
                () -> TITANIUM_PICKAXE,
                () -> TITANIUM_AXE,
                () -> TITANIUM_SHOVEL,
                () -> TITANIUM_HOE,
                () -> ENCHANTED_TITANIUM_SWORD,
                () -> ENCHANTED_TITANIUM_PICKAXE,
                () -> ENCHANTED_TITANIUM_AXE,
                () -> ENCHANTED_TITANIUM_SHOVEL,
                () -> ENCHANTED_TITANIUM_HOE,
                () -> RAW_ROMEUM,
                () -> ROMEUM_INGOT,
                () -> ROMEUM_SWORD,
                () -> ROMEUM_PICKAXE,
                () -> ROMEUM_AXE,
                () -> ROMEUM_SHOVEL,
                () -> ROMEUM_HOE,
                () -> ENCHANTED_ROMEUM_SWORD,
                () -> ENCHANTED_ROMEUM_PICKAXE,
                () -> ENCHANTED_ROMEUM_AXE,
                () -> ENCHANTED_ROMEUM_SHOVEL,
                () -> ENCHANTED_ROMEUM_HOE
        );

        BLOCKS.add(
                () -> WHITE_PUMPKIN,
                () -> CARVED_WHITE_PUMPKIN,
                () -> WHITE_JACK_O_LANTERN,
                () -> DEEPSLATE_TITANIUM_ORE,
                () -> TITANIUM_BLOCK,
                () -> NETHER_ROMEUM_ORE,
                () -> ROMEUM_BLOCK
        );

        TEMPlATES.add(
                () -> BLANK_BASIC_ARMOR_TEMPLATE,
                () -> BASIC_ARMOR_TEMPLATE,
                () -> BASIC_ARMOR_TEMPLATE_1,
                () -> BASIC_ARMOR_TEMPLATE_2,
                () -> BASIC_ARMOR_TEMPLATE_3,
                () -> BASIC_ARMOR_TEMPLATE_4,
                () -> BASIC_ARMOR_TEMPLATE_5,
                () -> BASIC_ARMOR_TEMPLATE_6,
                () -> BASIC_ARMOR_TEMPLATE_7,
                () -> BASIC_ARMOR_TEMPLATE_8,
                () -> BLANK_UPGRADE_SMITHING_TEMPLATE,
                () -> TITANIUM_UPGRADE_SMITHING_TEMPLATE,
                () -> TITANIUM_ENCHANT_SMITHING_TEMPLATE,
                () -> ROMEUM_UPGRADE_SMITHING_TEMPLATE,
                () -> ROMEUM_ENCHANT_SMITHING_TEMPLATE,
                () -> BLANK_ARMOR_TEMPLATE,
                () -> ARMOR_TEMPLATE_1,
                () -> ARMOR_TEMPLATE_2,
                () -> ARMOR_TEMPLATE_3,
                () -> ARMOR_TEMPLATE_4,
                () -> ARMOR_TEMPLATE_5,
                () -> ARMOR_TEMPLATE_6,
                () -> ARMOR_TEMPLATE_7,
                () -> ARMOR_TEMPLATE_8,
                () -> ARMOR_TEMPLATE_9,
                () -> ARMOR_TEMPLATE_10,
                () -> ARMOR_TEMPLATE_11,
                () -> ARMOR_TEMPLATE_12,
                () -> ARMOR_TEMPLATE_13,
                () -> ARMOR_TEMPLATE_14,
                () -> ARMOR_TEMPLATE_15,
                () -> ARMOR_TEMPLATE_16,
                () -> ARMOR_TEMPLATE_17,
                () -> ARMOR_TEMPLATE_18,
                () -> ARMOR_TEMPLATE_19,
                () -> ARMOR_TEMPLATE_20,
                () -> ARMOR_TEMPLATE_21,
                () -> ARMOR_TEMPLATE_22,
                () -> ARMOR_TEMPLATE_23,
                () -> ARMOR_TEMPLATE_24,
                () -> ARMOR_TEMPLATE_25,
                () -> ARMOR_TEMPLATE_26
        );
        ARMORS.add(
                () -> TITANIUM_HELMET,
                () -> TITANIUM_CHESTPLATE,
                () -> TITANIUM_LEGGINGS,
                () -> TITANIUM_BOOTS,
                () -> ENCHANTED_TITANIUM_HELMET,
                () -> ENCHANTED_TITANIUM_CHESTPLATE,
                () -> ENCHANTED_TITANIUM_LEGGINGS,
                () -> ENCHANTED_TITANIUM_BOOTS,
                () -> ROMEUM_HELMET,
                () -> ROMEUM_CHESTPLATE,
                () -> ROMEUM_LEGGINGS,
                () -> ROMEUM_BOOTS,
                () -> ENCHANTED_ROMEUM_HELMET,
                () -> ENCHANTED_ROMEUM_CHESTPLATE,
                () -> ENCHANTED_ROMEUM_LEGGINGS,
                () -> ENCHANTED_ROMEUM_BOOTS,
                () -> GABRIEL_HELMET,
                () -> GABRIEL_CHESTPLATE,
                () -> GABRIEL_LEGGINGS,
                () -> GABRIEL_BOOTS
        );

    }
    public static final TabSection ITEMS = TabSectionRegistry.register(STORYMODE_TAB.getId(), ResourceLocation.fromNamespaceAndPath(MOD_ID, "items"), 1);

    public static final TabSection BLOCKS = TabSectionRegistry.register(STORYMODE_TAB.getId(), ResourceLocation.fromNamespaceAndPath(MOD_ID, "blocks"), 2);

    public static final TabSection TEMPlATES = TabSectionRegistry.register(STORYMODE_TAB.getId(), ResourceLocation.fromNamespaceAndPath(MOD_ID, "templates"), 3);

    public static final TabSection ARMORS = TabSectionRegistry.register(STORYMODE_TAB.getId(), ResourceLocation.fromNamespaceAndPath(MOD_ID, "armors"), 4);
}