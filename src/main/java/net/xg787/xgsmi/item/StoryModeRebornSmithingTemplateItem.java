package net.xg787.xgsmi.item;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;

public class StoryModeRebornSmithingTemplateItem extends SmithingTemplateItem {
    private final DataComponentMap components;

    public StoryModeRebornSmithingTemplateItem(Item.Properties properties, Component appliesTo, Component ingredients, Component upgradeDescription, Component baseSlotDescription, Component additionsSlotDescription, List<ResourceLocation> baseSlotEmptyIcons, List<ResourceLocation> additionalSlotEmptyIcons, FeatureFlag... requiredFeatures) {
        super(appliesTo, ingredients, upgradeDescription, baseSlotDescription, additionsSlotDescription, baseSlotEmptyIcons, additionalSlotEmptyIcons, requiredFeatures);
        this.components = properties.buildAndValidateComponents();
    }

    public @NotNull DataComponentMap components() {
        return this.components;
    }

    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final ResourceLocation EMPTY_SLOT_HELMET = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = ResourceLocation.withDefaultNamespace("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = ResourceLocation.withDefaultNamespace("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = ResourceLocation.withDefaultNamespace("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = ResourceLocation.withDefaultNamespace("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_AMETHYST_SHARD = ResourceLocation.withDefaultNamespace("item/empty_slot_amethyst_shard");
    private static final ResourceLocation EMPTY_SLOT_DIAMOND = ResourceLocation.withDefaultNamespace("item/empty_slot_diamond");
    private static final ResourceLocation EMPTY_SLOT_EMERALD = ResourceLocation.withDefaultNamespace("item/empty_slot_emerald");
    private static final ResourceLocation EMPTY_SLOT_INGOT = ResourceLocation.withDefaultNamespace("item/empty_slot_ingot");
    private static final ResourceLocation EMPTY_SLOT_LAPIS_LAZULI = ResourceLocation.withDefaultNamespace("item/empty_slot_lapis_lazuli");
    private static final ResourceLocation EMPTY_SLOT_QUARTZ = ResourceLocation.withDefaultNamespace("item/empty_slot_quartz");
    private static final ResourceLocation EMPTY_SLOT_REDSTONE_DUST = ResourceLocation.withDefaultNamespace("item/empty_slot_redstone_dust");
    private static final ResourceLocation EMPTY_SLOT_LEATHER = ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/empty_slot_leather");
    private static final ResourceLocation EMPTY_SLOT_BALL = ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/empty_slot_ball");
    private static final ResourceLocation EMPTY_SLOT_BLOCK = ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/empty_slot_block");

    private static final Component MCSM_LEATHER_APPLIES_TO = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.mcsm_leather.applies_to"))
            )
            .withStyle(DESCRIPTION_FORMAT);

    private static final Component MCSM_LEATHER_INGREDIENTS = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.mcsm_leather.ingredients"))
            )
            .withStyle(DESCRIPTION_FORMAT);

