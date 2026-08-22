package net.xg787.xgsmi.registry;

import net.mcexpanded.fancytabsections.FancyTabSections;
import net.mcexpanded.fancytabsections.Section.SectionTextured;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.xg787.xgsmi.StoryModeReborn;
import net.xg787.xgsmi.util.StoryModeRebornSection;

import java.util.List;
import java.util.function.Function;

import static net.minecraft.world.item.CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;
import static net.minecraft.world.item.Items.*;
import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.*;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.*;

public class StoryModeRebornCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STORYMODE_TAB = CREATIVE_MODE_TABS.register("storymode_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.story_mode_reborn"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ICON.get().getDefaultInstance())
            .build());
    
    public static void addCreativeSections(FMLClientSetupEvent event) {
        FancyTabSections.addSection(StoryModeReborn.path("storymode_tab"),
                new StoryModeRebornSection(StoryModeReborn.path("items"))
                        .setTextColor(0xffffeb8c)
                        .add(WHITE_PUMPKIN_SEEDS)
                        .add(WHITE_PUMPKIN_PIE)
                        .add(PRISMARINE_ROD)
                        .add(PRISMARINE_FISHING_ROD)
                        .add(PRISMARINE_SWORD)
                        .add(PRISMARINE_PICKAXE)
                        .add(PRISMARINE_AXE)
                        .add(PRISMARINE_SHOVEL)
                        .add(PRISMARINE_HOE)
                        .add(PRISMARINE_BOW)
                        .add(PRISMARINE_CROSSBOW)
                        .add(PRISMARINE_ARROW)
                        .add(ROYAL_SWORD)
                        .add(ROYAL_PICKAXE)
                        .add(ROYAL_AXE)
                        .add(ROYAL_SHOVEL)
                        .add(ROYAL_HOE)
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
                        .setTextColor(0xffffeb8c)
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
                        .setTextColor(0xffffeb8c)
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
                        .setTextColor(0xffffeb8c)
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
                        .add(GABRIEL_HELMET)
                        .add(GABRIEL_CHESTPLATE)
                        .add(GABRIEL_LEGGINGS)
                        .add(GABRIEL_BOOTS)
        );
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.insertAfter(PUMPKIN_SEEDS.getDefaultInstance(), WHITE_PUMPKIN_SEEDS.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(JACK_O_LANTERN.getDefaultInstance(), WHITE_PUMPKIN.get().asItem().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(WHITE_PUMPKIN.get().asItem().getDefaultInstance(), CARVED_WHITE_PUMPKIN.get().asItem().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(CARVED_WHITE_PUMPKIN.get().asItem().getDefaultInstance(), WHITE_JACK_O_LANTERN.get().asItem().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.insertAfter(STONE_HOE.getDefaultInstance(), PRISMARINE_SHOVEL.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
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
            event.insertAfter(STONE_SWORD.getDefaultInstance(), PRISMARINE_SWORD.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);
            event.insertAfter(STONE_AXE.getDefaultInstance(), PRISMARINE_AXE.get().getDefaultInstance(), PARENT_AND_SEARCH_TABS);

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
