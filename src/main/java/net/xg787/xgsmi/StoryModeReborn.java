package net.xg787.xgsmi;

import net.mcexpanded.fancytabsections.FancyTabSections;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.EnderManAngerEvent;
import net.xg787.xgsmi.registry.*;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.CARVED_WHITE_PUMPKIN;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.ICON;

@Mod(StoryModeReborn.MOD_ID)
public class StoryModeReborn {
    public static final String MOD_ID = "story_mode_reborn";

    public StoryModeReborn(IEventBus modEventBus) {
        StoryModeRebornBlocks.BLOCKS.register(modEventBus);
        StoryModeRebornItems.ITEMS.register(modEventBus);
        StoryModeRebornSounds.SOUND_EVENTS.register(modEventBus);
        StoryModeRebornEntities.ENTITY_TYPES.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        StoryModeRebornCreativeModeTab.register(modEventBus);
        modEventBus.addListener(StoryModeRebornCreativeModeTab::addCreative);
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
