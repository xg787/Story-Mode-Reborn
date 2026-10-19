package net.xg787.xgsmi;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.event.entity.living.EnderManAngerEvent;
import net.xg787.xgsmi.registry.*;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.xg787.xgsmi.registry.compat.StoryModeRebornVBItems;

import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.CARVED_WHITE_PUMPKIN;

@Mod(StoryModeReborn.MOD_ID)
public class StoryModeReborn {
    public static final String MOD_ID = "story_mode_reborn";

    public StoryModeReborn(IEventBus modEventBus, ModContainer modContainer) {
        //modContainer.registerConfig(ModConfig.Type.COMMON, StoryModeRebornConfig.COMMON_SPEC);
        modContainer.registerConfig(ModConfig.Type.SERVER, StoryModeRebornConfig.SERVER_SPEC);
        modContainer.registerConfig(ModConfig.Type.STARTUP, StoryModeRebornConfig.STARTUP_SPEC);
        StoryModeRebornBlocks.BLOCKS.register(modEventBus);
        StoryModeRebornItems.ITEMS.register(modEventBus);
        if (ModList.get().isLoaded("vanillabackport")) {
            StoryModeRebornVBItems.ITEMS.register(modEventBus);
        }
        StoryModeRebornSounds.SOUND_EVENTS.register(modEventBus);
        StoryModeRebornEntities.ENTITY_TYPES.register(modEventBus);
        StoryModeRebornCreativeModeTab.CREATIVE_MODE_TABS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void preventEnderManAnger(EnderManAngerEvent event) {
        if (event.getPlayer() instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.HEAD).is(CARVED_WHITE_PUMPKIN.asItem())) {
                event.setCanceled(true);
            }
        }
    }

    public static ResourceLocation path(String path) {
        return ResourceLocation.tryBuild(MOD_ID, path);
    }
}
