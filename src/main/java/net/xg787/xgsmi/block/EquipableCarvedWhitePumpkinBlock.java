package net.xg787.xgsmi.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.level.block.EquipableCarvedPumpkinBlock;

public class EquipableCarvedWhitePumpkinBlock extends CarvedWhitePumpkinBlock  implements Equipable {
    public static final MapCodec<EquipableCarvedPumpkinBlock> CODEC = simpleCodec(EquipableCarvedPumpkinBlock::new);

    @Override
    public MapCodec<EquipableCarvedPumpkinBlock> codec() {
        return CODEC;
    }

    public EquipableCarvedWhitePumpkinBlock(Properties properties) {
        super(properties);
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}
