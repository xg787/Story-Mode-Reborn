package net.xg787.xgsmi.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.Nullable;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;

public class GabrielArmorItem extends AbstractArmorItem {
    private static final ResourceLocation TEXTURE_LOCATION = makeCustomTextureLocation(MOD_ID, "gabriel_armor");
    private static final ResourceLocation ARM_TEXTURE_LOCATION = makeCustomTextureLocation(MOD_ID, "gabriel_armor_arm");
    public GabrielArmorItem(ArmorItem.Type pType, Item.Properties properties) {
        super(StoryModeRebornArmorMaterials.MCSM_TITANIUM, pType, properties);
    }

    @Override
    public ResourceLocation getTexture() {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getArmTexture() {
        return ARM_TEXTURE_LOCATION;
    }
}
