package net.xg787.xgsmi.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;
import net.neoforged.neoforge.client.ClientHooks;
import net.xg787.xgsmi.item.AbstractArmorItem;
import net.xg787.xgsmi.util.StoryModeRebornTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerRenderer.class)
public abstract class PlayerRendererMixin extends LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
    private HumanoidArmorLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>, HumanoidModel<AbstractClientPlayer>> armorLayer;

    public PlayerRendererMixin(EntityRendererProvider.Context context, PlayerModel<AbstractClientPlayer> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method = "<init>", at = @At(value = "TAIL"))
    private void init(EntityRendererProvider.Context context, boolean useSlimModel, CallbackInfo ci) {
        armorLayer = new HumanoidArmorLayer<>(this,
                new HumanoidArmorModel<>(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
                new HumanoidArmorModel<>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)),
                context.getModelManager()
        );
    }

    @Inject(method = "setModelProperties", at = @At(value = "TAIL"))
    private void setModelProperties(AbstractClientPlayer clientPlayer, CallbackInfo ci) {
        PlayerModel<AbstractClientPlayer> playermodel = this.getModel();
        if (!clientPlayer.isSpectator()) {
            playermodel.hat.visible = !clientPlayer.getInventory().armor.get(3).getItem().getDefaultInstance().is(StoryModeRebornTags.Items.HIDE_SKIN_LAYER);
            playermodel.jacket.visible = !clientPlayer.getInventory().armor.get(2).getItem().getDefaultInstance().is(StoryModeRebornTags.Items.HIDE_SKIN_LAYER);
            playermodel.leftSleeve.visible = !clientPlayer.getInventory().armor.get(2).getItem().getDefaultInstance().is(StoryModeRebornTags.Items.HIDE_SlEEVE_SKIN_LAYER);
            playermodel.rightSleeve.visible = !clientPlayer.getInventory().armor.get(2).getItem().getDefaultInstance().is(StoryModeRebornTags.Items.HIDE_SlEEVE_SKIN_LAYER);
            playermodel.leftPants.visible = !clientPlayer.getInventory().armor.get(1).getItem().getDefaultInstance().is(StoryModeRebornTags.Items.HIDE_SKIN_LAYER);
            playermodel.rightPants.visible = !clientPlayer.getInventory().armor.get(1).getItem().getDefaultInstance().is(StoryModeRebornTags.Items.HIDE_SKIN_LAYER);
        }
    }

    @Inject(method = "renderRightHand", at = @At(value = "TAIL"))
    private void renderRightHand(PoseStack poseStack, MultiBufferSource buffer, int combinedLight, AbstractClientPlayer player, CallbackInfo ci) {
        if(!ClientHooks.renderSpecificFirstPersonArm(poseStack, buffer, combinedLight, player, HumanoidArm.RIGHT)) {
            if (player.getInventory().armor.get(2).getItem().getDefaultInstance().is(StoryModeRebornTags.Items.HIDE_SKIN_LAYER)) {
                this.renderArmorHand(poseStack, buffer, combinedLight, player, armorLayer.outerModel.rightArm, false);
            }
        }
    }

    @Inject(method = "renderLeftHand", at = @At(value = "TAIL"))
    private void renderLeftHand(PoseStack poseStack, MultiBufferSource buffer, int combinedLight, AbstractClientPlayer player, CallbackInfo ci) {
        if (!ClientHooks.renderSpecificFirstPersonArm(poseStack, buffer, combinedLight, player, HumanoidArm.LEFT)) {
            if (player.getInventory().armor.get(2).getItem().getDefaultInstance().is(StoryModeRebornTags.Items.HIDE_SKIN_LAYER)) {
                this.renderArmorHand(poseStack, buffer, combinedLight, player, armorLayer.outerModel.leftArm, true);
            }
        }
    }

    @Unique
    private void renderArmorHand(PoseStack poseStack, MultiBufferSource buffer, int combinedLight, AbstractClientPlayer player, ModelPart rendererArmarmor, boolean isLeft) {
        if (isLeft) {
            rendererArmarmor.x = 5.7F;
            rendererArmarmor.zRot = -0.1F;
        } else {
            rendererArmarmor.x = -5.7F;
            rendererArmarmor.zRot = 0.1F;
        }
        rendererArmarmor.y = 4.15F;
        rendererArmarmor.z = -0.1F;
        rendererArmarmor.xScale = 0.7F;
        rendererArmarmor.yScale = 0.7F;
        rendererArmarmor.zScale = 0.7F;
        if (player.getInventory().armor.get(2).getItem() instanceof AbstractArmorItem item && item.getArmTexture() != null) {
            ResourceLocation resourcelocation = item.getArmTexture();
            rendererArmarmor.render(poseStack, buffer.getBuffer(RenderType.entityCutoutNoCull(resourcelocation)), combinedLight, OverlayTexture.NO_OVERLAY);
        }
    }
}
