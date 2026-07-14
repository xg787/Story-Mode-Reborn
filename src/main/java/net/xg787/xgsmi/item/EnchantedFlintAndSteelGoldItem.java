package net.xg787.xgsmi.item;

import net.minecraft.world.level.block.Block;
import net.xg787.xgsmi.registry.StoryModeRebornBlocks;

public class EnchantedFlintAndSteelGoldItem extends AbstractEnchantedFlintAndSteelItem {
    public EnchantedFlintAndSteelGoldItem(Properties properties) {
        super(properties);
    }

    @Override
    public Block getFireBlock() {
        return StoryModeRebornBlocks.ENCHANTED_FIRE_GOLD.get();
    }
}
