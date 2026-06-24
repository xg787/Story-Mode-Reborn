package net.xg787.xgsmi.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.xg787.xgsmi.util.StoryModeRebornTags;

import static net.minecraft.tags.BlockTags.*;
import static net.minecraft.world.item.Items.IRON_INGOT;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.ROMEUM_INGOT;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.TITANIUM_INGOT;

public class StoryModeRebornToolTiers {
    public static final Tier PRISMARINE = new SimpleTier(INCORRECT_FOR_IRON_TOOL, 200, 4f, 2f, 12, () -> Ingredient.of(StoryModeRebornTags.Items.PRISMARINE_TOOL_MATERIAL));
    public static final Tier ROYAL = new SimpleTier(INCORRECT_FOR_DIAMOND_TOOL, 1000, 6f, 3f, 12, () -> Ingredient.of(IRON_INGOT));
    public static final Tier TITANIUM = new SimpleTier(INCORRECT_FOR_NETHERITE_TOOL, 2500, 9.5F, 4.5F, 20, () -> Ingredient.of(TITANIUM_INGOT));
    public static final Tier ENCHANTED_TITANIUM = new SimpleTier(INCORRECT_FOR_NETHERITE_TOOL, 3000, 10.0F, 5.0F, 25, () -> Ingredient.of(TITANIUM_INGOT));
    public static final Tier ROMEUM = new SimpleTier(INCORRECT_FOR_NETHERITE_TOOL, 3500, 10.5F, 5.5F, 30, () -> Ingredient.of(ROMEUM_INGOT));
    public static final Tier ENCHANTED_ROMEUM = new SimpleTier(INCORRECT_FOR_NETHERITE_TOOL, 4000, 11.0F, 6.0F, 35, () -> Ingredient.of(ROMEUM_INGOT));
}