    private static final Component MCSM_LEATHER_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.mcsm_leather.base_slot_description"))
    );

    private static final Component MCSM_LEATHER_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.mcsm_leather.additions_slot_description"))
    );

    private static final Component ARMOR_NUMBER_7_UPGRADE = Component.translatable(
                    Util.makeDescriptionId("upgrade", ResourceLocation.fromNamespaceAndPath(MOD_ID, "armor_number_7"))
            )
            .withStyle(TITLE_FORMAT);

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

    private static final Component TITANIUM_ENCHANT_APPLIES_TO = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.titanium_enchant.applies_to"))
            )
            .withStyle(DESCRIPTION_FORMAT);

    private static final Component TITANIUM_ENCHANT = Component.translatable(
                    Util.makeDescriptionId("upgrade", ResourceLocation.fromNamespaceAndPath(MOD_ID, "titanium_enchant"))
            )
            .withStyle(TITLE_FORMAT);

    private static final Component TITANIUM_ENCHANT_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.titanium_enchant.base_slot_description"))
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

    private static final Component ROMEUM_ENCHANT_APPLIES_TO = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.romeum_enchant.applies_to"))
            )
            .withStyle(DESCRIPTION_FORMAT);

    private static final Component ROMEUM_ENCHANT = Component.translatable(
                    Util.makeDescriptionId("upgrade", ResourceLocation.fromNamespaceAndPath(MOD_ID, "romeum_enchant"))
            )
            .withStyle(TITLE_FORMAT);

    private static final Component ROMEUM_ENCHANT_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.romeum_enchant.base_slot_description"))
    );

    private static final Component MCSM_TITANIUM_ARMOR_APPLIES_TO = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.mcsm_titanium_armor_upgrade.applies_to"))
            )
            .withStyle(DESCRIPTION_FORMAT);

    private static final Component MCSM_TITANIUM_ARMOR_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.mcsm_titanium_armor_upgrade.base_slot_description"))
    );

    private static final Component GABRIEL_ARMOR_INGREDIENTS = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.gabriel_upgrade.ingredients"))
            )
            .withStyle(DESCRIPTION_FORMAT);

    private static final Component GABRIEL_ARMOR = Component.translatable(
                    Util.makeDescriptionId("upgrade", ResourceLocation.fromNamespaceAndPath(MOD_ID, "gabriel_armor"))
            )
            .withStyle(TITLE_FORMAT);

    private static final Component GABRIEL_ARMOR_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(MOD_ID, "smithing_template.gabriel_armor_upgrade.additions_slot_description"))
    );

    public static StoryModeRebornSmithingTemplateItem createArmorNumber7Template() {
        return new StoryModeRebornSmithingTemplateItem(
                new Item.Properties().rarity(Rarity.UNCOMMON),
                MCSM_LEATHER_APPLIES_TO,
                MCSM_LEATHER_INGREDIENTS,
                ARMOR_NUMBER_7_UPGRADE,
                MCSM_LEATHER_BASE_SLOT_DESCRIPTION,
                MCSM_LEATHER_ADDITIONS_SLOT_DESCRIPTION,
                createXgsmiArmorIconList(),
                createXgsmiUpgradeLeatherMaterial()
        );
    }
    
    public static StoryModeRebornSmithingTemplateItem createTitaniumUpgradeTemplate() {
        return new StoryModeRebornSmithingTemplateItem(
                new Item.Properties().fireResistant().rarity(Rarity.RARE),
                TITANIUM_UPGRADE_APPLIES_TO,
                TITANIUM_UPGRADE_INGREDIENTS,
                TITANIUM_UPGRADE,
                TITANIUM_UPGRADE_BASE_SLOT_DESCRIPTION,
                TITANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createXgsmiUpgradeIconList(),
                createXgsmiUpgradeIngotMaterial()
        );
    }

    public static StoryModeRebornSmithingTemplateItem createTitaniumEnchantTemplate() {
        return new StoryModeRebornSmithingTemplateItem(
                new Item.Properties().fireResistant().rarity(Rarity.RARE).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true),
                TITANIUM_ENCHANT_APPLIES_TO,
                TITANIUM_UPGRADE_INGREDIENTS,
                TITANIUM_ENCHANT,
                TITANIUM_ENCHANT_BASE_SLOT_DESCRIPTION,
                TITANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createXgsmiUpgradeIconList(),
                createXgsmiUpgradeIngotMaterial()
        );
    }

    public static StoryModeRebornSmithingTemplateItem createRomeumUpgradeTemplate() {
        return new StoryModeRebornSmithingTemplateItem(
                new Item.Properties().fireResistant().rarity(Rarity.EPIC),
                ROMEUM_UPGRADE_APPLIES_TO,
                ROMEUM_UPGRADE_INGREDIENTS,
                ROMEUM_UPGRADE,
                ROMEUM_UPGRADE_BASE_SLOT_DESCRIPTION,
                ROMEUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createXgsmiUpgradeIconList(),
                createXgsmiUpgradeIngotMaterial()
        );
    }

    public static StoryModeRebornSmithingTemplateItem createRomeumEnchantTemplate() {
        return new StoryModeRebornSmithingTemplateItem(
                new Item.Properties().fireResistant().rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true),
                ROMEUM_ENCHANT_APPLIES_TO,
                ROMEUM_UPGRADE_INGREDIENTS,
                ROMEUM_ENCHANT,
                ROMEUM_ENCHANT_BASE_SLOT_DESCRIPTION,
                ROMEUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createXgsmiUpgradeIconList(),
                createXgsmiUpgradeIngotMaterial()
        );
    }

    public static StoryModeRebornSmithingTemplateItem createGabrielArmorTemplate() {
        return new StoryModeRebornSmithingTemplateItem(
                new Item.Properties().fireResistant().rarity(Rarity.RARE),
                MCSM_TITANIUM_ARMOR_APPLIES_TO,
                GABRIEL_ARMOR_INGREDIENTS,
                GABRIEL_ARMOR,
                MCSM_TITANIUM_ARMOR_BASE_SLOT_DESCRIPTION,
                GABRIEL_ARMOR_ADDITIONS_SLOT_DESCRIPTION,
                createXgsmiArmorFullIconList(),
                createXgsmiUpgradeDiamondMaterial()
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

    private static List<ResourceLocation> createXgsmiArmorFullIconList() {
        return List.of(
                EMPTY_SLOT_HELMET,
                EMPTY_SLOT_CHESTPLATE,
                EMPTY_SLOT_LEGGINGS,
                EMPTY_SLOT_BOOTS
        );
    }

    private static List<ResourceLocation> createXgsmiArmorIconList() {
        return List.of(
                EMPTY_SLOT_CHESTPLATE,
                EMPTY_SLOT_LEGGINGS,
                EMPTY_SLOT_BOOTS
        );
    }

    private static List<ResourceLocation> createXgsmiUpgradeShardMaterial() {
        return List.of(EMPTY_SLOT_AMETHYST_SHARD);
    }

    private static List<ResourceLocation> createXgsmiUpgradeDiamondMaterial() {
        return List.of(EMPTY_SLOT_DIAMOND);
    }

    private static List<ResourceLocation> createXgsmiUpgradeEmeraldMaterial() {
        return List.of(EMPTY_SLOT_EMERALD);
    }

    private static List<ResourceLocation> createXgsmiUpgradeIngotMaterial() {
        return List.of(EMPTY_SLOT_INGOT);
    }

    private static List<ResourceLocation> createXgsmiUpgradeLapisMaterial() {
        return List.of(EMPTY_SLOT_LAPIS_LAZULI);
    }

    private static List<ResourceLocation> createXgsmiUpgradeQuartzMaterial() {
        return List.of(EMPTY_SLOT_QUARTZ);
    }

    private static List<ResourceLocation> createXgsmiUpgradeDustMaterial() {
        return List.of(EMPTY_SLOT_REDSTONE_DUST);
    }

    private static List<ResourceLocation> createXgsmiUpgradeLeatherMaterial() {
        return List.of(EMPTY_SLOT_LEATHER);
    }

    private static List<ResourceLocation> createXgsmiUpgradeBallMaterial() {
        return List.of(EMPTY_SLOT_BALL);
    }

    private static List<ResourceLocation> createXgsmiUpgradeBlockMaterial() {
        return List.of(EMPTY_SLOT_BLOCK);
    }
}
