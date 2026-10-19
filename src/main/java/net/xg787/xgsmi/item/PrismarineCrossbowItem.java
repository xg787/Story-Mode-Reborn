package net.xg787.xgsmi.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.xg787.xgsmi.registry.StoryModeRebornItems;

public class PrismarineCrossbowItem extends CrossbowItem {
    public PrismarineCrossbowItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getDefaultCreativeAmmo(Player player, ItemStack projectileWeaponItem) {
        return StoryModeRebornItems.PRISMARINE_ARROW.get().getDefaultInstance();
    }
}
