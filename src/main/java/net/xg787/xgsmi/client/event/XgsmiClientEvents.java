package net.xg787.xgsmi.client.event;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.xg787.xgsmi.client.renderer.entity.TippablePrismarineArrowRenderer;
import net.xg787.xgsmi.registry.XgsmiEntities;

public class XgsmiClientEvents {
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(XgsmiEntities.PRISMARINE_ARROW.get(), TippablePrismarineArrowRenderer::new);
    }
}
