package net.xg787.xgsmi.client.event;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.xg787.xgsmi.client.ArmorClientExtension;
import net.xg787.xgsmi.client.model.armor.GabrielArmorModel;
import net.xg787.xgsmi.client.provider.SimpleModelProvider;
import net.xg787.xgsmi.client.renderer.entity.TippablePrismarineArrowRenderer;
import net.xg787.xgsmi.registry.XgsmiEntities;
import net.xg787.xgsmi.registry.XgsmiItems;

public class XgsmiClientEvents {
    public static void ClientSetupEvent(IEventBus modEventBus) {
        modEventBus.addListener(XgsmiClientEvents::registerEntityRenderers);
        modEventBus.addListener(XgsmiClientEvents::registerClientExtensions);
    }
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(XgsmiEntities.PRISMARINE_ARROW.get(), TippablePrismarineArrowRenderer::new);
    }

    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new ArmorClientExtension(new SimpleModelProvider(GabrielArmorModel::createBodyLayer, GabrielArmorModel::new)), new Item[]{XgsmiItems.GABRIEL_HELMET.get(), XgsmiItems.GABRIEL_CHESTPLATE.get(), XgsmiItems.GABRIEL_LEGGINGS.get(), XgsmiItems.GABRIEL_BOOTS.get()});
    }
}
