package net.xg787.story_mode_reborn.jade;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.xg787.story_mode_reborn.registry.StoryModeRebornItems;
import snownee.jade.addon.harvest.HarvestToolProvider;
import snownee.jade.addon.harvest.SimpleToolHandler;
import snownee.jade.api.*;

import java.util.List;

@WailaPlugin
public class StoryModeRebornPlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        List<Item> pickaxeList = new java.util.ArrayList<>(List.of());
        List<Item> axeList = new java.util.ArrayList<>(List.of());
        List<Item> shovelList = new java.util.ArrayList<>(List.of());
        List<Item> hoeList = new java.util.ArrayList<>(List.of());

        for (int i = 0; i < HarvestToolProvider.TOOL_HANDLERS.get(JadeIds.JADE("pickaxe")).getTools().size();) {
            pickaxeList.add(HarvestToolProvider.TOOL_HANDLERS.get(JadeIds.JADE("pickaxe")).getTools().get(i).getItem());
            i++;
        }
        for (int i = 0; i < HarvestToolProvider.TOOL_HANDLERS.get(JadeIds.JADE("axe")).getTools().size();) {
            axeList.add(HarvestToolProvider.TOOL_HANDLERS.get(JadeIds.JADE("axe")).getTools().get(i).getItem());
            i++;
        }
        for (int i = 0; i < HarvestToolProvider.TOOL_HANDLERS.get(JadeIds.JADE("shovel")).getTools().size();) {
            shovelList.add(HarvestToolProvider.TOOL_HANDLERS.get(JadeIds.JADE("shovel")).getTools().get(i).getItem());
            i++;
        }
        for (int i = 0; i < HarvestToolProvider.TOOL_HANDLERS.get(JadeIds.JADE("hoe")).getTools().size();) {
            hoeList.add(HarvestToolProvider.TOOL_HANDLERS.get(JadeIds.JADE("hoe")).getTools().get(i).getItem());
            i++;
        }

        pickaxeList.add(3, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("minecraft","copper_pickaxe")));
        axeList.add(3, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("minecraft","copper_axe")));
        shovelList.add(3, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("minecraft","copper_shovel")));
        hoeList.add(3, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("minecraft","copper_hoe")));

        pickaxeList.add(5, StoryModeRebornItems.PRISMARINE_PICKAXE.get());
        axeList.add(5, StoryModeRebornItems.PRISMARINE_AXE.get());
        shovelList.add(5, StoryModeRebornItems.PRISMARINE_SHOVEL.get());
        hoeList.add(5, StoryModeRebornItems.PRISMARINE_HOE.get());

        pickaxeList.add(6, StoryModeRebornItems.ROYAL_PICKAXE.get());
        axeList.add(6, StoryModeRebornItems.ROYAL_AXE.get());
        shovelList.add(6, StoryModeRebornItems.ROYAL_SHOVEL.get());
        hoeList.add(6, StoryModeRebornItems.ROYAL_HOE.get());

        pickaxeList.add(StoryModeRebornItems.TITANIUM_PICKAXE.get());
        axeList.add(StoryModeRebornItems.TITANIUM_AXE.get());
        shovelList.add(StoryModeRebornItems.TITANIUM_SHOVEL.get());
        hoeList.add(StoryModeRebornItems.TITANIUM_HOE.get());

        pickaxeList.add(StoryModeRebornItems.ENCHANTED_TITANIUM_PICKAXE.get());
        axeList.add(StoryModeRebornItems.ENCHANTED_TITANIUM_AXE.get());
        shovelList.add(StoryModeRebornItems.ENCHANTED_TITANIUM_SHOVEL.get());
        hoeList.add(StoryModeRebornItems.ENCHANTED_TITANIUM_HOE.get());

        pickaxeList.add(StoryModeRebornItems.ROMEUM_PICKAXE.get());
        axeList.add(StoryModeRebornItems.ROMEUM_AXE.get());
        shovelList.add(StoryModeRebornItems.ROMEUM_SHOVEL.get());
        hoeList.add(StoryModeRebornItems.ROMEUM_HOE.get());

        pickaxeList.add(StoryModeRebornItems.ENCHANTED_ROMEUM_PICKAXE.get());
        axeList.add(StoryModeRebornItems.ENCHANTED_ROMEUM_AXE.get());
        shovelList.add(StoryModeRebornItems.ENCHANTED_ROMEUM_SHOVEL.get());
        hoeList.add(StoryModeRebornItems.ENCHANTED_ROMEUM_HOE.get());

        HarvestToolProvider.registerHandler(SimpleToolHandler.create(JadeIds.JADE("pickaxe"), pickaxeList));
        HarvestToolProvider.registerHandler(SimpleToolHandler.create(JadeIds.JADE("axe"), axeList));
        HarvestToolProvider.registerHandler(SimpleToolHandler.create(JadeIds.JADE("shovel"), shovelList));
        HarvestToolProvider.registerHandler(SimpleToolHandler.create(JadeIds.JADE("hoe"), hoeList));
    }
}
