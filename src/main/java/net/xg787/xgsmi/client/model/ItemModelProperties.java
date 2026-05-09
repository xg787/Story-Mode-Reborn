package net.xg787.xgsmi.client.model;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import static net.xg787.xgsmi.registry.XgsmiItems.PRISMARINE_BOW;
import static net.xg787.xgsmi.registry.XgsmiItems.PRISMARINE_FISHING_ROD;

public class ItemModelProperties {
    public static void onClientSetup(FMLClientSetupEvent event) {
        registerBowModelProperties(PRISMARINE_BOW.get());
        registerFishingRodModelProperties(PRISMARINE_FISHING_ROD.get());
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
}
