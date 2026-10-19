package net.xg787.xgsmi.registry.compat;

import com.blackgear.vanillabackport.common.level.items.spear.SpearItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.xg787.xgsmi.item.StoryModeRebornToolTiers;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;

public class StoryModeRebornVBItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final DeferredItem<Item> PRISMARINE_SPEAR = ITEMS.register("prismarine_spear", () -> new SpearItem(StoryModeRebornToolTiers.PRISMARINE, 0.95F, 0.95F, 0.6F, 2.5F, 8.0F, 6.75F, 5.1F, 11.25F, 4.6F, new Item.Properties()));

    public static final DeferredItem<Item> ROYAL_SPEAR = ITEMS.register("royal_spear", () -> new SpearItem(StoryModeRebornToolTiers.ROYAL, 1.05F, 1.075F, 0.5F, 3.0F, 7.5F, 6.5F, 5.1F, 10.0F, 4.6F, new Item.Properties()));
}
