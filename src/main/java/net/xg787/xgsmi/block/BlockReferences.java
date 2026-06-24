package net.xg787.xgsmi.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;

public class BlockReferences {
    public static final ResourceKey<Block> WHITE_PUMPKIN_REF = createKey("white_pumpkin");
    public static final ResourceKey<Block> WHITE_PUMPKIN_STEM_REF = createKey("white_pumpkin_stem");
    public static final ResourceKey<Block> ATTACHED_WHITE_PUMPKIN_STEM_REF = createKey("attached_white_pumpkin_stem");

    private static ResourceKey<Block> createKey(String id) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, id));
    }
}
