package net.xg787.xgsmi.registry.compat;

import net.mcexpanded.fancytabsections.FancyTabSections;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.xg787.xgsmi.StoryModeReborn;
import net.xg787.xgsmi.util.StoryModeRebornSection;
import net.xg787.xgsmi.util.StoryModeRebornTags;

import java.util.List;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.*;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.DEEPSLATE_TITANIUM_ORE;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.NETHER_ROMEUM_ORE;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.ROMEUM_BLOCK;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.TITANIUM_BLOCK;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.*;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.ENCHANTED_ROMEUM_BOOTS;

public class StoryModeRebornFancyTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STORYMODE_TAB = CREATIVE_MODE_TABS.register("storymode_tab", () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup.story_mode_reborn"))
        .icon(() -> ICON.get().getDefaultInstance())
        .build());

    public static void addCreativeSections(FMLClientSetupEvent event) {
        FancyTabSections.addSection(StoryModeReborn.path("storymode_tab"),
                new StoryModeRebornSection(StoryModeReborn.path("items"))
                        .add(WHITE_PUMPKIN_SEEDS)
                        .add(WHITE_PUMPKIN_PIE)
                        .add((registry) -> registry.lookup(Registries.ITEM).map(lookup -> lookup.get(StoryModeRebornTags.Items.CREATIVE_TAB_PRISMARINE_ITEMS).map(named -> named.stream().map(holder -> holder.value().getDefaultInstance()).toList()).orElse(List.of())).orElseGet(List::of))
                        .add((registry) -> registry.lookup(Registries.ITEM).map(lookup -> lookup.get(StoryModeRebornTags.Items.CREATIVE_TAB_ROYAL_ITEMS).map(named -> named.stream().map(holder -> holder.value().getDefaultInstance()).toList()).orElse(List.of())).orElseGet(List::of))
                        .add(ENCHANTED_FLINT_AND_STEEL_DIAMOND)
                        .add(ENCHANTED_FLINT_AND_STEEL_EMERALD)
                        .add(ENCHANTED_FLINT_AND_STEEL_GOLD)
                        .add(ENCHANTED_FLINT_AND_STEEL_REDSTONE)
                        .add(RAW_TITANIUM)
                        .add(TITANIUM_INGOT)
                        .add(TITANIUM_SWORD)
                        .add(TITANIUM_PICKAXE)
                        .add(TITANIUM_AXE)
                        .add(TITANIUM_SHOVEL)
                        .add(TITANIUM_HOE)
                        .add(ENCHANTED_TITANIUM_SWORD)
                        .add(ENCHANTED_TITANIUM_PICKAXE)
                        .add(ENCHANTED_TITANIUM_AXE)
                        .add(ENCHANTED_TITANIUM_SHOVEL)
                        .add(ENCHANTED_TITANIUM_HOE)
                        .add(RAW_ROMEUM)
                        .add(ROMEUM_INGOT)
                        .add(ROMEUM_SWORD)
                        .add(ROMEUM_PICKAXE)
                        .add(ROMEUM_AXE)
                        .add(ROMEUM_SHOVEL)
                        .add(ROMEUM_HOE)
                        .add(ENCHANTED_ROMEUM_SWORD)
                        .add(ENCHANTED_ROMEUM_PICKAXE)
                        .add(ENCHANTED_ROMEUM_AXE)
                        .add(ENCHANTED_ROMEUM_SHOVEL)
                        .add(ENCHANTED_ROMEUM_HOE)
        );
        FancyTabSections.addSection(StoryModeReborn.path("storymode_tab"),
                new StoryModeRebornSection(StoryModeReborn.path("blocks"))
                        .add(WHITE_PUMPKIN)
                        .add(CARVED_WHITE_PUMPKIN)
                        .add(WHITE_JACK_O_LANTERN)
                        .add(DEEPSLATE_TITANIUM_ORE)
                        .add(TITANIUM_BLOCK)
                        .add(NETHER_ROMEUM_ORE)
                        .add(ROMEUM_BLOCK)
        );
        FancyTabSections.addSection(StoryModeReborn.path("storymode_tab"),
                new StoryModeRebornSection(StoryModeReborn.path("templates"))
                        .add(BLANK_BASIC_ARMOR_TEMPLATE)
                        .add(BASIC_ARMOR_TEMPLATE)
                        .add(BASIC_ARMOR_TEMPLATE_1)
                        .add(BASIC_ARMOR_TEMPLATE_2)
                        .add(BASIC_ARMOR_TEMPLATE_3)
                        .add(BASIC_ARMOR_TEMPLATE_4)
                        .add(BASIC_ARMOR_TEMPLATE_5)
                        .add(BASIC_ARMOR_TEMPLATE_6)
                        .add(BASIC_ARMOR_TEMPLATE_7)
                        .add(BASIC_ARMOR_TEMPLATE_8)
                        .add(BLANK_UPGRADE_SMITHING_TEMPLATE)
                        .add(TITANIUM_UPGRADE_SMITHING_TEMPLATE)
                        .add(TITANIUM_ENCHANT_SMITHING_TEMPLATE)
                        .add(ROMEUM_UPGRADE_SMITHING_TEMPLATE)
                        .add(ROMEUM_ENCHANT_SMITHING_TEMPLATE)
                        .add(BLANK_ARMOR_TEMPLATE)
                        .add(ARMOR_TEMPLATE_1)
                        .add(ARMOR_TEMPLATE_2)
                        .add(ARMOR_TEMPLATE_3)
                        .add(ARMOR_TEMPLATE_4)
                        .add(ARMOR_TEMPLATE_5)
                        .add(ARMOR_TEMPLATE_6)
                        .add(ARMOR_TEMPLATE_7)
                        .add(ARMOR_TEMPLATE_8)
                        .add(ARMOR_TEMPLATE_9)
                        .add(ARMOR_TEMPLATE_10)
                        .add(ARMOR_TEMPLATE_11)
                        .add(ARMOR_TEMPLATE_12)
                        .add(ARMOR_TEMPLATE_13)
                        .add(ARMOR_TEMPLATE_14)
                        .add(ARMOR_TEMPLATE_15)
                        .add(ARMOR_TEMPLATE_16)
                        .add(ARMOR_TEMPLATE_17)
                        .add(ARMOR_TEMPLATE_18)
                        .add(ARMOR_TEMPLATE_19)
                        .add(ARMOR_TEMPLATE_20)
                        .add(ARMOR_TEMPLATE_21)
                        .add(ARMOR_TEMPLATE_22)
                        .add(ARMOR_TEMPLATE_23)
                        .add(ARMOR_TEMPLATE_24)
                        .add(ARMOR_TEMPLATE_25)
                        .add(ARMOR_TEMPLATE_26)
        );
        FancyTabSections.addSection(StoryModeReborn.path("storymode_tab"),
                new StoryModeRebornSection(StoryModeReborn.path("armors"))
                        .add(TITANIUM_HELMET)
                        .add(TITANIUM_CHESTPLATE)
                        .add(TITANIUM_LEGGINGS)
                        .add(TITANIUM_BOOTS)
                        .add(ENCHANTED_TITANIUM_HELMET)
                        .add(ENCHANTED_TITANIUM_CHESTPLATE)
                        .add(ENCHANTED_TITANIUM_LEGGINGS)
                        .add(ENCHANTED_TITANIUM_BOOTS)
                        .add(ROMEUM_HELMET)
                        .add(ROMEUM_CHESTPLATE)
                        .add(ROMEUM_LEGGINGS)
                        .add(ROMEUM_BOOTS)
                        .add(ENCHANTED_ROMEUM_HELMET)
                        .add(ENCHANTED_ROMEUM_CHESTPLATE)
                        .add(ENCHANTED_ROMEUM_LEGGINGS)
                        .add(ENCHANTED_ROMEUM_BOOTS)
                        .add((registry) -> registry.lookup(Registries.ITEM).map(lookup -> lookup.get(StoryModeRebornTags.Items.STORY_MODE_ARMOR).map(named -> named.stream().map(holder -> holder.value().getDefaultInstance()).toList()).orElse(List.of())).orElseGet(List::of))
        );
    }
}
