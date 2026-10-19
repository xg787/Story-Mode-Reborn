package net.xg787.xgsmi.client.compat.VanillaBackport;

import com.blackgear.platform.client.GameRendering;
import com.blackgear.platform.client.v2.render.ItemRendererRegistry;
import com.blackgear.platform.common.v2.creative_tabs.CreativeTabIntegrations;
import com.blackgear.platform.common.v2.creative_tabs.VanillaTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.xg787.xgsmi.StoryModeRebornConfig;
import net.xg787.xgsmi.client.compat.VanillaBackport.renderer.item.StoryModeRebornSpearRenderer;

import static net.xg787.xgsmi.registry.compat.StoryModeRebornVBItems.*;
import static com.blackgear.vanillabackport.common.registries.items.ModItems.*;
import static net.xg787.xgsmi.client.compat.VanillaBackport.renderer.item.StoryModeRebornSpearRenderer.SM_SPEARS;

@OnlyIn(Dist.CLIENT)
public class StoryModeRebornVB {
    public static void VanillaBackport() {
        if (StoryModeRebornConfig.ADD_ITEMS_TO_VANILLA_TABS.get()){
            CreativeTabIntegrations.register(StoryModeRebornVB::addCreative);
        }
        GameRendering.registerSpecialModels(StoryModeRebornVB::registerSpearRenderer);
    }

    public static void addCreative(CreativeTabIntegrations.Event event) {
        event.register(VanillaTabs.COMBAT, (flags, output, operator) -> {
            output.before(Items.WOODEN_AXE).add(WOODEN_SPEAR.get(), STONE_SPEAR.get(), COPPER_SPEAR.get(), PRISMARINE_SPEAR.get(), IRON_SPEAR.get(), ROYAL_SPEAR.get(), GOLDEN_SPEAR.get(), DIAMOND_SPEAR.get(), NETHERITE_SPEAR.get());
        });
    }

    public static void registerSpearRenderer(GameRendering.SpecialModelEvent event) {
        for (ItemLike spear : SM_SPEARS) {
            (ItemRendererRegistry.INSTANCE.get()).register(spear, StoryModeRebornSpearRenderer.INSTANCE);
        }
    }
}
