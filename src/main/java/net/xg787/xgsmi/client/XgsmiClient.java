package net.xg787.xgsmi.client;

import net.minecraft.core.component.DataComponents;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.xg787.xgsmi.Xgsmi;
import net.xg787.xgsmi.client.event.XgsmiClientEvents;
import net.xg787.xgsmi.client.model.ModelProperties;
import net.xg787.xgsmi.client.registry.XgsmiBlockRenderLayerMap;
import net.xg787.xgsmi.client.registry.XgsmiCreativeModeTabSections;

import static net.xg787.xgsmi.registry.XgsmiItems.TIPPED_PRISMARINE_ARROW;

@Mod(value = Xgsmi.MOD_ID, dist = Dist.CLIENT)
public class XgsmiClient {
    public XgsmiClient(IEventBus modEventBus) {
        modEventBus.addListener(XgsmiCreativeModeTabSections::addCreativeSections);
        modEventBus.addListener(XgsmiBlockRenderLayerMap::onClientSetup);
        modEventBus.addListener(ModelProperties::onClientSetup);
        modEventBus.addListener(this::registerItemColors);
        XgsmiClientEvents.ClientSetupEvent(modEventBus);
    }

    public void registerItemColors(RegisterColorHandlersEvent.Item event){
        event.getItemColors().register(
                (stack, color) -> color > 0
                        ? -1
                        : FastColor.ARGB32.opaque(stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).getColor()),
                TIPPED_PRISMARINE_ARROW
        );
    }
}
