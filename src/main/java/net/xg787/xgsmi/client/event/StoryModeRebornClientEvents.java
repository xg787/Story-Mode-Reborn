package net.xg787.xgsmi.client.event;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.xg787.xgsmi.client.ArmorClientExtension;
import net.xg787.xgsmi.client.model.armor.GabrielArmorModel;
import net.xg787.xgsmi.client.provider.SimpleModelProvider;
import net.xg787.xgsmi.client.renderer.entity.TippablePrismarineArrowRenderer;
import net.xg787.xgsmi.registry.StoryModeRebornEntities;
import net.xg787.xgsmi.registry.StoryModeRebornItems;

public class StoryModeRebornClientEvents {
    public static void ClientSetupEvent(IEventBus modEventBus) {
        modEventBus.addListener(StoryModeRebornClientEvents::registerEntityRenderers);
        modEventBus.addListener(StoryModeRebornClientEvents::registerClientExtensions);
    }

    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(StoryModeRebornEntities.PRISMARINE_ARROW.get(), TippablePrismarineArrowRenderer::new);
    }

    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new ArmorClientExtension(new SimpleModelProvider(GabrielArmorModel::createBodyLayer, GabrielArmorModel::new)), new Item[]{StoryModeRebornItems.GABRIEL_HELMET.get(), StoryModeRebornItems.GABRIEL_CHESTPLATE.get(), StoryModeRebornItems.GABRIEL_LEGGINGS.get(), StoryModeRebornItems.GABRIEL_BOOTS.get()});
    }
}
