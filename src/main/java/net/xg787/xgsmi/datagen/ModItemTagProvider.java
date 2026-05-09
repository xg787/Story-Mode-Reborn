package net.xg787.xgsmi.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xg787.xgsmi.util.XgsmiTags;

import java.util.concurrent.CompletableFuture;

import static net.xg787.xgsmi.Xgsmi.MOD_ID;
import static net.xg787.xgsmi.registry.XgsmiBlocks.CARVED_WHITE_PUMPKIN;
import static net.xg787.xgsmi.registry.XgsmiItems.PRISMARINE_ARROW;
import static net.xg787.xgsmi.registry.XgsmiItems.TIPPED_PRISMARINE_ARROW;

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
        tag(XgsmiTags.Items.PRISMARINE_TOOL_MATERIAL)
                .add(Items.PRISMARINE)
                .add(Items.PRISMARINE_BRICKS)
                .add(Items.DARK_PRISMARINE);

        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(CARVED_WHITE_PUMPKIN.asItem());
        tag(ItemTags.VANISHING_ENCHANTABLE).add(CARVED_WHITE_PUMPKIN.asItem());

        //tag(Tags.Items.).add(CARVED_WHITE_PUMPKIN.asItem());


    }
}
