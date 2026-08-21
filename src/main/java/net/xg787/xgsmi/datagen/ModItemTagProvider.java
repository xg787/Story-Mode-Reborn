package net.xg787.xgsmi.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
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
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, ExistingFileHelper existingFileHelper) {
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

        tag(Tags.Items.RANGED_WEAPON_TOOLS)
                .add(PRISMARINE_BOW.get())
                .add(PRISMARINE_CROSSBOW.get());

        tag(ItemTags.FISHING_ENCHANTABLE)
                .add(PRISMARINE_FISHING_ROD.get());

        tag(Tags.Items.TOOLS_FISHING_ROD)
                .add(PRISMARINE_FISHING_ROD.get());

        tag(ItemTags.CREEPER_IGNITERS)
                .add(ENCHANTED_FLINT_AND_STEEL_DIAMOND.get())
                .add(ENCHANTED_FLINT_AND_STEEL_EMERALD.get())
                .add(ENCHANTED_FLINT_AND_STEEL_GOLD.get())
                .add(ENCHANTED_FLINT_AND_STEEL_REDSTONE.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("dungeonsdelight","rot_and_steel"));

        tag(Tags.Items.TOOLS_IGNITER)
                .add(ENCHANTED_FLINT_AND_STEEL_DIAMOND.get())
                .add(ENCHANTED_FLINT_AND_STEEL_EMERALD.get())
                .add(ENCHANTED_FLINT_AND_STEEL_GOLD.get())
                .add(ENCHANTED_FLINT_AND_STEEL_REDSTONE.get());

        tag(StoryModeRebornTags.Items.ENCHANTED_IGNITER)
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

        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(PRISMARINE_BOW.get())
                .add(PRISMARINE_CROSSBOW.get())
                .add(PRISMARINE_FISHING_ROD.get());

        tag(ItemTags.VANISHING_ENCHANTABLE)
                .add(CARVED_WHITE_PUMPKIN.asItem())
                .add(PRISMARINE_BOW.get())
                .add(PRISMARINE_CROSSBOW.get())
                .add(PRISMARINE_FISHING_ROD.get());

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

        tag(Tags.Items.HIDDEN_FROM_RECIPE_VIEWERS)
                .add(ICON.get());

        tag(Tags.Items.SEEDS)
                .add(WHITE_PUMPKIN_SEEDS.get());

        tag(StoryModeRebornTags.Items.SEEDS_WHITE_PUMPKIN)
                .add(WHITE_PUMPKIN_SEEDS.get());

        tag(ItemTags.CHICKEN_FOOD)
                .add(WHITE_PUMPKIN_SEEDS.get());

        tag(ItemTags.PARROT_FOOD)
                .add(WHITE_PUMPKIN_SEEDS.get());

        tag(Tags.Items.ANIMAL_FOODS)
                .add(WHITE_PUMPKIN_SEEDS.get());

        tag(StoryModeRebornTags.Items.SEEDS_WHITE_PUMPKIN)
                .add(WHITE_PUMPKIN_SEEDS.get());

        tag(Tags.Items.FOODS_PIE)
                .add(WHITE_PUMPKIN_PIE.get());

        tag(Tags.Items.CROPS)
                .add(WHITE_PUMPKIN.asItem());

        tag(StoryModeRebornTags.Items.WHITE_PUMPKINS)
                .add(WHITE_PUMPKIN.asItem())
                .add(CARVED_WHITE_PUMPKIN.asItem())
                .add(WHITE_JACK_O_LANTERN.asItem());

        tag(StoryModeRebornTags.Items.WHITE_PUMPKINS_NORMAL)
                .add(WHITE_PUMPKIN.asItem());

        tag(StoryModeRebornTags.Items.WHITE_PUMPKINS_CARVED)
                .add(CARVED_WHITE_PUMPKIN.asItem());

        tag(StoryModeRebornTags.Items.WHITE_PUMPKINS_JACK_O_LANTERNS)
                .add(WHITE_JACK_O_LANTERN.asItem());

        tag(StoryModeRebornTags.Items.CROPS_WHITE_PUMPKIN)
                .add(WHITE_PUMPKIN.asItem());

        tag(Tags.Items.ORES_IN_GROUND_DEEPSLATE)
                .add(DEEPSLATE_TITANIUM_ORE.asItem());

        tag(Tags.Items.ORES_IN_GROUND_NETHERRACK)
                .add(NETHER_ROMEUM_ORE.asItem());

        tag(Tags.Items.ORES)
                .add(DEEPSLATE_TITANIUM_ORE.asItem())
                .add(NETHER_ROMEUM_ORE.asItem());

        tag(Tags.Items.RAW_MATERIALS)
                .add(RAW_TITANIUM.asItem())
                .add(RAW_ROMEUM.asItem());

        tag(Tags.Items.INGOTS)
                .add(TITANIUM_INGOT.asItem())
                .add(ROMEUM_INGOT.asItem());

        tag(Tags.Items.STORAGE_BLOCKS)
                .add(TITANIUM_BLOCK.asItem())
                .add(ROMEUM_BLOCK.asItem());

        tag(StoryModeRebornTags.Items.ORES_TITANIUM)
                .add(DEEPSLATE_TITANIUM_ORE.asItem());

        tag(StoryModeRebornTags.Items.RAW_MATERIALS_TITANIUM)
                .add(RAW_TITANIUM.asItem());

        tag(StoryModeRebornTags.Items.INGOTS_TITANIUM)
                .add(TITANIUM_INGOT.asItem());

        tag(StoryModeRebornTags.Items.STORAGE_BLOCKS_TITANIUM)
                .add(TITANIUM_BLOCK.asItem());

        tag(StoryModeRebornTags.Items.ORES_ROMEUM)
                .add(NETHER_ROMEUM_ORE.asItem());

        tag(StoryModeRebornTags.Items.RAW_MATERIALS_ROMEUM)
                .add(RAW_ROMEUM.asItem());

        tag(StoryModeRebornTags.Items.INGOTS_ROMEUM)
                .add(ROMEUM_INGOT.asItem());

        tag(StoryModeRebornTags.Items.STORAGE_BLOCKS_ROMEUM)
                .add(ROMEUM_BLOCK.asItem());

        tag(ItemTags.BEACON_PAYMENT_ITEMS)
                .addTag(StoryModeRebornTags.Items.INGOTS_TITANIUM)
                .addTag(StoryModeRebornTags.Items.INGOTS_ROMEUM);

        tag(StoryModeRebornTags.Items.TNT_IGNITER)
                .addTag(StoryModeRebornTags.Items.ENCHANTED_IGNITER)
                .addTag(StoryModeRebornTags.Items.FIRE_CHARGES)
                .add(Items.FLINT_AND_STEEL)
                .addOptional(ResourceLocation.fromNamespaceAndPath("dungeonsdelight","rot_and_steel"));

        tag(StoryModeRebornTags.Items.FIRE_CHARGES)
                .add(Items.FIRE_CHARGE)
                .addOptional(ResourceLocation.fromNamespaceAndPath("minecraft","soul_fire_charge"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("netherdescent","soul_fire_charge"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("netherdescent","pendorite_fire_charge"));

        tag(StoryModeRebornTags.Items.CHARGED_IGNITER).addTag(StoryModeRebornTags.Items.ENCHANTED_IGNITER);

        tag(ItemTags.TRIMMABLE_ARMOR).remove(StoryModeRebornTags.Items.STORY_MODE_ARMOR);
    }
}
