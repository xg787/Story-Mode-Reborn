package net.xg787.xgsmi.registry;

import net.mcexpanded.fancytabsections.FancyTabSections;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.ItemLike;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.xg787.xgsmi.StoryModeReborn;
import net.xg787.xgsmi.util.StoryModeRebornSection;
import net.xg787.xgsmi.util.StoryModeRebornTags;

import java.util.List;

import static net.minecraft.world.item.CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;
import static net.minecraft.world.item.Items.*;
import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.*;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.*;

public class StoryModeRebornCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STORYMODE_TAB_ITEMS = CREATIVE_MODE_TABS.register("storymode_tab_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.story_mode_reborn_items"))
            .icon(() -> ROYAL_SWORD.get().getDefaultInstance())
            .displayItems((displayParameters, output) -> {
                output.accept(WHITE_PUMPKIN_SEEDS);
                output.accept(WHITE_PUMPKIN_PIE);
                output.acceptAll(displayParameters.holders().lookup(Registries.ITEM).map(lookup -> lookup.get(StoryModeRebornTags.Items.CREATIVE_TAB_PRISMARINE_ITEMS).map(named -> named.stream().map(holder -> holder.value().getDefaultInstance()).toList()).orElse(List.of())).orElseGet(List::of));
                output.acceptAll(displayParameters.holders().lookup(Registries.ITEM).map(lookup -> lookup.get(StoryModeRebornTags.Items.CREATIVE_TAB_ROYAL_ITEMS).map(named -> named.stream().map(holder -> holder.value().getDefaultInstance()).toList()).orElse(List.of())).orElseGet(List::of));
                output.accept(ENCHANTED_FLINT_AND_STEEL_DIAMOND);
                output.accept(ENCHANTED_FLINT_AND_STEEL_EMERALD);
                output.accept(ENCHANTED_FLINT_AND_STEEL_GOLD);
                output.accept(ENCHANTED_FLINT_AND_STEEL_REDSTONE);
                output.accept(RAW_TITANIUM);
                output.accept(TITANIUM_INGOT);
                output.accept(TITANIUM_SWORD);
                output.accept(TITANIUM_PICKAXE);
                output.accept(TITANIUM_AXE);
                output.accept(TITANIUM_SHOVEL);
                output.accept(TITANIUM_HOE);
                output.accept(ENCHANTED_TITANIUM_SWORD);
                output.accept(ENCHANTED_TITANIUM_PICKAXE);
                output.accept(ENCHANTED_TITANIUM_AXE);
                output.accept(ENCHANTED_TITANIUM_SHOVEL);
                output.accept(ENCHANTED_TITANIUM_HOE);
                output.accept(RAW_ROMEUM);
                output.accept(ROMEUM_INGOT);
                output.accept(ROMEUM_SWORD);
                output.accept(ROMEUM_PICKAXE);
                output.accept(ROMEUM_AXE);
                output.accept(ROMEUM_SHOVEL);
                output.accept(ROMEUM_HOE);
                output.accept(ENCHANTED_ROMEUM_SWORD);
                output.accept(ENCHANTED_ROMEUM_PICKAXE);
                output.accept(ENCHANTED_ROMEUM_AXE);
                output.accept(ENCHANTED_ROMEUM_SHOVEL);
                output.accept(ENCHANTED_ROMEUM_HOE);
            }).withSearchBar().hideTitle().build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STORYMODE_TAB_BLOCKS = CREATIVE_MODE_TABS.register("storymode_tab_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.story_mode_reborn_blocks"))
            .icon(() -> CARVED_WHITE_PUMPKIN.asItem().getDefaultInstance())
            .withTabsBefore(STORYMODE_TAB_ITEMS.getId())
            .displayItems((displayParameters, output) -> {
                output.accept(WHITE_PUMPKIN);
                output.accept(CARVED_WHITE_PUMPKIN);
                output.accept(WHITE_JACK_O_LANTERN);
                output.accept(DEEPSLATE_TITANIUM_ORE);
                output.accept(TITANIUM_BLOCK);
                output.accept(NETHER_ROMEUM_ORE);
                output.accept(ROMEUM_BLOCK);
            }).withSearchBar().hideTitle().build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STORYMODE_TAB_TEMPLATES = CREATIVE_MODE_TABS.register("storymode_tab_templates", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.story_mode_reborn_templates"))
            .icon(() -> ARMOR_TEMPLATE_23.get().getDefaultInstance())
            .withTabsBefore(STORYMODE_TAB_BLOCKS.getId())
            .displayItems((displayParameters, output) -> {
                output.accept(BLANK_BASIC_ARMOR_TEMPLATE);
                output.accept(BASIC_ARMOR_TEMPLATE);
                output.accept(BASIC_ARMOR_TEMPLATE_1);
                output.accept(BASIC_ARMOR_TEMPLATE_2);
                output.accept(BASIC_ARMOR_TEMPLATE_3);
                output.accept(BASIC_ARMOR_TEMPLATE_4);
                output.accept(BASIC_ARMOR_TEMPLATE_5);
                output.accept(BASIC_ARMOR_TEMPLATE_6);
                output.accept(BASIC_ARMOR_TEMPLATE_7);
                output.accept(BASIC_ARMOR_TEMPLATE_8);
                output.accept(BLANK_UPGRADE_SMITHING_TEMPLATE);
                output.accept(TITANIUM_UPGRADE_SMITHING_TEMPLATE);
                output.accept(TITANIUM_ENCHANT_SMITHING_TEMPLATE);
                output.accept(ROMEUM_UPGRADE_SMITHING_TEMPLATE);
                output.accept(ROMEUM_ENCHANT_SMITHING_TEMPLATE);
                output.accept(BLANK_ARMOR_TEMPLATE);
                output.accept(ARMOR_TEMPLATE_1);
                output.accept(ARMOR_TEMPLATE_2);
                output.accept(ARMOR_TEMPLATE_3);
                output.accept(ARMOR_TEMPLATE_4);
                output.accept(ARMOR_TEMPLATE_5);
                output.accept(ARMOR_TEMPLATE_6);
                output.accept(ARMOR_TEMPLATE_7);
                output.accept(ARMOR_TEMPLATE_8);
                output.accept(ARMOR_TEMPLATE_9);
                output.accept(ARMOR_TEMPLATE_10);
                output.accept(ARMOR_TEMPLATE_11);
                output.accept(ARMOR_TEMPLATE_12);
                output.accept(ARMOR_TEMPLATE_13);
                output.accept(ARMOR_TEMPLATE_14);
                output.accept(ARMOR_TEMPLATE_15);
                output.accept(ARMOR_TEMPLATE_16);
                output.accept(ARMOR_TEMPLATE_17);
                output.accept(ARMOR_TEMPLATE_18);
                output.accept(ARMOR_TEMPLATE_19);
                output.accept(ARMOR_TEMPLATE_20);
                output.accept(ARMOR_TEMPLATE_21);
                output.accept(ARMOR_TEMPLATE_22);
                output.accept(ARMOR_TEMPLATE_23);
                output.accept(ARMOR_TEMPLATE_24);
                output.accept(ARMOR_TEMPLATE_25);
                output.accept(ARMOR_TEMPLATE_26);
            }).withSearchBar().hideTitle().build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STORYMODE_TAB_ARMOR = CREATIVE_MODE_TABS.register("storymode_tab_armor", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.story_mode_reborn_armor"))
            .icon(() -> GABRIEL_CHESTPLATE.get().getDefaultInstance())
            .withTabsBefore(STORYMODE_TAB_TEMPLATES.getId())
            .displayItems((displayParameters, output) -> {
                output.accept(TITANIUM_HELMET);
                output.accept(TITANIUM_CHESTPLATE);
                output.accept(TITANIUM_LEGGINGS);
                output.accept(TITANIUM_BOOTS);
                output.accept(ENCHANTED_TITANIUM_HELMET);
                output.accept(ENCHANTED_TITANIUM_CHESTPLATE);
                output.accept(ENCHANTED_TITANIUM_LEGGINGS);
                output.accept(ENCHANTED_TITANIUM_BOOTS);
                output.accept(ROMEUM_HELMET);
                output.accept(ROMEUM_CHESTPLATE);
                output.accept(ROMEUM_LEGGINGS);
                output.accept(ROMEUM_BOOTS);
                output.accept(ENCHANTED_ROMEUM_HELMET);
                output.accept(ENCHANTED_ROMEUM_CHESTPLATE);
                output.accept(ENCHANTED_ROMEUM_LEGGINGS);
                output.accept(ENCHANTED_ROMEUM_BOOTS);
                output.acceptAll(displayParameters.holders().lookup(Registries.ITEM).map(lookup -> lookup.get(StoryModeRebornTags.Items.STORY_MODE_ARMOR).map(named -> named.stream().map(holder -> holder.value().getDefaultInstance()).toList()).orElse(List.of())).orElseGet(List::of));
            }).withSearchBar().hideTitle().build());

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.insertAfter(PUMPKIN_SEEDS.getDefaultInstance(), WHITE_PUMPKIN_SEEDS.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(JACK_O_LANTERN.getDefaultInstance(), WHITE_PUMPKIN.get().asItem().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(WHITE_PUMPKIN.get().asItem().getDefaultInstance(), CARVED_WHITE_PUMPKIN.get().asItem().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(CARVED_WHITE_PUMPKIN.get().asItem().getDefaultInstance(), WHITE_JACK_O_LANTERN.get().asItem().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.insertBefore(IRON_SHOVEL.getDefaultInstance(), PRISMARINE_SHOVEL.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(PRISMARINE_SHOVEL.get().getDefaultInstance(), PRISMARINE_PICKAXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(PRISMARINE_PICKAXE.get().getDefaultInstance(), PRISMARINE_AXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(PRISMARINE_AXE.get().getDefaultInstance(), PRISMARINE_HOE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(IRON_HOE.getDefaultInstance(), ROYAL_SHOVEL.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ROYAL_SHOVEL.get().getDefaultInstance(), ROYAL_PICKAXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ROYAL_PICKAXE.get().getDefaultInstance(), ROYAL_AXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ROYAL_AXE.get().getDefaultInstance(), ROYAL_HOE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(NETHERITE_HOE.getDefaultInstance(), TITANIUM_SHOVEL.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(TITANIUM_SHOVEL.get().getDefaultInstance(), TITANIUM_PICKAXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(TITANIUM_PICKAXE.get().getDefaultInstance(), TITANIUM_AXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(TITANIUM_AXE.get().getDefaultInstance(), TITANIUM_HOE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(TITANIUM_HOE.get().getDefaultInstance(), ENCHANTED_TITANIUM_SHOVEL.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ENCHANTED_TITANIUM_SHOVEL.get().getDefaultInstance(), ENCHANTED_TITANIUM_PICKAXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ENCHANTED_TITANIUM_PICKAXE.get().getDefaultInstance(), ENCHANTED_TITANIUM_AXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ENCHANTED_TITANIUM_AXE.get().getDefaultInstance(), ENCHANTED_TITANIUM_HOE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(ENCHANTED_TITANIUM_HOE.get().getDefaultInstance(), ROMEUM_SHOVEL.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ROMEUM_SHOVEL.get().getDefaultInstance(), ROMEUM_PICKAXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ROMEUM_PICKAXE.get().getDefaultInstance(), ROMEUM_AXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ROMEUM_AXE.get().getDefaultInstance(), ROMEUM_HOE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(ROMEUM_HOE.get().getDefaultInstance(), ENCHANTED_ROMEUM_SHOVEL.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ENCHANTED_ROMEUM_SHOVEL.get().getDefaultInstance(), ENCHANTED_ROMEUM_PICKAXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ENCHANTED_ROMEUM_PICKAXE.get().getDefaultInstance(), ENCHANTED_ROMEUM_AXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ENCHANTED_ROMEUM_AXE.get().getDefaultInstance(), ENCHANTED_ROMEUM_HOE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(FISHING_ROD.getDefaultInstance(), PRISMARINE_FISHING_ROD.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(FLINT_AND_STEEL.getDefaultInstance(), ENCHANTED_FLINT_AND_STEEL_DIAMOND.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ENCHANTED_FLINT_AND_STEEL_DIAMOND.get().getDefaultInstance(), ENCHANTED_FLINT_AND_STEEL_EMERALD.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ENCHANTED_FLINT_AND_STEEL_EMERALD.get().getDefaultInstance(), ENCHANTED_FLINT_AND_STEEL_GOLD.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ENCHANTED_FLINT_AND_STEEL_GOLD.get().getDefaultInstance(), ENCHANTED_FLINT_AND_STEEL_REDSTONE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.insertBefore(IRON_SWORD.getDefaultInstance(), PRISMARINE_SWORD.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertBefore(IRON_AXE.getDefaultInstance(), PRISMARINE_AXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(IRON_SWORD.getDefaultInstance(), ROYAL_SWORD.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(IRON_AXE.getDefaultInstance(), ROYAL_AXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(NETHERITE_SWORD.getDefaultInstance(), TITANIUM_SWORD.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(NETHERITE_AXE.getDefaultInstance(), TITANIUM_AXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(TITANIUM_SWORD.get().getDefaultInstance(), ENCHANTED_TITANIUM_SWORD.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(TITANIUM_AXE.get().getDefaultInstance(), ENCHANTED_TITANIUM_AXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(ENCHANTED_TITANIUM_SWORD.get().getDefaultInstance(), ROMEUM_SWORD.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ENCHANTED_TITANIUM_AXE.get().getDefaultInstance(), ROMEUM_AXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(ROMEUM_SWORD.get().getDefaultInstance(), ENCHANTED_ROMEUM_SWORD.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(ROMEUM_AXE.get().getDefaultInstance(), ENCHANTED_ROMEUM_AXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(BOW.getDefaultInstance(), PRISMARINE_BOW.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(CROSSBOW.getDefaultInstance(), PRISMARINE_CROSSBOW.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

            event.insertAfter(ARROW.getDefaultInstance(), PRISMARINE_ARROW.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.getParameters().holders()
                    .lookup(Registries.POTION)
                    .ifPresent(
                            potions -> generatePotionEffectTypes(
                                    event,
                                    potions,
                                    TIPPED_PRISMARINE_ARROW.get(),
                                    PARENT_AND_SEARCH_TABS,
                                    event.getParameters().enabledFeatures()
                            )
                    );
        }

        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.insertAfter(PUMPKIN_PIE.getDefaultInstance(), WHITE_PUMPKIN_PIE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.insertAfter(ANCIENT_DEBRIS.getDefaultInstance(), RAW_TITANIUM.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(RAW_TITANIUM.get().getDefaultInstance(), RAW_ROMEUM.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(NETHERITE_INGOT.getDefaultInstance(), TITANIUM_INGOT.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(TITANIUM_INGOT.get().getDefaultInstance(), ROMEUM_INGOT.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(STICK.getDefaultInstance(), PRISMARINE_ROD.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
        }
    }

    public static void addTippedArrows(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.getParameters().holders()
                    .lookup(Registries.POTION)
                    .ifPresent(
                            potions -> generatePotionEffectTypes(
                                    event,
                                    potions,
                                    TIPPED_PRISMARINE_ARROW.get(),
                                    PARENT_AND_SEARCH_TABS,
                                    event.getParameters().enabledFeatures()
                            )
                    );
        }
    }

    private static void generatePotionEffectTypes(BuildCreativeModeTabContentsEvent event, HolderLookup<Potion> potions, Item item, CreativeModeTab.TabVisibility tabVisibility, FeatureFlagSet requiredFeatures) {
        potions.listElements()
                .filter(p_337926_ -> p_337926_.value().isEnabled(requiredFeatures))
                .map(p_330083_ -> PotionContents.createItemStack(item, p_330083_))
                .forEach(p_270000_ -> event.accept(p_270000_, tabVisibility));
    }
}
