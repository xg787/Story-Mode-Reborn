package net.xg787.story_mode_reborn.client.provider;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.xg787.story_mode_reborn.client.model.armor.BaseArmorModel;

public interface ArmorModelProvider {
    BaseArmorModel getModel(LivingEntity living, ItemStack stack, EquipmentSlot slot);
}
