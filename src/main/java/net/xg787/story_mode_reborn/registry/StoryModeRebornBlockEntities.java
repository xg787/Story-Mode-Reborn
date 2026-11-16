package net.xg787.story_mode_reborn.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.xg787.story_mode_reborn.block.RedstoneHeartBlockEntity;

import static net.xg787.story_mode_reborn.StoryModeReborn.MOD_ID;
import static net.xg787.story_mode_reborn.registry.StoryModeRebornBlocks.REDSTONE_HEART;

public class StoryModeRebornBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RedstoneHeartBlockEntity>> REDSTONE_HEART_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("redstone_heart", () -> BlockEntityType.Builder.of(RedstoneHeartBlockEntity::new, REDSTONE_HEART.get()).build(null));
}

