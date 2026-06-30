package net.xg787.xgsmi.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xg787.xgsmi.util.StoryModeRebornTags;

import java.util.concurrent.CompletableFuture;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.*;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.*;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.SWORDS)
                .add(PRISMARINE_SWORD.get())
                .add(ROYAL_SWORD.get())
                .add(TITANIUM_SWORD.get())
                .add(ENCHANTED_TITANIUM_SWORD.get())
                .add(ROMEUM_SWORD.get())
                .add(ENCHANTED_ROMEUM_SWORD.get());

        tag(ItemTags.PICKAXES)
                .add(PRISMARINE_PICKAXE.get())
                .add(ROYAL_PICKAXE.get())
                .add(TITANIUM_PICKAXE.get())
                .add(ENCHANTED_TITANIUM_PICKAXE.get())
                .add(ROMEUM_PICKAXE.get())
                .add(ENCHANTED_ROMEUM_PICKAXE.get());

        tag(ItemTags.AXES)
                .add(PRISMARINE_AXE.get())
                .add(ROYAL_AXE.get())
                .add(TITANIUM_AXE.get())
                .add(ENCHANTED_TITANIUM_AXE.get())
                .add(ROMEUM_AXE.get())
                .add(ENCHANTED_ROMEUM_AXE.get());

        tag(ItemTags.SHOVELS)
                .add(PRISMARINE_SHOVEL.get())
                .add(ROYAL_SHOVEL.get())
                .add(TITANIUM_SHOVEL.get())
                .add(ENCHANTED_TITANIUM_SHOVEL.get())
                .add(ROMEUM_SHOVEL.get())
                .add(ENCHANTED_ROMEUM_SHOVEL.get());

        tag(ItemTags.HOES)
                .add(PRISMARINE_HOE.get())
                .add(ROYAL_HOE.get())
                .add(TITANIUM_HOE.get())
                .add(ENCHANTED_TITANIUM_HOE.get())
                .add(ROMEUM_HOE.get())
                .add(ENCHANTED_ROMEUM_HOE.get());

        tag(ItemTags.ARROWS)
                .add(PRISMARINE_ARROW.get())
                .add(TIPPED_PRISMARINE_ARROW.get());

        tag(Tags.Items.TOOLS_BOW)
                .add(PRISMARINE_BOW.get());

        tag(ItemTags.BOW_ENCHANTABLE)
                .add(PRISMARINE_BOW.get());

        tag(Tags.Items.TOOLS_CROSSBOW)
                .add(PRISMARINE_CROSSBOW.get());

        tag(ItemTags.CROSSBOW_ENCHANTABLE)
                .add(PRISMARINE_CROSSBOW.get());

        tag(ItemTags.FISHING_ENCHANTABLE)
                .add(PRISMARINE_FISHING_ROD.get());

        tag(Tags.Items.TOOLS_FISHING_ROD)
                .add(PRISMARINE_FISHING_ROD.get());

        tag(ItemTags.CREEPER_IGNITERS)
                .add(ENCHANTED_FLINT_AND_STEEL_DIAMOND.get())
                .add(ENCHANTED_FLINT_AND_STEEL_EMERALD.get())
                .add(ENCHANTED_FLINT_AND_STEEL_GOLD.get())
                .add(ENCHANTED_FLINT_AND_STEEL_REDSTONE.get());

        tag(Tags.Items.TOOLS_IGNITER)
                .add(ENCHANTED_FLINT_AND_STEEL_DIAMOND.get())
                .add(ENCHANTED_FLINT_AND_STEEL_EMERALD.get())
                .add(ENCHANTED_FLINT_AND_STEEL_GOLD.get())
                .add(ENCHANTED_FLINT_AND_STEEL_REDSTONE.get());

        tag(StoryModeRebornTags.Items.PRISMARINE_TOOL_MATERIAL)
                .add(Items.PRISMARINE)
                .add(Items.PRISMARINE_BRICKS)
                .add(Items.DARK_PRISMARINE);

        tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .add(CARVED_WHITE_PUMPKIN.asItem());

        tag(ItemTags.VANISHING_ENCHANTABLE)
                .add(CARVED_WHITE_PUMPKIN.asItem())
                .add(PRISMARINE_BOW.get())
                .add(PRISMARINE_CROSSBOW.get())
                .add(PRISMARINE_FISHING_ROD.get())
                .add(ENCHANTED_FLINT_AND_STEEL_DIAMOND.get())
                .add(ENCHANTED_FLINT_AND_STEEL_EMERALD.get())
                .add(ENCHANTED_FLINT_AND_STEEL_GOLD.get())
                .add(ENCHANTED_FLINT_AND_STEEL_REDSTONE.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(TITANIUM_HELMET.get())
                .add(ENCHANTED_TITANIUM_HELMET.get())
                .add(ROMEUM_HELMET.get())
                .add(ENCHANTED_ROMEUM_HELMET.get())
                .add(GABRIEL_HELMET.get());

        tag(ItemTags.CHEST_ARMOR)
                .add(TITANIUM_CHESTPLATE.get())
                .add(ENCHANTED_TITANIUM_CHESTPLATE.get())
                .add(ROMEUM_CHESTPLATE.get())
                .add(ENCHANTED_ROMEUM_CHESTPLATE.get())
                .add(GABRIEL_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR)
                .add(TITANIUM_LEGGINGS.get())
                .add(ENCHANTED_TITANIUM_LEGGINGS.get())
                .add(ROMEUM_LEGGINGS.get())
                .add(ENCHANTED_ROMEUM_LEGGINGS.get())
                .add(GABRIEL_LEGGINGS.get());

        tag(ItemTags.FOOT_ARMOR)
                .add(TITANIUM_BOOTS.get())
                .add(ENCHANTED_TITANIUM_BOOTS.get())
                .add(ROMEUM_BOOTS.get())
                .add(ENCHANTED_ROMEUM_BOOTS.get())
                .add(GABRIEL_BOOTS.get());

        tag(StoryModeRebornTags.Items.STORY_MODE_ARMOR)
                .add(GABRIEL_HELMET.get())
                .add(GABRIEL_CHESTPLATE.get())
                .add(GABRIEL_LEGGINGS.get())
                .add(GABRIEL_BOOTS.get());

        tag(ItemTags.TRIMMABLE_ARMOR).remove(StoryModeRebornTags.Items.STORY_MODE_ARMOR);
        //tag(Tags.Items.).add(CARVED_WHITE_PUMPKIN.asItem());


    }
}
