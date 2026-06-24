package net.xg787.xgsmi.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xg787.xgsmi.util.StoryModeRebornTags;

import java.util.concurrent.CompletableFuture;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;
import static net.xg787.xgsmi.registry.StoryModeRebornBlocks.CARVED_WHITE_PUMPKIN;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.*;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.SWORDS);
        tag(ItemTags.PICKAXES);
        tag(ItemTags.AXES);
        tag(ItemTags.SHOVELS);
        tag(ItemTags.HOES);
        tag(ItemTags.ARROWS)
                .add(PRISMARINE_ARROW.get())
                .add(TIPPED_PRISMARINE_ARROW.get());
        tag(StoryModeRebornTags.Items.PRISMARINE_TOOL_MATERIAL)
                .add(Items.PRISMARINE)
                .add(Items.PRISMARINE_BRICKS)
                .add(Items.DARK_PRISMARINE);

        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(CARVED_WHITE_PUMPKIN.asItem());
        tag(ItemTags.VANISHING_ENCHANTABLE).add(CARVED_WHITE_PUMPKIN.asItem());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(TITANIUM_HELMET.get())
                .add(TITANIUM_CHESTPLATE.get())
                .add(TITANIUM_LEGGINGS.get())
                .add(TITANIUM_BOOTS.get());
        //tag(Tags.Items.).add(CARVED_WHITE_PUMPKIN.asItem());


    }
}
