package net.xg787.xgsmi.registry;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.world.item.CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;
import static net.minecraft.world.item.Items.*;
import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.*;

public class StoryModeRebornCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STORYMODE_TAB = CREATIVE_MODE_TABS.register("storymode_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.story_mode_reborn"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ICON.get().getDefaultInstance())
            .build());

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
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
                            p_337917_ -> generatePotionEffectTypes(
                                    event,
                                    p_337917_,
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
