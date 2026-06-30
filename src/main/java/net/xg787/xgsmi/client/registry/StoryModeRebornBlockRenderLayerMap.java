package net.xg787.xgsmi.client.registry;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.List;

import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.*;


public class StoryModeRebornBlockRenderLayerMap {
    public static void onClientSetup(FMLClientSetupEvent event) {
        for (var blockSupplier : List.of(ATTACHED_WHITE_PUMPKIN_STEM, WHITE_PUMPKIN_STEM)) {
            ItemBlockRenderTypes.setRenderLayer(blockSupplier.get(), RenderType.cutout());
        }
    }
}
