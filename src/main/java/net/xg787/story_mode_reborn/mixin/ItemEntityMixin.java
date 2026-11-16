package net.xg787.story_mode_reborn.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.xg787.story_mode_reborn.block.RedstoneHeartBlock;
import net.xg787.story_mode_reborn.item.RedstoneHeartItem;
import net.xg787.story_mode_reborn.registry.StoryModeRebornSounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity implements TraceableEntity {
    public ItemEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Shadow public abstract ItemStack getItem();

    @Inject(method = "tick", at = @At("TAIL"))
    public void tick(CallbackInfo ci) {
        if (this.getItem().getItem() instanceof RedstoneHeartItem && this.level().getGameTime() % 30 == 0) {
            this.level().playSound(null, blockPosition(), StoryModeRebornSounds.REDSTONE_HEART_HEARTBEAT.get(), SoundSource.BLOCKS,0.25F, 1.0F);
        }
    }
}
