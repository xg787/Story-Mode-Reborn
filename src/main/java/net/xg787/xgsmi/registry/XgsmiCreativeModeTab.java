package net.xg787.xgsmi.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.xg787.sectioned_creative_tab_lib.tab.sections.TabSection;
import net.xg787.sectioned_creative_tab_lib.tab.sections.TabSectionRegistry;

import static net.xg787.xgsmi.Xgsmi.MOD_ID;
import static net.xg787.xgsmi.registry.XgsmiBlocks.*;
import static net.xg787.xgsmi.registry.XgsmiItems.*;

public class XgsmiCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STORYMODE_TAB = CREATIVE_MODE_TABS.register("storymode_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.xgsmi"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ICON.get().getDefaultInstance())
            .build());

    public static void addCreativeSections(FMLClientSetupEvent event) {
        BLOCKS.add(
                () -> TEST
        );
        TEMPlATES.add(
                () -> BLANK_UPGRADE_SMITHING_TEMPLATE,
                () -> TITANIUM_UPGRADE_SMITHING_TEMPLATE,
                () -> ROMEUM_UPGRADE_SMITHING_TEMPLATE
        );
        //TEMPlATES.addStack(() -> {ItemStack stack = new ItemStack(item.get());return stack;});
    }


    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        //if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            //event.accept(EXAMPLE_BLOCK_ITEM);
        //}
    }
    public static final TabSection ITEMS = TabSectionRegistry.register(STORYMODE_TAB.getId(), ResourceLocation.fromNamespaceAndPath(MOD_ID, "items"), 1);

    public static final TabSection BLOCKS = TabSectionRegistry.register(STORYMODE_TAB.getId(), ResourceLocation.fromNamespaceAndPath(MOD_ID, "blocks"), 2);

    public static final TabSection TEMPlATES = TabSectionRegistry.register(STORYMODE_TAB.getId(), ResourceLocation.fromNamespaceAndPath(MOD_ID, "templates"), 3);

    public static final TabSection ARMOR = TabSectionRegistry.register(STORYMODE_TAB.getId(), ResourceLocation.fromNamespaceAndPath(MOD_ID, "armor"), 4);
}
