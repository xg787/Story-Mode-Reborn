package net.xg787.story_mode_reborn.datagen;

import net.minecraft.client.renderer.texture.atlas.sources.DirectoryLister;
import net.minecraft.client.renderer.texture.atlas.sources.SingleFile;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SpriteSourceProvider;
import net.xg787.story_mode_reborn.StoryModeReborn;
import net.xg787.story_mode_reborn.client.renderer.StoryModeRebornSheets;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ModSpriteSourceProvider extends SpriteSourceProvider {
    public ModSpriteSourceProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void gather() {
//        atlas(StoryModeRebornSheets.STORY_MODE_REBORN_SHEET)
//                .addSource(new DirectoryLister("entity/redstone_heart", "entity/redstone_heart/"));
    }
}
