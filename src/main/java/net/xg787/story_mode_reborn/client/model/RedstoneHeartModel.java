package net.xg787.story_mode_reborn.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.xg787.story_mode_reborn.entity.RedstoneHeart;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RedstoneHeartModel extends EntityModel<RedstoneHeart> {


    private ModelPart root;

    public RedstoneHeartModel(ModelPart root) {
        this.root = root;
    }

    public static LayerDefinition createBlockLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("block", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public ModelPart root() {
        return this.root;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        this.root.x = -8.001F;
        this.root.y = 16.001F;
        this.root.z = 8.001F;

        this.root.xScale = 1.0005F;
        this.root.yScale = -1.0005F;
        this.root.zScale = -1.0005F;
        this.root().render(poseStack, buffer, packedLight, packedOverlay, color);
    }

    @Override
    public void setupAnim(RedstoneHeart entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }
}
