package net.xg787.xgsmi.client.model;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;


import static net.xg787.xgsmi.Xgsmi.MOD_ID;
import static net.xg787.xgsmi.registry.XgsmiItems.*;

public class ModelProperties {
    public static void onClientSetup(FMLClientSetupEvent event) {
        registerBowModelProperties(PRISMARINE_BOW.get());
        registerCrossBowModelProperties(PRISMARINE_CROSSBOW.get());
        registerFishingRodModelProperties(PRISMARINE_FISHING_ROD.get());
        if (ModList.get().isLoaded("witherstormmod")) {
            ItemProperties.register(PRISMARINE_CROSSBOW.get(), ResourceLocation.fromNamespaceAndPath("witherstormmod", "prismarine_arrow"), (stack, level, entity, i) -> {
                ChargedProjectiles chargedprojectiles = stack.get(DataComponents.CHARGED_PROJECTILES);
                return chargedprojectiles != null && chargedprojectiles.contains(Items.ENDER_PEARL) ? 1.0F : 0.0F;
            });
        }
        ItemProperties.register(Items.CROSSBOW, ResourceLocation.fromNamespaceAndPath(MOD_ID, "prismarine_arrow"), (stack, level, entity, i) -> {
            ChargedProjectiles chargedprojectiles = stack.get(DataComponents.CHARGED_PROJECTILES);
            return chargedprojectiles != null && (chargedprojectiles.contains(PRISMARINE_ARROW.get()) || chargedprojectiles.contains(TIPPED_PRISMARINE_ARROW.get())) ? 1.0F : 0.0F;
        });
    }

    public static void registerFishingRodModelProperties(Item fishingRod) {
        ItemProperties.register(fishingRod, ResourceLocation.withDefaultNamespace("cast"), (stack, level, entity, i) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                boolean isMainhand = entity.getMainHandItem() == stack;
                boolean isOffHand = entity.getOffhandItem() == stack;
                if (entity.getMainHandItem().getItem() instanceof FishingRodItem) {
                    isOffHand = false;
                }
                return (isMainhand || isOffHand) && entity instanceof Player && ((Player) entity).fishing != null ? 1.0F : 0.0F;
            }
        });
    }

    public static void registerBowModelProperties(Item bow) {
        ItemProperties.register(bow, ResourceLocation.withDefaultNamespace("pull"), (stack, level, entity, i) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(bow, ResourceLocation.withDefaultNamespace("pulling"), (stack, level, entity, i) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);
    }

    public static void registerCrossBowModelProperties(Item crossBow) {
        ItemProperties.register(
                crossBow,
                ResourceLocation.withDefaultNamespace("pull"),
                (stack, level, entity, i) -> {
                    if (entity == null) {
                        return 0.0F;
                    } else {
                        return CrossbowItem.isCharged(stack)
                                ? 0.0F
                                : (float)(stack.getUseDuration(entity) - entity.getUseItemRemainingTicks())
                                / (float)CrossbowItem.getChargeDuration(stack, entity);
                    }
                }
        );
        ItemProperties.register(
                crossBow,
                ResourceLocation.withDefaultNamespace("pulling"),
                (stack, level, entity, i) -> entity != null
                        && entity.isUsingItem()
                        && entity.getUseItem() == stack
                        && !CrossbowItem.isCharged(stack)
                        ? 1.0F
                        : 0.0F
        );
        ItemProperties.register(
                crossBow,
                ResourceLocation.withDefaultNamespace("charged"),
                (stack, level, entity, i) -> CrossbowItem.isCharged(stack) ? 1.0F : 0.0F
        );
        ItemProperties.register(crossBow, ResourceLocation.withDefaultNamespace("firework"), (stack, level, entity, i) -> {
            ChargedProjectiles chargedprojectiles = stack.get(DataComponents.CHARGED_PROJECTILES);
            return chargedprojectiles != null && chargedprojectiles.contains(Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });
        ItemProperties.register(crossBow, ResourceLocation.fromNamespaceAndPath(MOD_ID, "firework"), (stack, level, entity, i) -> {
            ChargedProjectiles chargedprojectiles = stack.get(DataComponents.CHARGED_PROJECTILES);
            return chargedprojectiles != null && chargedprojectiles.contains(Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });
        ItemProperties.register(crossBow, ResourceLocation.fromNamespaceAndPath(MOD_ID, "prismarine_arrow"), (stack, level, entity, i) -> {
            ChargedProjectiles chargedprojectiles = stack.get(DataComponents.CHARGED_PROJECTILES);
            return chargedprojectiles != null && (chargedprojectiles.contains(PRISMARINE_ARROW.get()) || chargedprojectiles.contains(TIPPED_PRISMARINE_ARROW.get())) ? 1.0F : 0.0F;
        });
    }
}
