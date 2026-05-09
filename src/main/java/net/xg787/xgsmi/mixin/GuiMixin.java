package net.xg787.xgsmi.mixin;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.xg787.xgsmi.registry.XgsmiBlocks.CARVED_WHITE_PUMPKIN;

@Mixin(Gui.class)
public abstract class GuiMixin {
    @Shadow @Final private Minecraft minecraft;

    @Shadow private float scopeScale;

    @Shadow protected abstract void renderTextureOverlay(GuiGraphics guiGraphics, ResourceLocation shaderLocation, float alpha);

    @Shadow @Final private static ResourceLocation PUMPKIN_BLUR_LOCATION;

    @Inject(method = "renderCameraOverlays", at = @At("TAIL"))
    private void renderCameraOverlays(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
        if (this.minecraft.options.getCameraType().isFirstPerson()) {
            if (!this.minecraft.player.isScoping())  {
                this.scopeScale = 0.5F;
                ItemStack itemstack = this.minecraft.player.getInventory().getArmor(3);
                if (itemstack.is(CARVED_WHITE_PUMPKIN.asItem())) {
                    this.renderTextureOverlay(guiGraphics, PUMPKIN_BLUR_LOCATION, 1.0F);
                } else {
                    net.neoforged.neoforge.client.extensions.common.IClientItemExtensions.of(itemstack).renderHelmetOverlay(itemstack, this.minecraft.player, guiGraphics, deltaTracker);
                }
            }
        }
    }
}
