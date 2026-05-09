package net.xg787.xgsmi.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static net.xg787.xgsmi.Xgsmi.MOD_ID;
import static net.xg787.xgsmi.registry.XgsmiItems.*;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ICON.get());

        basicItem(WHITE_PUMPKIN_SEEDS.get());
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
        handheldItem(ENCHANTED_TITANIUM_SWORD.get());
        handheldItem(ENCHANTED_TITANIUM_PICKAXE.get());
        handheldItem(ENCHANTED_TITANIUM_AXE.get());
        handheldItem(ENCHANTED_TITANIUM_SHOVEL.get());
        handheldItem(ENCHANTED_TITANIUM_HOE.get());

        basicItem(RAW_ROMEUM.get());
        basicItem(ROMEUM_INGOT.get());
        handheldItem(ROMEUM_SWORD.get());
        handheldItem(ROMEUM_PICKAXE.get());
        handheldItem(ROMEUM_AXE.get());
        handheldItem(ROMEUM_SHOVEL.get());
        handheldItem(ROMEUM_HOE.get());
        handheldItem(ENCHANTED_ROMEUM_SWORD.get());
        handheldItem(ENCHANTED_ROMEUM_PICKAXE.get());
        handheldItem(ENCHANTED_ROMEUM_AXE.get());
        handheldItem(ENCHANTED_ROMEUM_SHOVEL.get());
        handheldItem(ENCHANTED_ROMEUM_HOE.get());
        
        basicItem(BLANK_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(TITANIUM_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(TITANIUM_ENCHANT_SMITHING_TEMPLATE.get());
        basicItem(ROMEUM_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(ROMEUM_ENCHANT_SMITHING_TEMPLATE.get());
        basicItem(BLANK_BASIC_ARMOR_TEMPLATE.get());
        basicItem(BASIC_ARMOR_TEMPLATE.get());
        basicItem(BLANK_ARMOR_TEMPLATE.get());
    }
}
