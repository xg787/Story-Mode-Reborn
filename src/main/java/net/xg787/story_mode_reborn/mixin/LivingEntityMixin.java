package net.xg787.story_mode_reborn.mixin;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.xg787.story_mode_reborn.item.RedstoneHeartItem;
import net.xg787.story_mode_reborn.registry.StoryModeRebornSounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Shadow public abstract ItemStack getMainHandItem();
    @Shadow public abstract ItemStack getOffhandItem();

    @Inject(method = "tick", at = @At("TAIL"))
    public void tick(CallbackInfo ci) {
        if (this.getMainHandItem().getItem() instanceof RedstoneHeartItem || this.getOffhandItem().getItem() instanceof RedstoneHeartItem) {
            if (this.level().getGameTime() % 30 == 0) {
                this.level().playSound(null, blockPosition(), StoryModeRebornSounds.REDSTONE_HEART_HEARTBEAT.get(), SoundSource.BLOCKS,0.25F, 1.0F);
            }
        }
    }
}
