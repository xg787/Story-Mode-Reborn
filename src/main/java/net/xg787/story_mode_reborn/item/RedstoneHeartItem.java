package net.xg787.story_mode_reborn.item;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.xg787.story_mode_reborn.registry.StoryModeRebornEntities;


public class RedstoneHeartItem extends BlockItem {
    public RedstoneHeartItem(Block block, Properties properties) {
        super(block, properties);
    }

    @OnlyIn(Dist.CLIENT)
    public Entity getRenderEntity() {
        Level level = Minecraft.getInstance().level;
        return StoryModeRebornEntities.REDSTONE_HEART_ENTITY.get().create(level);
    }
}
