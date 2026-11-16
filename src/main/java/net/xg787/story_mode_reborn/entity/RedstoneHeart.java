package net.xg787.story_mode_reborn.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.xg787.story_mode_reborn.block.RedstoneHeartBlock;

public class RedstoneHeart extends Entity {
    public RedstoneHeart(EntityType<? extends RedstoneHeart> entityType, Level level) {
        super(entityType, level);
    }

    public void tick() {
        if (!(this.level().getBlockState(blockPosition()).getBlock() instanceof RedstoneHeartBlock)) {
            kill();
        }
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        double d0 = this.getBoundingBox().getSize() * 4.0;
        if (Double.isNaN(d0) || d0 == 0.0) {
            d0 = 4.0;
        }

        d0 *= 64.0;
        return distance < d0 * d0;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
    }
}
