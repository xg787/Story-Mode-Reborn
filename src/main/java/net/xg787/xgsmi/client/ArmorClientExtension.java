package net.xg787.xgsmi.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.xg787.xgsmi.client.model.armor.BaseArmorModel;
import net.xg787.xgsmi.client.provider.ArmorModelProvider;
import org.jetbrains.annotations.NotNull;

public class ArmorClientExtension implements IClientItemExtensions {

    private final ArmorModelProvider provider;

    public ArmorClientExtension(ArmorModelProvider provider) {
        this.provider = provider;
    }

    @Override
    public @NotNull BaseArmorModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> original) {
        BaseArmorModel armorModel = provider.getModel(living, stack, slot);
        armorModel.partVisible(slot);
        armorModel.crouching = original.crouching;
        armorModel.riding = original.riding;
        armorModel.young = original.young;
        return armorModel;
    }

    @Override
    public @NotNull Model getGenericArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
        BaseArmorModel model = getHumanoidArmorModel(livingEntity, itemStack, equipmentSlot, original);
        copyModelProperties(original, model);
        return model;
    }

    @SuppressWarnings("unchecked")
    private <T extends LivingEntity> void copyModelProperties(HumanoidModel<T> original, BaseArmorModel replacement) {
        original.copyPropertiesTo((HumanoidModel<T>) replacement);
        replacement.rightBoot.copyFrom(original.rightLeg);
        replacement.leftBoot.copyFrom(original.leftLeg);
    }
}
