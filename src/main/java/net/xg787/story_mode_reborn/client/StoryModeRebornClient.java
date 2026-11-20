package net.xg787.story_mode_reborn.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.xg787.story_mode_reborn.StoryModeReborn;
import net.xg787.story_mode_reborn.StoryModeRebornConfig;
import net.xg787.story_mode_reborn.client.compat.VanillaBackport.StoryModeRebornVB;
import net.xg787.story_mode_reborn.client.model.ModelProperties;
import net.xg787.story_mode_reborn.client.model.RedstoneHeartModel;
import net.xg787.story_mode_reborn.client.model.armor.GabrielArmorModel;
import net.xg787.story_mode_reborn.client.provider.SimpleModelProvider;
import net.xg787.story_mode_reborn.client.renderer.entity.RedstoneHeartRenderer;
import net.xg787.story_mode_reborn.client.renderer.entity.TippablePrismarineArrowRenderer;
import net.xg787.story_mode_reborn.client.renderer.item.RedstoneHeartItemRenderer;
import net.xg787.story_mode_reborn.registry.StoryModeRebornCreativeModeTab;
import net.xg787.story_mode_reborn.registry.StoryModeRebornEntities;
import net.xg787.story_mode_reborn.registry.StoryModeRebornItems;
import net.xg787.story_mode_reborn.registry.compat.StoryModeRebornFancyTab;

import static net.xg787.story_mode_reborn.registry.StoryModeRebornItems.TIPPED_PRISMARINE_ARROW;

@Mod(value = StoryModeReborn.MOD_ID, dist = Dist.CLIENT)
public class StoryModeRebornClient {

    public static final ModelLayerLocation REDSTONE_HEART_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(StoryModeReborn.MOD_ID, "block"), "main");

    public static final ResourceLocation STORY_MODE_REBORN_SHEET = ResourceLocation.fromNamespaceAndPath(StoryModeReborn.MOD_ID, "textures/atlas/story_mode_reborn");
    private static final RenderType STORY_MODE_REBORN_SHEET_TYPE = RenderType.entityCutoutNoCull(STORY_MODE_REBORN_SHEET);

    public StoryModeRebornClient(IEventBus modEventBus, ModContainer modContainer) {
        if (StoryModeRebornConfig.ADD_ITEMS_TO_VANILLA_TABS.get()) {
            modEventBus.addListener(StoryModeRebornCreativeModeTab::addCreative);
        } else {
            modEventBus.addListener(StoryModeRebornCreativeModeTab::addTippedArrows);
        }
        if (ModList.get().isLoaded("vanillabackport")) {
            StoryModeRebornVB.VanillaBackport();
        }
        if (ModList.get().isLoaded("fancytabsections")) {
            modEventBus.addListener(StoryModeRebornFancyTab::addCreativeSections);
        }
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        modEventBus.addListener(this::registerRegisterMaterialAtlases);
        modEventBus.addListener(this::registerClientExtensions);
        modEventBus.addListener(ModelProperties::onClientSetup);
        modEventBus.addListener(this::registerEntityRenderers);
        modEventBus.addListener(this::registerRenderBuffers);
        modEventBus.addListener(this::registerItemColors);
        modEventBus.addListener(this::registerLayers);
    }

    public void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new ArmorClientExtension(new SimpleModelProvider(GabrielArmorModel::createBodyLayer, GabrielArmorModel::new)), StoryModeRebornItems.GABRIEL_HELMET.get(), StoryModeRebornItems.GABRIEL_CHESTPLATE.get(), StoryModeRebornItems.GABRIEL_LEGGINGS.get(), StoryModeRebornItems.GABRIEL_BOOTS.get());
        event.registerItem(RedstoneHeartItemRenderer.getItemRenderProperties(), StoryModeRebornItems.REDSTONE_HEART_ITEM.get());
    }

    public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(StoryModeRebornEntities.PRISMARINE_ARROW.get(), TippablePrismarineArrowRenderer::new);
        event.registerEntityRenderer(StoryModeRebornEntities.REDSTONE_HEART_ENTITY.get(), RedstoneHeartRenderer::new);
    }

    public void registerRenderBuffers(RegisterRenderBuffersEvent event) {
        event.registerRenderBuffer(STORY_MODE_REBORN_SHEET_TYPE);
    }

    public void registerRegisterMaterialAtlases(RegisterMaterialAtlasesEvent event) {
        event.register(ResourceLocation.fromNamespaceAndPath(StoryModeReborn.MOD_ID, "textures/atlas/story_mode_reborn"), STORY_MODE_REBORN_SHEET);
    }

    public void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, color) -> color > 0 ? -1 : FastColor.ARGB32.opaque(stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).getColor()), TIPPED_PRISMARINE_ARROW);
    }

    public void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(REDSTONE_HEART_LAYER, RedstoneHeartModel::createBlockLayer);
    }
}
