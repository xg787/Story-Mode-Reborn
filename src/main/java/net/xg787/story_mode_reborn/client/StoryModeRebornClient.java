package net.xg787.story_mode_reborn.client;

import net.minecraft.core.component.DataComponents;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.xg787.story_mode_reborn.StoryModeReborn;
import net.xg787.story_mode_reborn.StoryModeRebornConfig;
import net.xg787.story_mode_reborn.client.compat.VanillaBackport.StoryModeRebornVB;
import net.xg787.story_mode_reborn.client.model.ModelProperties;
import net.xg787.story_mode_reborn.client.model.armor.GabrielArmorModel;
import net.xg787.story_mode_reborn.client.provider.SimpleModelProvider;
import net.xg787.story_mode_reborn.client.renderer.entity.TippablePrismarineArrowRenderer;
import net.xg787.story_mode_reborn.registry.StoryModeRebornCreativeModeTab;
import net.xg787.story_mode_reborn.registry.StoryModeRebornEntities;
import net.xg787.story_mode_reborn.registry.StoryModeRebornItems;
import net.xg787.story_mode_reborn.registry.compat.StoryModeRebornFancyTab;

import static net.xg787.story_mode_reborn.registry.StoryModeRebornItems.TIPPED_PRISMARINE_ARROW;

@Mod(value = StoryModeReborn.MOD_ID, dist = Dist.CLIENT)
public class StoryModeRebornClient {
    public StoryModeRebornClient(IEventBus modEventBus, ModContainer modContainer) {
        if (StoryModeRebornConfig.ADD_ITEMS_TO_VANILLA_TABS.get()){
            modEventBus.addListener(StoryModeRebornCreativeModeTab::addCreative);
        } else {
            modEventBus.addListener(StoryModeRebornCreativeModeTab::addTippedArrows);
        }
        if (ModList.get().isLoaded("vanillabackport")){
            StoryModeRebornVB.VanillaBackport();
        }
        if (ModList.get().isLoaded("fancytabsections")) {
            modEventBus.addListener(StoryModeRebornFancyTab::addCreativeSections);
        }
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        modEventBus.addListener(ModelProperties::onClientSetup);
        modEventBus.addListener(this::registerClientExtensions);
        modEventBus.addListener(this::registerEntityRenderers);
        modEventBus.addListener(this::registerItemColors);
    }

    public void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new ArmorClientExtension(new SimpleModelProvider(GabrielArmorModel::createBodyLayer, GabrielArmorModel::new)), StoryModeRebornItems.GABRIEL_HELMET.get(), StoryModeRebornItems.GABRIEL_CHESTPLATE.get(), StoryModeRebornItems.GABRIEL_LEGGINGS.get(), StoryModeRebornItems.GABRIEL_BOOTS.get());
    }

    public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(StoryModeRebornEntities.PRISMARINE_ARROW.get(), TippablePrismarineArrowRenderer::new);
    }

    public void registerItemColors(RegisterColorHandlersEvent.Item event){
        event.register((stack, color) -> color > 0 ? -1 : FastColor.ARGB32.opaque(stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).getColor()), TIPPED_PRISMARINE_ARROW);
    }
}
