package net.xg787.xgsmi.client.model.armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class GabrielArmorModel extends BaseArmorModel {
	public GabrielArmorModel(ModelPart root) {
        super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(16, 45).addBox(-5.0F, -8.5F, -5.5F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(30, 57).addBox(-1.0F, -6.5F, -4.5F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 55).addBox(-4.0F, -8.5F, -4.5F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(29, 32).addBox(1.0F, -7.5F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(29, 32).addBox(-2.0F, -7.5F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(46, 54).addBox(-4.0F, -8.5F, 3.5F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(36, 37).addBox(-5.0F, -8.5F, -4.5F, 1.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(53, 37).addBox(-5.0F, -8.5F, -4.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(53, 37).addBox(4.0F, -8.5F, -4.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(47, 41).addBox(-5.0F, -3.5F, -5.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(11, 36).addBox(-4.0F, 3.5F, -3.75F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(27, 34).addBox(-5.0F, 1.5F, 4.25F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(35, 61).addBox(-5.0F, -4.5F, -5.25F, 10.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -5.0F, -0.25F, 3.1416F, 0.0F, 0.0F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(47, 41).addBox(-5.0F, 1.5F, 4.25F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(36, 37).addBox(-5.0F, -3.5F, -4.75F, 1.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -0.25F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(29, 57).addBox(4.25F, 0.5F, -1.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -0.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(27, 57).addBox(4.25F, -1.0F, -0.5F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(29, 57).addBox(4.25F, 1.0F, -0.5F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -0.25F, 0.0F, 1.5708F, -1.5708F));

		PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(27, 34).addBox(-5.0F, 1.5F, -5.25F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -0.25F, 3.1416F, 3.1416F, 0.0F));

		PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(36, 35).addBox(-4.25F, 3.5F, 4.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(36, 35).addBox(-4.25F, 3.5F, -5.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -0.25F, 0.0F, -1.5708F, 0.0F));

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.11F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -2.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.06F))
				.texOffs(40, 7).addBox(-3.0F, 5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.12F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-1.0F, -2.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.06F)).mirror(false)
				.texOffs(40, 7).mirror().addBox(-1.0F, 5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.12F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.05F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.12F))
				.texOffs(0, 20).addBox(-2.3F, -0.1F, -2.45F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.075F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -0.05F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.12F)).mirror(false)
				.texOffs(0, 20).mirror().addBox(-0.675F, -0.1F, -2.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.075F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition right_boot = partdefinition.addOrReplaceChild("right_boot", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, 10.075F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.34F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition left_boot = partdefinition.addOrReplaceChild("left_boot", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-2.0F, 10.075F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.34F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}