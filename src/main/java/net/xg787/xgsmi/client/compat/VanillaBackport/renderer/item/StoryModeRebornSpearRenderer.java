package net.xg787.xgsmi.client.compat.VanillaBackport.renderer.item;

import com.blackgear.platform.client.v2.render.ItemRendererRegistry;
import com.blackgear.platform.core.util.event.ResultHolder;
import com.google.common.collect.ImmutableSet;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;
import static net.xg787.xgsmi.registry.compat.StoryModeRebornVBItems.PRISMARINE_SPEAR;
import static net.xg787.xgsmi.registry.compat.StoryModeRebornVBItems.ROYAL_SPEAR;

@OnlyIn(Dist.CLIENT)
public class StoryModeRebornSpearRenderer implements ItemRendererRegistry.Renderer {
    public static final StoryModeRebornSpearRenderer INSTANCE = new StoryModeRebornSpearRenderer();
    public static final Set<ItemLike> SM_SPEARS;
    private static final Map<ItemLike, ModelResourceLocation> SPEAR_MODELS;
    private static Map<ItemLike, ModelResourceLocation> buildModels() {
        Map<ItemLike, ModelResourceLocation> models = new HashMap(SM_SPEARS.size());

        for(ItemLike item : SM_SPEARS) {
            models.put(item, create(item.asItem()));
        }

        return models;
    }

    private static ModelResourceLocation create(Item item) {
        return new ModelResourceLocation(ResourceLocation.fromNamespaceAndPath(MOD_ID, BuiltInRegistries.ITEM.getKey(item).getPath() + "_in_hand"), "inventory");
    }

    public ResultHolder<BakedModel> renderFirstPerson(ItemStack stack, ItemDisplayContext context, ItemModelShaper shaper) {
        return context != ItemDisplayContext.GUI && context != ItemDisplayContext.FIXED && context != ItemDisplayContext.GROUND ? ResultHolder.submit(shaper.getModelManager().getModel(SPEAR_MODELS.get(stack.getItem()))) : ResultHolder.pass();
    }

    public ResultHolder<BakedModel> renderThirdPerson(ItemStack stack, ItemModelShaper shaper) {
        return ResultHolder.pass();
    }

    public Set<ModelResourceLocation> registerModels() {
        return ImmutableSet.copyOf(SPEAR_MODELS.values());
    }

    static {
        SM_SPEARS = Set.of(PRISMARINE_SPEAR.get(), ROYAL_SPEAR.get());
        SPEAR_MODELS = buildModels();
    }
}
