package net.xg787.xgsmi.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.xg787.xgsmi.StoryModeReborn;
import net.xg787.xgsmi.StoryModeRebornConfig;
import net.xg787.xgsmi.client.model.ModelProperties;
import net.xg787.xgsmi.client.model.armor.GabrielArmorModel;
import net.xg787.xgsmi.client.provider.SimpleModelProvider;
import net.xg787.xgsmi.client.renderer.entity.TippablePrismarineArrowRenderer;
import net.xg787.xgsmi.registry.StoryModeRebornCreativeModeTab;
import net.xg787.xgsmi.registry.StoryModeRebornEntities;
import net.xg787.xgsmi.registry.StoryModeRebornItems;

import java.util.List;

import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.*;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.ENCHANTED_FIRE_DIAMOND_EXTENSION;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.ENCHANTED_FIRE_EMERALD;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.ENCHANTED_FIRE_EMERALD_EXTENSION;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.ENCHANTED_FIRE_GOLD;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.ENCHANTED_FIRE_GOLD_EXTENSION;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.ENCHANTED_FIRE_REDSTONE;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.ENCHANTED_FIRE_REDSTONE_EXTENSION;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.TIPPED_PRISMARINE_ARROW;

@Mod(value = StoryModeReborn.MOD_ID, dist = Dist.CLIENT)
public class StoryModeRebornClient {
    public StoryModeRebornClient(IEventBus modEventBus, ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        modEventBus.addListener(StoryModeRebornCreativeModeTab::addCreativeSections);
        if (StoryModeRebornConfig.ADD_ITEMS_TO_VANILLA_TABS.get()){
            modEventBus.addListener(StoryModeRebornCreativeModeTab::addCreative);
        } else {
            modEventBus.addListener(StoryModeRebornCreativeModeTab::addTippedArrows);
        }
        modEventBus.addListener(ModelProperties::onClientSetup);
        modEventBus.addListener(this::registerClientExtensions);
        modEventBus.addListener(this::registerEntityRenderers);
        modEventBus.addListener(this::registerItemColors);
        modEventBus.addListener(this::onClientSetup);
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        for (var blockSupplier : List.of(
                ATTACHED_WHITE_PUMPKIN_STEM,
                WHITE_PUMPKIN_STEM,
                ENCHANTED_FIRE_DIAMOND,
                ENCHANTED_FIRE_DIAMOND_EXTENSION,
                ENCHANTED_FIRE_EMERALD,
                ENCHANTED_FIRE_EMERALD_EXTENSION,
                ENCHANTED_FIRE_GOLD,
                ENCHANTED_FIRE_GOLD_EXTENSION,
                ENCHANTED_FIRE_REDSTONE,
                ENCHANTED_FIRE_REDSTONE_EXTENSION)) {
            ItemBlockRenderTypes.setRenderLayer(blockSupplier.get(), RenderType.cutout());
        }
    }

    public void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new ArmorClientExtension(new SimpleModelProvider(GabrielArmorModel::createBodyLayer, GabrielArmorModel::new)), StoryModeRebornItems.GABRIEL_HELMET.get(), StoryModeRebornItems.GABRIEL_CHESTPLATE.get(), StoryModeRebornItems.GABRIEL_LEGGINGS.get(), StoryModeRebornItems.GABRIEL_BOOTS.get());
    }

    public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(StoryModeRebornEntities.PRISMARINE_ARROW.get(), TippablePrismarineArrowRenderer::new);
    }

    public void registerItemColors(RegisterColorHandlersEvent.Item event){
        event.getItemColors().register((stack, color) -> color > 0 ? -1 : FastColor.ARGB32.opaque(stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).getColor()), TIPPED_PRISMARINE_ARROW);
    }
}
