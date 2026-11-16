package net.xg787.story_mode_reborn.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.jarjar.nio.util.Lazy;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.xg787.story_mode_reborn.item.RedstoneHeartItem;

public class RedstoneHeartItemRenderer extends BlockEntityWithoutLevelRenderer {
    public static final Lazy<RedstoneHeartItemRenderer> REDSTONE_HEART_ITEM_RENDERER = Lazy
            .of(() -> new RedstoneHeartItemRenderer(Minecraft.getInstance().getEntityRenderDispatcher()));

    private final EntityRenderDispatcher entityRenderDispatcher;

    public RedstoneHeartItemRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        this.entityRenderDispatcher = entityRenderDispatcher;
    }

    public static IClientItemExtensions getItemRenderProperties() {
        return new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return REDSTONE_HEART_ITEM_RENDERER.get();
            }
        };
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5, 0, 0.5);
        if (stack.getItem() instanceof RedstoneHeartItem redstoneHeartItem) {
            Entity redstoneHeartEntity = redstoneHeartItem.getRenderEntity();
            if (redstoneHeartEntity != null) {
                this.entityRenderDispatcher.render(redstoneHeartEntity,
                        0, 0, 0,
                        0.0F, 1.0F,
                        poseStack, bufferSource, packedLight);
            }
        }
        poseStack.popPose();
    }
}
