package net.xg787.xgsmi;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.EnderManAngerEvent;
import net.xg787.xgsmi.registry.XgsmiBlocks;
import net.xg787.xgsmi.registry.XgsmiCreativeModeTab;
import net.xg787.xgsmi.registry.XgsmiEntities;
import net.xg787.xgsmi.registry.XgsmiItems;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import static net.xg787.xgsmi.registry.XgsmiBlocks.CARVED_WHITE_PUMPKIN;

@Mod(Xgsmi.MOD_ID)
public class Xgsmi {
    public static final String MOD_ID = "xgsmi";

    public Xgsmi(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
        XgsmiBlocks.BLOCKS.register(modEventBus);
        XgsmiItems.ITEMS.register(modEventBus);
        XgsmiEntities.ENTITY_TYPES.register(modEventBus);
        XgsmiCreativeModeTab.CREATIVE_MODE_TABS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(XgsmiCreativeModeTab::addCreative);
    }

    @SubscribeEvent
    public void preventEnderManAnger(EnderManAngerEvent event) {
        if (event.getPlayer() instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.HEAD).is(CARVED_WHITE_PUMPKIN.asItem())) {
                event.setCanceled(true);
            }
        }
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
