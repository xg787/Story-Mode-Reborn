package net.xg787.story_mode_reborn.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.xg787.story_mode_reborn.StoryModeReborn;
import net.xg787.story_mode_reborn.block.RedstoneHeartBlock;
import net.xg787.story_mode_reborn.block.RedstoneHeartBlockEntity;
import net.xg787.story_mode_reborn.client.StoryModeRebornClient;
import net.xg787.story_mode_reborn.client.model.RedstoneHeartModel;
import net.xg787.story_mode_reborn.client.texture.AnimatableTexture;
import net.xg787.story_mode_reborn.entity.RedstoneHeart;
import net.xg787.story_mode_reborn.registry.StoryModeRebornSounds;

public class RedstoneHeartRenderer extends EntityRenderer<RedstoneHeart> {
    private final RedstoneHeartModel model;

    public RedstoneHeartRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new RedstoneHeartModel(context.bakeLayer(StoryModeRebornClient.REDSTONE_HEART_LAYER));
    }

    @Override
    public ResourceLocation getTextureLocation(RedstoneHeart entity) {
        return ResourceLocation.fromNamespaceAndPath(StoryModeReborn.MOD_ID, "textures/entity/redstone_heart/block.png");
    }

    public void render(RedstoneHeart entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityCutout(this.getTextureLocation(entity)));
        AnimatableTexture.setAndUpdate(getTextureLocation(entity), (int) entity.level().getGameTime());
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, 655360, 0xFFFFFFFF);
        poseStack.popPose();
    }
}
