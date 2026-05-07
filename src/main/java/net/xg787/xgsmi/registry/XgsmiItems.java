package net.xg787.xgsmi.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.xg787.xgsmi.item.XgsmiSmithingTemplateItem;

import static net.xg787.xgsmi.Xgsmi.MOD_ID;

public class XgsmiItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final DeferredItem<Item> ICON = ITEMS.registerSimpleItem("icon");

    public static final DeferredItem<Item> BLANK_UPGRADE_SMITHING_TEMPLATE = ITEMS.registerSimpleItem("blank_upgrade_smithing_template", new Item.Properties().fireResistant());

    public static final DeferredItem<Item> TITANIUM_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("titanium_upgrade_smithing_template", XgsmiSmithingTemplateItem::createTitaniumUpgradeTemplate);
    public static final DeferredItem<Item> ROMEUM_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("romeum_upgrade_smithing_template", XgsmiSmithingTemplateItem::createRomeumUpgradeTemplate);
}
