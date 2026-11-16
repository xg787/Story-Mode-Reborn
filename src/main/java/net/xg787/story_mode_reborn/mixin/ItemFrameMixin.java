package net.xg787.story_mode_reborn.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.xg787.story_mode_reborn.item.RedstoneHeartItem;
import net.xg787.story_mode_reborn.registry.StoryModeRebornSounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemFrame.class)
public abstract class ItemFrameMixin extends HangingEntity {
    protected ItemFrameMixin(EntityType<? extends HangingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Shadow public abstract ItemStack getItem();

    @Override
    public void tick() {
        super.tick();
        if (this.getItem().getItem() instanceof RedstoneHeartItem && this.level().getGameTime() % 30 == 0) {
            if (this.level().getGameTime() % 30 == 0) {
                this.level().playSound(null, blockPosition(), StoryModeRebornSounds.REDSTONE_HEART_HEARTBEAT.get(), SoundSource.BLOCKS,0.25F, 1.0F);
            }
        }
    }
}
