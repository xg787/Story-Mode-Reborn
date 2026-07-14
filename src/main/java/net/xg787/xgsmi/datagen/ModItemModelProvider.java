package net.xg787.xgsmi.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.*;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MOD_ID, existingFileHelper);
    }

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();

    @Override
    protected void registerModels() {
        basicItem(ICON.get());

        basicItem(WHITE_PUMPKIN_SEEDS.get());
        basicItem(WHITE_PUMPKIN_PIE.get());
        handheldItem(PRISMARINE_ROD.get());
        handheldItem(PRISMARINE_SWORD.get());
        handheldItem(PRISMARINE_PICKAXE.get());
        handheldItem(PRISMARINE_AXE.get());
        handheldItem(PRISMARINE_SHOVEL.get());
        handheldItem(PRISMARINE_HOE.get());
        basicItem(PRISMARINE_ARROW.get());

        handheldItem(ROYAL_SWORD.get());
        handheldItem(ROYAL_PICKAXE.get());
        handheldItem(ROYAL_AXE.get());
        handheldItem(ROYAL_SHOVEL.get());
        handheldItem(ROYAL_HOE.get());

        basicItem(ENCHANTED_FLINT_AND_STEEL_DIAMOND.get());
        basicItem(ENCHANTED_FLINT_AND_STEEL_EMERALD.get());
        basicItem(ENCHANTED_FLINT_AND_STEEL_GOLD.get());
        basicItem(ENCHANTED_FLINT_AND_STEEL_REDSTONE.get());
        
        basicItem(RAW_TITANIUM.get());
        basicItem(TITANIUM_INGOT.get());

        handheldItem(TITANIUM_SWORD.get());
        handheldItem(TITANIUM_PICKAXE.get());
        handheldItem(TITANIUM_AXE.get());
        handheldItem(TITANIUM_SHOVEL.get());
        handheldItem(TITANIUM_HOE.get());
        trimmedArmorItem(TITANIUM_HELMET);
        trimmedArmorItem(TITANIUM_CHESTPLATE);
        trimmedArmorItem(TITANIUM_LEGGINGS);
        trimmedArmorItem(TITANIUM_BOOTS);

        handheldItem(ENCHANTED_TITANIUM_SWORD.get());
        handheldItem(ENCHANTED_TITANIUM_PICKAXE.get());
        handheldItem(ENCHANTED_TITANIUM_AXE.get());
        handheldItem(ENCHANTED_TITANIUM_SHOVEL.get());
        handheldItem(ENCHANTED_TITANIUM_HOE.get());
        trimmedArmorItem(ENCHANTED_TITANIUM_HELMET);
        trimmedArmorItem(ENCHANTED_TITANIUM_CHESTPLATE);
        trimmedArmorItem(ENCHANTED_TITANIUM_LEGGINGS);
        trimmedArmorItem(ENCHANTED_TITANIUM_BOOTS);

        basicItem(RAW_ROMEUM.get());
        basicItem(ROMEUM_INGOT.get());

        handheldItem(ROMEUM_SWORD.get());
        handheldItem(ROMEUM_PICKAXE.get());
        handheldItem(ROMEUM_AXE.get());
        handheldItem(ROMEUM_SHOVEL.get());
        handheldItem(ROMEUM_HOE.get());
        trimmedArmorItem(ROMEUM_HELMET);
        trimmedArmorItem(ROMEUM_CHESTPLATE);
        trimmedArmorItem(ROMEUM_LEGGINGS);
        trimmedArmorItem(ROMEUM_BOOTS);

        handheldItem(ENCHANTED_ROMEUM_SWORD.get());
        handheldItem(ENCHANTED_ROMEUM_PICKAXE.get());
        handheldItem(ENCHANTED_ROMEUM_AXE.get());
        handheldItem(ENCHANTED_ROMEUM_SHOVEL.get());
        handheldItem(ENCHANTED_ROMEUM_HOE.get());
        trimmedArmorItem(ENCHANTED_ROMEUM_HELMET);
        trimmedArmorItem(ENCHANTED_ROMEUM_CHESTPLATE);
        trimmedArmorItem(ENCHANTED_ROMEUM_LEGGINGS);
        trimmedArmorItem(ENCHANTED_ROMEUM_BOOTS);
        
        basicItem(BLANK_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(TITANIUM_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(TITANIUM_ENCHANT_SMITHING_TEMPLATE.get());
        basicItem(ROMEUM_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(ROMEUM_ENCHANT_SMITHING_TEMPLATE.get());
        basicItem(BLANK_BASIC_ARMOR_TEMPLATE.get());
        basicItem(BASIC_ARMOR_TEMPLATE.get());
        basicItem(BLANK_ARMOR_TEMPLATE.get());

        basicItem(GABRIEL_HELMET.get());
        basicItem(GABRIEL_CHESTPLATE.get());
        basicItem(GABRIEL_LEGGINGS.get());
        basicItem(GABRIEL_BOOTS.get());
    }

    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemDeferredItem.getId().getPath(), mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }

    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
}
