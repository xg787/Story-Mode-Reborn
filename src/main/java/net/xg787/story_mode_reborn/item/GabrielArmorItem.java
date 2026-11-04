package net.xg787.story_mode_reborn.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

import static net.xg787.story_mode_reborn.StoryModeReborn.MOD_ID;

public class GabrielArmorItem extends AbstractArmorItem {
    private static final ResourceLocation TEXTURE_LOCATION = makeCustomTextureLocation(MOD_ID, "gabriel_armor");
    private static final ResourceLocation ARM_TEXTURE_LOCATION = makeCustomTextureLocation(MOD_ID, "gabriel_armor_arm");
    public GabrielArmorItem(ArmorItem.Type pType, Item.Properties properties) {
        super(StoryModeRebornArmorMaterials.MCSM_TITANIUM, pType, properties);
    }

    @Override
    public ResourceLocation getTexture() {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getArmTexture() {
        return ARM_TEXTURE_LOCATION;
    }
}
