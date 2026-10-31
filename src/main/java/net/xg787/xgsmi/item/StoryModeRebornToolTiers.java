package net.xg787.xgsmi.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;
import net.xg787.xgsmi.util.StoryModeRebornTags;

public class StoryModeRebornToolTiers {
    public static final Tier PRISMARINE = new SimpleTier(StoryModeRebornTags.Blocks.INCORRECT_FOR_PRISMARINE_TOOL, 300, 4f, 2f, 12, () -> Ingredient.of(StoryModeRebornTags.Items.PRISMARINE_TOOL_MATERIAL));
    public static final Tier ROYAL = new SimpleTier(StoryModeRebornTags.Blocks.INCORRECT_FOR_ROYAL_TOOL, 1000, 6f, 3f, 12, () -> Ingredient.of(Tags.Items.INGOTS_IRON));
    public static final Tier TITANIUM = new SimpleTier(StoryModeRebornTags.Blocks.INCORRECT_FOR_TITANIUM_TOOL, 2500, 9.5F, 4.5F, 20, () -> Ingredient.of(StoryModeRebornTags.Items.INGOTS_TITANIUM));
    public static final Tier ENCHANTED_TITANIUM = new SimpleTier(StoryModeRebornTags.Blocks.INCORRECT_FOR_ENCHANTED_TITANIUM_TOOL, 3000, 10.0F, 5.0F, 25, () -> Ingredient.of(StoryModeRebornTags.Items.INGOTS_TITANIUM));
    public static final Tier ROMEUM = new SimpleTier(StoryModeRebornTags.Blocks.INCORRECT_FOR_ROMEUM_TOOL, 3500, 10.5F, 5.5F, 30, () -> Ingredient.of(StoryModeRebornTags.Items.INGOTS_ROMEUM));
    public static final Tier ENCHANTED_ROMEUM = new SimpleTier(StoryModeRebornTags.Blocks.INCORRECT_FOR_ENCHANTED_ROMEUM_TOOL, 4000, 11.0F, 6.0F, 35, () -> Ingredient.of(StoryModeRebornTags.Items.INGOTS_ROMEUM));
}
