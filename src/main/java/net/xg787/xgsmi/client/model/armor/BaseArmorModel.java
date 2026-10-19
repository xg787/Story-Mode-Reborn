package net.xg787.xgsmi.client.model.armor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class BaseArmorModel extends HumanoidModel<LivingEntity> {
    public final ModelPart leftBoot;
    public final ModelPart rightBoot;

    public BaseArmorModel(ModelPart pRoot) {
        super(pRoot);
        this.leftBoot = pRoot.getChild("left_boot");
        this.rightBoot = pRoot.getChild("right_boot");
    }

    @Override
    public void setAllVisible(boolean pVisible) {
        super.setAllVisible(pVisible);
        this.leftBoot.visible = pVisible;
        this.rightBoot.visible = pVisible;
    }

    public void partVisible(EquipmentSlot slot) {
        this.setAllVisible(false);
        switch (slot) {
            case HEAD:
                this.head.visible = true;
                this.hat.visible = true;
                break;
            case CHEST:
                this.body.visible = true;
                this.rightArm.visible = true;
                this.leftArm.visible = true;
                break;
            case LEGS:
                this.leftLeg.visible = true;
                this.rightLeg.visible = true;
                break;
            case FEET:
                this.leftBoot.visible = true;
                this.rightBoot.visible = true;
        }
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack stack, @NotNull VertexConsumer consumer, int packedLight, int packedOverlay, int color) {
        super.renderToBuffer(stack, consumer, packedLight, packedOverlay, color);
        this.leftBoot.render(stack, consumer, packedLight, packedOverlay, color);
        this.rightBoot.render(stack, consumer, packedLight, packedOverlay, color);
    }
}
