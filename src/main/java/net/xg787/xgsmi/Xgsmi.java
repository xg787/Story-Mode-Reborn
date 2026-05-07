package net.xg787.xgsmi;

import net.xg787.xgsmi.registry.XgsmiBlocks;
import net.xg787.xgsmi.registry.XgsmiCreativeModeTab;
import net.xg787.xgsmi.registry.XgsmiItems;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(Xgsmi.MOD_ID)
public class Xgsmi {
    public static final String MOD_ID = "xgsmi";

    public Xgsmi(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
        XgsmiBlocks.BLOCKS.register(modEventBus);
        XgsmiItems.ITEMS.register(modEventBus);
        XgsmiCreativeModeTab.CREATIVE_MODE_TABS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(XgsmiCreativeModeTab::addCreative);
        modEventBus.addListener(XgsmiCreativeModeTab::addCreativeSections);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
