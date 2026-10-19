package net.xg787.xgsmi.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.xg787.xgsmi.StoryModeRebornConfig;
import net.xg787.xgsmi.registry.StoryModeRebornSounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownEnderpearl.class)
public abstract class ThrownEnderpearlMixin extends ThrowableItemProjectile {

    @Unique
    double x1 = 0;
    @Unique
    double y1 = -2048;
    @Unique
    double z1 = 0;

    public ThrownEnderpearlMixin(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "onHit", at = @At(value = "HEAD"))
    private void onHit(HitResult result, CallbackInfo ci) {
        if (this.level() instanceof ServerLevel serverlevel && !this.isRemoved()) {
            Entity entity = this.getOwner();
            if (entity != null && isAllowedToTeleportOwner(entity, serverlevel)) {
                if (entity instanceof ServerPlayer serverplayer) {
                    net.neoforged.neoforge.event.entity.EntityTeleportEvent.EnderPearl event = net.neoforged.neoforge.event.EventHooks.onEnderPearlLand(serverplayer, this.getX(), this.getY(), this.getZ(), new ThrownEnderpearl(EntityType.ENDER_PEARL, level()), 5.0F, result);
                    if (!event.isCanceled()) {
                        x1 = event.getPrevX();
                        y1 = event.getPrevY();
                        z1 = event.getPrevZ();
                    }
                }
            }
        }
    }

    @Inject(method = "playSound", at = @At(value = "TAIL"))
    private void playSound(Level level, Vec3 pos, CallbackInfo ci) {
        if (StoryModeRebornConfig.ENDER_PEARL_SOUND.get()) {
            level.playSound(null, x1, y1, z1, StoryModeRebornSounds.PLAYER_DISAPPEAR.get(), SoundSource.PLAYERS, 0.5F, 1.0F);
            level.playSound(null, pos.x, pos.y, pos.z, StoryModeRebornSounds.PLAYER_APPEAR.get(), SoundSource.PLAYERS, 0.75F, 1.0F);
        }
        level.playSound(null, x1, y1, z1, SoundEvents.PLAYER_TELEPORT, SoundSource.PLAYERS);
    }

    @Unique
    private static boolean isAllowedToTeleportOwner(Entity entity, Level level) {
        if (entity.level().dimension() == level.dimension()) {
            return !(entity instanceof LivingEntity livingentity) ? entity.isAlive() : livingentity.isAlive() && !livingentity.isSleeping();
        } else {
            return entity.canUsePortal(true);
        }
    }
}
