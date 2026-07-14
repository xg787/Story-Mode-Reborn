package net.xg787.xgsmi.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.level.block.EquipableCarvedPumpkinBlock;

public class EquipableCarvedWhitePumpkinBlock extends CarvedWhitePumpkinBlock  implements Equipable {
    public static final MapCodec<EquipableCarvedWhitePumpkinBlock> CODEC = simpleCodec(EquipableCarvedWhitePumpkinBlock::new);

    public EquipableCarvedWhitePumpkinBlock(Properties properties) {
        super(properties);
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }

    @Override
    public MapCodec<EquipableCarvedWhitePumpkinBlock> codec() {
        return CODEC;
    }
}
