package net.xg787.xgsmi.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.Arrow;
import net.xg787.xgsmi.entity.projectile.PrismarineArrow;

import static net.xg787.xgsmi.Xgsmi.MOD_ID;

public class TippablePrismarineArrowRenderer extends ArrowRenderer<PrismarineArrow> {
    public static final ResourceLocation NORMAL_ARROW_LOCATION = ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/entity/projectiles/prismarine_arrow.png");
    public static final ResourceLocation TIPPED_ARROW_LOCATION = ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/entity/projectiles/tipped_prismarine_arrow.png");


    public TippablePrismarineArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(PrismarineArrow entity) {
        return entity.getColor() > 0 ? TIPPED_ARROW_LOCATION : NORMAL_ARROW_LOCATION;
    }
}
