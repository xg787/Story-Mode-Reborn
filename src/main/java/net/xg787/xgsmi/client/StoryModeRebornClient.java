package net.xg787.xgsmi.client;

import net.minecraft.core.component.DataComponents;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.xg787.xgsmi.StoryModeReborn;
import net.xg787.xgsmi.client.event.StoryModeRebornClientEvents;
import net.xg787.xgsmi.client.model.ModelProperties;
import net.xg787.xgsmi.client.registry.StoryModeRebornBlockRenderLayerMap;
import net.xg787.xgsmi.client.registry.StoryModeRebornCreativeModeTabSections;

import static net.xg787.xgsmi.registry.StoryModeRebornItems.TIPPED_PRISMARINE_ARROW;

@Mod(value = StoryModeReborn.MOD_ID, dist = Dist.CLIENT)
public class StoryModeRebornClient {
    public StoryModeRebornClient(IEventBus modEventBus) {
        modEventBus.addListener(StoryModeRebornCreativeModeTabSections::addCreativeSections);
        modEventBus.addListener(StoryModeRebornBlockRenderLayerMap::onClientSetup);
        modEventBus.addListener(ModelProperties::onClientSetup);
        modEventBus.addListener(this::registerItemColors);
        StoryModeRebornClientEvents.ClientSetupEvent(modEventBus);
    }

    public void registerItemColors(RegisterColorHandlersEvent.Item event){
        event.getItemColors().register((stack, color) -> color > 0 ? -1 : FastColor.ARGB32.opaque(stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).getColor()), TIPPED_PRISMARINE_ARROW);
    }
}
