package net.xg787.xgsmi.registry;

import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.xg787.xgsmi.item.PrismarineArrowItem;
import net.xg787.xgsmi.item.TippedPrismarineArrowItem;
import net.xg787.xgsmi.item.XgsmiSmithingTemplateItem;
import net.xg787.xgsmi.item.XgsmiToolTiers;

import static net.xg787.xgsmi.Xgsmi.MOD_ID;
import static net.xg787.xgsmi.registry.XgsmiBlocks.WHITE_PUMPKIN_STEM;

public class XgsmiItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final DeferredItem<Item> ICON = ITEMS.registerSimpleItem("icon");

    public static final DeferredItem<Item> WHITE_PUMPKIN_SEEDS = ITEMS.register("white_pumpkin_seeds", () -> new ItemNameBlockItem(WHITE_PUMPKIN_STEM.get(), new Item.Properties()));

    public static final DeferredItem<Item> PRISMARINE_ROD = ITEMS.registerSimpleItem("prismarine_rod");
    public static final DeferredItem<Item> PRISMARINE_FISHING_ROD = ITEMS.register("prismarine_fishing_rod", () -> new FishingRodItem(new Item.Properties().durability(128)));
    public static final DeferredItem<Item> PRISMARINE_SWORD = ITEMS.register("prismarine_sword", () -> new SwordItem(XgsmiToolTiers.PRISMARINE, new Item.Properties().attributes(SwordItem.createAttributes(XgsmiToolTiers.PRISMARINE, 3, -2.4F))));
    public static final DeferredItem<Item> PRISMARINE_PICKAXE = ITEMS.register("prismarine_pickaxe", () ->  new PickaxeItem(XgsmiToolTiers.PRISMARINE, new Item.Properties().attributes(PickaxeItem.createAttributes(XgsmiToolTiers.PRISMARINE, 1.0F, -2.8F))));
    public static final DeferredItem<Item> PRISMARINE_AXE = ITEMS.register("prismarine_axe", () ->  new AxeItem(XgsmiToolTiers.PRISMARINE, new Item.Properties().attributes(AxeItem.createAttributes(XgsmiToolTiers.PRISMARINE, 6.0F, -3.1F))));
    public static final DeferredItem<Item> PRISMARINE_SHOVEL = ITEMS.register("prismarine_shovel", () -> new ShovelItem(XgsmiToolTiers.PRISMARINE, new Item.Properties().attributes(ShovelItem.createAttributes(XgsmiToolTiers.PRISMARINE, 1.5F, -3.0F))));
    public static final DeferredItem<Item> PRISMARINE_HOE = ITEMS.register("prismarine_hoe", () ->  new HoeItem(XgsmiToolTiers.PRISMARINE, new Item.Properties().attributes(HoeItem.createAttributes(XgsmiToolTiers.PRISMARINE, -2.0F, -1.0F))));
    public static final DeferredItem<Item> PRISMARINE_BOW = ITEMS.register("prismarine_bow", () -> new BowItem(new Item.Properties().durability(768)));
    public static final DeferredItem<Item> PRISMARINE_ARROW = ITEMS.register("prismarine_arrow", () -> new PrismarineArrowItem(new Item.Properties()));
    public static final DeferredItem<Item> TIPPED_PRISMARINE_ARROW = ITEMS.register("tipped_prismarine_arrow", () -> new TippedPrismarineArrowItem(new Item.Properties()));

    public static final DeferredItem<Item> ROYAL_SWORD = ITEMS.register("royal_sword", () ->  new SwordItem(XgsmiToolTiers.ROYAL, new Item.Properties().attributes(SwordItem.createAttributes(XgsmiToolTiers.ROYAL, 3, -2.4F))));
    public static final DeferredItem<Item> ROYAL_PICKAXE = ITEMS.register("royal_pickaxe", () ->  new PickaxeItem(XgsmiToolTiers.ROYAL, new Item.Properties().attributes(PickaxeItem.createAttributes(XgsmiToolTiers.ROYAL, 1.0F, -2.8F))));
    public static final DeferredItem<Item> ROYAL_AXE = ITEMS.register("royal_axe", () ->  new AxeItem(XgsmiToolTiers.ROYAL, new Item.Properties().attributes(AxeItem.createAttributes(XgsmiToolTiers.ROYAL, 5.0F, -3.1F))));
    public static final DeferredItem<Item> ROYAL_SHOVEL = ITEMS.register("royal_shovel", () -> new ShovelItem(XgsmiToolTiers.ROYAL, new Item.Properties().attributes(ShovelItem.createAttributes(XgsmiToolTiers.ROYAL, 1.5F, -3.0F))));
    public static final DeferredItem<Item> ROYAL_HOE = ITEMS.register("royal_hoe", () ->  new HoeItem(XgsmiToolTiers.ROYAL, new Item.Properties().attributes(HoeItem.createAttributes(XgsmiToolTiers.ROYAL, -2.0F, 0.0F))));

    public static final DeferredItem<Item> ENCHANTED_FLINT_AND_STEEL_DIAMOND = ITEMS.register("enchanted_flint_and_steel_diamond", () -> new FlintAndSteelItem(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> ENCHANTED_FLINT_AND_STEEL_EMERALD = ITEMS.register("enchanted_flint_and_steel_emerald", () -> new FlintAndSteelItem(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> ENCHANTED_FLINT_AND_STEEL_GOLD = ITEMS.register("enchanted_flint_and_steel_gold", () -> new FlintAndSteelItem(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> ENCHANTED_FLINT_AND_STEEL_REDSTONE = ITEMS.register("enchanted_flint_and_steel_redstone", () -> new FlintAndSteelItem(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> RAW_TITANIUM = ITEMS.registerSimpleItem("raw_titanium");
    public static final DeferredItem<Item> TITANIUM_INGOT = ITEMS.registerSimpleItem("titanium_ingot");

    public static final DeferredItem<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", () -> new SwordItem(XgsmiToolTiers.TITANIUM, new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(XgsmiToolTiers.TITANIUM, 3, -2.4F))));
    public static final DeferredItem<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", () -> new PickaxeItem(XgsmiToolTiers.TITANIUM, new Item.Properties().fireResistant().attributes(PickaxeItem.createAttributes(XgsmiToolTiers.TITANIUM, 1.0F, -2.8F))));
    public static final DeferredItem<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", () -> new AxeItem(XgsmiToolTiers.TITANIUM, new Item.Properties().fireResistant().attributes(AxeItem.createAttributes(XgsmiToolTiers.TITANIUM, 5.0F, -3.0F))));
    public static final DeferredItem<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", () -> new ShovelItem(XgsmiToolTiers.TITANIUM, new Item.Properties().fireResistant().attributes(ShovelItem.createAttributes(XgsmiToolTiers.TITANIUM, 1.5F, -3.0F))));
    public static final DeferredItem<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", () -> new HoeItem(XgsmiToolTiers.TITANIUM, new Item.Properties().fireResistant().attributes(HoeItem.createAttributes(XgsmiToolTiers.TITANIUM, -4.0F, 0.0F))));

    public static final DeferredItem<Item> ENCHANTED_TITANIUM_SWORD = ITEMS.register("enchanted_titanium_sword", () -> new SwordItem(XgsmiToolTiers.ENCHANTED_TITANIUM, new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(XgsmiToolTiers.ENCHANTED_TITANIUM, 3, -2.4F))));
    public static final DeferredItem<Item> ENCHANTED_TITANIUM_PICKAXE = ITEMS.register("enchanted_titanium_pickaxe", () -> new PickaxeItem(XgsmiToolTiers.ENCHANTED_TITANIUM, new Item.Properties().fireResistant().attributes(PickaxeItem.createAttributes(XgsmiToolTiers.ENCHANTED_TITANIUM, 1.0F, -2.8F))));
    public static final DeferredItem<Item> ENCHANTED_TITANIUM_AXE = ITEMS.register("enchanted_titanium_axe", () -> new AxeItem(XgsmiToolTiers.ENCHANTED_TITANIUM, new Item.Properties().fireResistant().attributes(AxeItem.createAttributes(XgsmiToolTiers.ENCHANTED_TITANIUM, 5.0F, -3.0F))));
    public static final DeferredItem<Item> ENCHANTED_TITANIUM_SHOVEL = ITEMS.register("enchanted_titanium_shovel", () -> new ShovelItem(XgsmiToolTiers.ENCHANTED_TITANIUM, new Item.Properties().fireResistant().attributes(ShovelItem.createAttributes(XgsmiToolTiers.ENCHANTED_TITANIUM, 1.5F, -3.0F))));
    public static final DeferredItem<Item> ENCHANTED_TITANIUM_HOE = ITEMS.register("enchanted_titanium_hoe", () -> new HoeItem(XgsmiToolTiers.ENCHANTED_TITANIUM, new Item.Properties().fireResistant().attributes(HoeItem.createAttributes(XgsmiToolTiers.ENCHANTED_TITANIUM, -4.0F, 0.0F))));

    public static final DeferredItem<Item> RAW_ROMEUM = ITEMS.registerSimpleItem("raw_romeum", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ROMEUM_INGOT = ITEMS.registerSimpleItem("romeum_ingot", new Item.Properties().fireResistant());

    public static final DeferredItem<Item> ROMEUM_SWORD = ITEMS.register("romeum_sword", () -> new SwordItem(XgsmiToolTiers.ROMEUM, new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(XgsmiToolTiers.ROMEUM, 3, -2.4F))));
    public static final DeferredItem<Item> ROMEUM_PICKAXE = ITEMS.register("romeum_pickaxe", () -> new PickaxeItem(XgsmiToolTiers.ROMEUM, new Item.Properties().fireResistant().attributes(PickaxeItem.createAttributes(XgsmiToolTiers.ROMEUM, 1.0F, -2.8F))));
    public static final DeferredItem<Item> ROMEUM_AXE = ITEMS.register("romeum_axe", () -> new AxeItem(XgsmiToolTiers.ROMEUM, new Item.Properties().fireResistant().attributes(AxeItem.createAttributes(XgsmiToolTiers.ROMEUM, 5.0F, -3.0F))));
    public static final DeferredItem<Item> ROMEUM_SHOVEL = ITEMS.register("romeum_shovel", () -> new ShovelItem(XgsmiToolTiers.ROMEUM, new Item.Properties().fireResistant().attributes(ShovelItem.createAttributes(XgsmiToolTiers.ROMEUM, 1.5F, -3.0F))));
    public static final DeferredItem<Item> ROMEUM_HOE = ITEMS.register("romeum_hoe", () -> new HoeItem(XgsmiToolTiers.ROMEUM, new Item.Properties().fireResistant().attributes(HoeItem.createAttributes(XgsmiToolTiers.ROMEUM, -4.0F, 0.0F))));

    public static final DeferredItem<Item> ENCHANTED_ROMEUM_SWORD = ITEMS.register("enchanted_romeum_sword", () -> new SwordItem(XgsmiToolTiers.ENCHANTED_ROMEUM, new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(XgsmiToolTiers.ENCHANTED_ROMEUM, 3, -2.4F))));
    public static final DeferredItem<Item> ENCHANTED_ROMEUM_PICKAXE = ITEMS.register("enchanted_romeum_pickaxe", () -> new PickaxeItem(XgsmiToolTiers.ENCHANTED_ROMEUM, new Item.Properties().fireResistant().attributes(PickaxeItem.createAttributes(XgsmiToolTiers.ENCHANTED_ROMEUM, 1.0F, -2.8F))));
    public static final DeferredItem<Item> ENCHANTED_ROMEUM_AXE = ITEMS.register("enchanted_romeum_axe", () -> new AxeItem(XgsmiToolTiers.ENCHANTED_ROMEUM, new Item.Properties().fireResistant().attributes(AxeItem.createAttributes(XgsmiToolTiers.ENCHANTED_ROMEUM, 5.0F, -3.0F))));
    public static final DeferredItem<Item> ENCHANTED_ROMEUM_SHOVEL = ITEMS.register("enchanted_romeum_shovel", () -> new ShovelItem(XgsmiToolTiers.ENCHANTED_ROMEUM, new Item.Properties().fireResistant().attributes(ShovelItem.createAttributes(XgsmiToolTiers.ENCHANTED_ROMEUM, 1.5F, -3.0F))));
    public static final DeferredItem<Item> ENCHANTED_ROMEUM_HOE = ITEMS.register("enchanted_romeum_hoe", () -> new HoeItem(XgsmiToolTiers.ENCHANTED_ROMEUM, new Item.Properties().fireResistant().attributes(HoeItem.createAttributes(XgsmiToolTiers.ENCHANTED_ROMEUM, -4.0F, 0.0F))));

    public static final DeferredItem<Item> BLANK_BASIC_ARMOR_TEMPLATE = ITEMS.registerSimpleItem("blank_basic_armor_template");
    public static final DeferredItem<Item> BASIC_ARMOR_TEMPLATE = ITEMS.registerSimpleItem("basic_armor_template");
    public static final DeferredItem<Item> BASIC_ARMOR_TEMPLATE_1 = ITEMS.registerSimpleItem("basic_armor_template_1");
    public static final DeferredItem<Item> BASIC_ARMOR_TEMPLATE_2 = ITEMS.registerSimpleItem("basic_armor_template_2");
    public static final DeferredItem<Item> BASIC_ARMOR_TEMPLATE_3 = ITEMS.registerSimpleItem("basic_armor_template_3");
    public static final DeferredItem<Item> BASIC_ARMOR_TEMPLATE_4 = ITEMS.registerSimpleItem("basic_armor_template_4");
    public static final DeferredItem<Item> BASIC_ARMOR_TEMPLATE_5 = ITEMS.registerSimpleItem("basic_armor_template_5");
    public static final DeferredItem<Item> BASIC_ARMOR_TEMPLATE_6 = ITEMS.registerSimpleItem("basic_armor_template_6");
    public static final DeferredItem<Item> BASIC_ARMOR_TEMPLATE_7 = ITEMS.registerSimpleItem("basic_armor_template_7");
    public static final DeferredItem<Item> BASIC_ARMOR_TEMPLATE_8 = ITEMS.registerSimpleItem("basic_armor_template_8");

    public static final DeferredItem<Item> BLANK_UPGRADE_SMITHING_TEMPLATE = ITEMS.registerSimpleItem("blank_upgrade_smithing_template", new Item.Properties().fireResistant());

    public static final DeferredItem<Item> TITANIUM_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("titanium_upgrade_smithing_template", XgsmiSmithingTemplateItem::createTitaniumUpgradeTemplate);
    public static final DeferredItem<Item> TITANIUM_ENCHANT_SMITHING_TEMPLATE = ITEMS.register("titanium_enchant_smithing_template", XgsmiSmithingTemplateItem::createTitaniumEnchantTemplate);
    public static final DeferredItem<Item> ROMEUM_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("romeum_upgrade_smithing_template", XgsmiSmithingTemplateItem::createRomeumUpgradeTemplate);
    public static final DeferredItem<Item> ROMEUM_ENCHANT_SMITHING_TEMPLATE = ITEMS.register("romeum_enchant_smithing_template", XgsmiSmithingTemplateItem::createRomeumEnchantTemplate);

    public static final DeferredItem<Item> BLANK_ARMOR_TEMPLATE = ITEMS.registerSimpleItem("blank_armor_template", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_1 = ITEMS.registerSimpleItem("armor_template_1", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_2 = ITEMS.registerSimpleItem("armor_template_2", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_3 = ITEMS.registerSimpleItem("armor_template_3", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_4 = ITEMS.registerSimpleItem("armor_template_4", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_5 = ITEMS.registerSimpleItem("armor_template_5", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_6 = ITEMS.registerSimpleItem("armor_template_6", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_7 = ITEMS.registerSimpleItem("armor_template_7", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_8 = ITEMS.registerSimpleItem("armor_template_8", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_9 = ITEMS.registerSimpleItem("armor_template_9", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_10 = ITEMS.registerSimpleItem("armor_template_10", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_11 = ITEMS.registerSimpleItem("armor_template_11", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_12 = ITEMS.registerSimpleItem("armor_template_12", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_13 = ITEMS.registerSimpleItem("armor_template_13", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_14 = ITEMS.registerSimpleItem("armor_template_14", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_15 = ITEMS.registerSimpleItem("armor_template_15", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_16 = ITEMS.registerSimpleItem("armor_template_16", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_17 = ITEMS.registerSimpleItem("armor_template_17", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_18 = ITEMS.registerSimpleItem("armor_template_18", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_19 = ITEMS.registerSimpleItem("armor_template_19", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_20 = ITEMS.registerSimpleItem("armor_template_20", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_21 = ITEMS.registerSimpleItem("armor_template_21", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_22 = ITEMS.registerSimpleItem("armor_template_22", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_23 = ITEMS.registerSimpleItem("armor_template_23", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_24 = ITEMS.registerSimpleItem("armor_template_24", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_25 = ITEMS.registerSimpleItem("armor_template_25", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ARMOR_TEMPLATE_26 = ITEMS.registerSimpleItem("armor_template_26", new Item.Properties().fireResistant());
}
