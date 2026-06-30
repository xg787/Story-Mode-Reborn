package net.xg787.xgsmi.client.provider;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.xg787.xgsmi.client.model.armor.BaseArmorModel;

import java.util.function.Function;
import java.util.function.Supplier;

public class SimpleModelProvider implements ArmorModelProvider {
    private final BaseArmorModel model;

    public SimpleModelProvider(Supplier<LayerDefinition> definitionSupplier, Function<ModelPart, BaseArmorModel> model) {
        this.model = model.apply(definitionSupplier.get().bakeRoot());
    }

    @Override
    public BaseArmorModel getModel(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
        return model;
    }
}
