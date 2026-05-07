package net.xg787.xgsmi.item;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static net.xg787.xgsmi.Xgsmi.MOD_ID;

public class XgsmiSmithingTemplateItem extends SmithingTemplateItem {
    private final DataComponentMap components;

    public XgsmiSmithingTemplateItem(Item.Properties properties, Component appliesTo, Component ingredients, Component upgradeDescription, Component baseSlotDescription, Component additionsSlotDescription, List<ResourceLocation> baseSlotEmptyIcons, List<ResourceLocation> additionalSlotEmptyIcons, FeatureFlag... requiredFeatures) {
        super(appliesTo, ingredients, upgradeDescription, baseSlotDescription, additionsSlotDescription, baseSlotEmptyIcons, additionalSlotEmptyIcons, requiredFeatures);
        this.components = properties.buildAndValidateComponents();
    }

    public @NotNull DataComponentMap components() {
        return this.components;
    }

    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final ResourceLocation EMPTY_SLOT_HELMET = ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_INGOT = ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/empty_slot_ingot");
    
    private static final Component TITANIUM_UPGRADE_APPLIES_TO = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.titanium_upgrade.applies_to"))
            )
            .withStyle(DESCRIPTION_FORMAT);
    
    private static final Component TITANIUM_UPGRADE_INGREDIENTS = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.titanium_upgrade.ingredients"))
            )
            .withStyle(DESCRIPTION_FORMAT);

    private static final Component TITANIUM_UPGRADE = Component.translatable(
                    Util.makeDescriptionId("upgrade", ResourceLocation.fromNamespaceAndPath(MOD_ID, "titanium_upgrade"))
            )
            .withStyle(TITLE_FORMAT);
    
    private static final Component TITANIUM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.titanium_upgrade.base_slot_description"))
    );
    
    private static final Component TITANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.titanium_upgrade.additions_slot_description"))
    );

    private static final Component ROMEUM_UPGRADE_APPLIES_TO = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.romeum_upgrade.applies_to"))
            )
            .withStyle(DESCRIPTION_FORMAT);

    private static final Component ROMEUM_UPGRADE_INGREDIENTS = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.romeum_upgrade.ingredients"))
            )
            .withStyle(DESCRIPTION_FORMAT);

    private static final Component ROMEUM_UPGRADE = Component.translatable(
                    Util.makeDescriptionId("upgrade", ResourceLocation.fromNamespaceAndPath(MOD_ID, "romeum_upgrade"))
            )
            .withStyle(TITLE_FORMAT);

    private static final Component ROMEUM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.romeum_upgrade.base_slot_description"))
    );

    private static final Component ROMEUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.romeum_upgrade.additions_slot_description"))
    );
    
    public static XgsmiSmithingTemplateItem createTitaniumUpgradeTemplate() {
        return new XgsmiSmithingTemplateItem(
                new Item.Properties().fireResistant(),
                TITANIUM_UPGRADE_APPLIES_TO,
                TITANIUM_UPGRADE_INGREDIENTS,
                TITANIUM_UPGRADE,
                TITANIUM_UPGRADE_BASE_SLOT_DESCRIPTION,
                TITANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createXgsmiUpgradeIconList(),
                createXgsmiUpgradeMaterialList()
        );
    }

    public static XgsmiSmithingTemplateItem createRomeumUpgradeTemplate() {
        return new XgsmiSmithingTemplateItem(
                new Item.Properties().fireResistant(),
                ROMEUM_UPGRADE_APPLIES_TO,
                ROMEUM_UPGRADE_INGREDIENTS,
                ROMEUM_UPGRADE,
                ROMEUM_UPGRADE_BASE_SLOT_DESCRIPTION,
                ROMEUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createXgsmiUpgradeIconList(),
                createXgsmiUpgradeMaterialList()
        );
    }


    private static List<ResourceLocation> createXgsmiUpgradeIconList() {
        return List.of(
                EMPTY_SLOT_HELMET,
                EMPTY_SLOT_CHESTPLATE,
                EMPTY_SLOT_LEGGINGS,
                EMPTY_SLOT_BOOTS,
                EMPTY_SLOT_SWORD,
                EMPTY_SLOT_PICKAXE,
                EMPTY_SLOT_AXE,
                EMPTY_SLOT_SHOVEL,
                EMPTY_SLOT_HOE
        );
    }

    private static List<ResourceLocation> createXgsmiUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
}
