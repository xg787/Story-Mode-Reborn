package net.xg787.xgsmi.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

import static net.xg787.xgsmi.registry.StoryModeRebornSounds.*;

public class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {

    protected ModSoundDefinitionsProvider(PackOutput output, String modId, ExistingFileHelper helper) {
        super(output, modId, helper);
    }

    @Override
    public void registerSounds() {
        add(ENCHANTED_FLINT_AND_STEEL_USE.get(), SoundDefinition.definition().with(sound(ENCHANTED_FLINT_AND_STEEL_USE.get().getLocation())).subtitle("subtitle.story_mode_reborn.enchanted_flint_and_steel_use"));
        add(ENCHANTED_FLINT_AND_STEEL_PLACE_FIRE.get(), SoundDefinition.definition().with(sound(ENCHANTED_FLINT_AND_STEEL_PLACE_FIRE.get().getLocation())).subtitle("subtitle.story_mode_reborn.enchanted_flint_and_steel_place_fire"));
    }
}
