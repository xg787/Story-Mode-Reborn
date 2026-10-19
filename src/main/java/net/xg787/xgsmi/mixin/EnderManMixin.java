package net.xg787.xgsmi.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.xg787.xgsmi.StoryModeRebornConfig;
import net.xg787.xgsmi.registry.StoryModeRebornSounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnderMan.class)
public abstract class EnderManMixin extends Monster implements NeutralMob {

    @Unique
    double x1;
    @Unique
    double y1;
    @Unique
    double z1;

    protected EnderManMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "playStareSound", at = @At("TAIL"))
    private void playStareSound(CallbackInfo ci) {
        if (!this.isSilent() && StoryModeRebornConfig.ENDERMAN_SOUNDS.get()) {
            this.level().playLocalSound(this.getX(), this.getEyeY(), this.getZ(), StoryModeRebornSounds.ENDERMAN_BIG_SCREAM.get(), this.getSoundSource(), 2.5F, 1.0F, false);
        }
    }

    @Inject(method = "teleport(DDD)Z", at = @At("HEAD"))
    private void teleport(double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        net.neoforged.neoforge.event.entity.EntityTeleportEvent.EnderEntity event = net.neoforged.neoforge.event.EventHooks.onEnderTeleport(this, x, y, z);
        x1 = event.getPrevX();
        y1 = event.getPrevY();
        z1 = event.getPrevZ();
        if (StoryModeRebornConfig.ENDERMAN_SOUNDS.get()) {
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(x, y, z);
            while (blockpos$mutableblockpos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState(blockpos$mutableblockpos).blocksMotion()) {
                blockpos$mutableblockpos.move(Direction.DOWN);
            }
            BlockState blockstate = this.level().getBlockState(blockpos$mutableblockpos);
            boolean flag = blockstate.blocksMotion();
            boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
            boolean flag2 = this.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag && !flag1 && flag2 && !event.isCanceled() && !this.isSilent()) {
                this.level().playSound(null, x1, y1, z1, StoryModeRebornSounds.ENDERMAN_DISAPPEAR.get(), this.getSoundSource(), 0.5F, 1.0F);
                this.level().playSound(null, this.xo, this.yo, this.zo, StoryModeRebornSounds.ENDERMAN_APPEAR.get(), this.getSoundSource(), 0.75F, 1.0F);
            }
        }
    }

    @Redirect(method = "teleport(DDD)Z", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/monster/EnderMan;xo:D"))
    private double teleport_xo(EnderMan instance) {
        return x1;
    }

    @Redirect(method = "teleport(DDD)Z", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/monster/EnderMan;yo:D"))
    private double teleport_yo(EnderMan instance) {
        return y1;
    }

    @Redirect(method = "teleport(DDD)Z", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/monster/EnderMan;zo:D"))
    private double teleport_zo(EnderMan instance) {
        return z1;
    }
}
