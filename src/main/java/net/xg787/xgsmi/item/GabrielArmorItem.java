package net.xg787.xgsmi.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.Nullable;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;

public class GabrielArmorItem extends AbstractArmorItem {
    private static final ResourceLocation TEXTURE_LOCATION = makeCustomTextureLocation(MOD_ID, "gabriel_armor");

    public GabrielArmorItem(ArmorItem.Type pType, Item.Properties properties) {
        super(StoryModeRebornArmorMaterials.MCSM_TITANIUM, pType, properties);
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean inner) {
        return TEXTURE_LOCATION;
    }
}
