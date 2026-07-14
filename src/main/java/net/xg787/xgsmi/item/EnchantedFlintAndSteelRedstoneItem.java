package net.xg787.xgsmi.item;

import net.minecraft.world.level.block.Block;
import net.xg787.xgsmi.registry.StoryModeRebornBlocks;

public class EnchantedFlintAndSteelRedstoneItem extends AbstractEnchantedFlintAndSteelItem {
    public EnchantedFlintAndSteelRedstoneItem(Properties properties) {
        super(properties);
    }

    @Override
    public Block getFireBlock() {
        return StoryModeRebornBlocks.ENCHANTED_FIRE_REDSTONE.get();
    }
}
