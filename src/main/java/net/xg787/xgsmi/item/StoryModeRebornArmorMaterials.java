package net.xg787.xgsmi.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.xg787.xgsmi.registry.StoryModeRebornItems;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import static net.minecraft.world.item.Items.IRON_INGOT;
import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;

public class StoryModeRebornArmorMaterials {

    public static final Holder<ArmorMaterial> MCSM_LEATHER = register("mcsm_leather",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 5);
                attribute.put(ArmorItem.Type.LEGGINGS, 4);
                attribute.put(ArmorItem.Type.BOOTS, 2);
                attribute.put(ArmorItem.Type.BODY, 5);
            }),SoundEvents.ARMOR_EQUIP_LEATHER, 8, 0.0F, 0.0F, () -> IRON_INGOT);


    public static final Holder<ArmorMaterial> TITANIUM = register("titanium",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 3);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.LEGGINGS, 7);
                attribute.put(ArmorItem.Type.BOOTS, 3);
                attribute.put(ArmorItem.Type.BODY, 12);
            }),SoundEvents.ARMOR_EQUIP_NETHERITE, 20, 3.5f, 0.2f, () -> StoryModeRebornItems.TITANIUM_INGOT.get());

    public static final Holder<ArmorMaterial> ENCHANTED_TITANIUM = register("enchanted_titanium",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 4);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.LEGGINGS, 7);
                attribute.put(ArmorItem.Type.BOOTS, 4);
                attribute.put(ArmorItem.Type.BODY, 13);
            }),SoundEvents.ARMOR_EQUIP_NETHERITE, 25, 3.5f, 0.25f, () -> StoryModeRebornItems.TITANIUM_INGOT.get());

    public static final Holder<ArmorMaterial> MCSM_TITANIUM = register("mcsm_titanium",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 5);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.LEGGINGS, 8);
                attribute.put(ArmorItem.Type.BOOTS, 5);
                attribute.put(ArmorItem.Type.BODY, 15);
            }),SoundEvents.ARMOR_EQUIP_NETHERITE, 35, 4.5f, 0.4f, () -> StoryModeRebornItems.TITANIUM_INGOT.get());

    public static final Holder<ArmorMaterial> ROMEUM = register("romeum",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 4);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.LEGGINGS, 7);
                attribute.put(ArmorItem.Type.BOOTS, 5);
                attribute.put(ArmorItem.Type.BODY, 14);
            }),SoundEvents.ARMOR_EQUIP_NETHERITE, 30, 4.0f, 0.3f, () -> StoryModeRebornItems.ROMEUM_INGOT.get());

    public static final Holder<ArmorMaterial> ENCHANTED_ROMEUM = register("enchanted_romeum",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 5);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.LEGGINGS, 7);
                attribute.put(ArmorItem.Type.BOOTS, 5);
                attribute.put(ArmorItem.Type.BODY, 15);
            }),SoundEvents.ARMOR_EQUIP_NETHERITE, 35, 4.5f, 0.35f, () -> StoryModeRebornItems.ROMEUM_INGOT.get());

    public static final Holder<ArmorMaterial> CHAMPION = register("champion",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 9);
                attribute.put(ArmorItem.Type.LEGGINGS, 9);
                attribute.put(ArmorItem.Type.BOOTS, 6);
                attribute.put(ArmorItem.Type.BODY, 17);
            }),SoundEvents.ARMOR_EQUIP_NETHERITE, 45, 5.5f, 0.45f, () -> StoryModeRebornItems.ROMEUM_INGOT.get());


    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection, Holder<SoundEvent> equipSound, int enchantability, float toughness, float knockbackResistance, Supplier<Item> ingredientItem) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location, new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}
