package net.xg787.xgsmi.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;
import static net.xg787.xgsmi.registry.StoryModeRebornSounds.*;

public class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {

    protected ModSoundDefinitionsProvider(PackOutput output, String modId, ExistingFileHelper helper) {
        super(output, modId, helper);
    }

    @Override
    public void registerSounds() {
        add(ENCHANTED_FLINT_AND_STEEL_USE.get(), SoundDefinition.definition().with(sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "enchanted_flint_and_steel_use"))).subtitle("subtitle.story_mode_reborn.item.enchanted_flint_and_steel.use"));
        add(ENCHANTED_FLINT_AND_STEEL_PLACE_FIRE.get(), SoundDefinition.definition().with(sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "enchanted_flint_and_steel_place_fire"))).subtitle("subtitle.story_mode_reborn.item.enchanted_flint_and_steel.place_fire"));
    }
}
