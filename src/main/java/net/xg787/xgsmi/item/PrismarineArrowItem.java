package net.xg787.xgsmi.item;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.xg787.xgsmi.entity.projectile.PrismarineArrow;

import javax.annotation.Nullable;
import java.util.List;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;

public class PrismarineArrowItem extends ArrowItem {
    public PrismarineArrowItem(Properties properties) {
        super(properties);
    }

    public AbstractArrow createArrow(Level level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon) {
        return new PrismarineArrow(level, shooter, ammo.copyWithCount(1), weapon);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable(Util.makeDescriptionId("tooltip", ResourceLocation.fromNamespaceAndPath(MOD_ID, "prismarine_arrow"))).withStyle(ChatFormatting.GRAY));
    }

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        PrismarineArrow arrow = new PrismarineArrow(level, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1), null);
        arrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return arrow;
    }
}
