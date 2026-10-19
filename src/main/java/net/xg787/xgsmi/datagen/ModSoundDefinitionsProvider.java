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
        add(BOW_PULLING.get(), SoundDefinition.definition().with(sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/bow/pulling"))).subtitle("subtitles.item.bow.pulling"));
        add(ENCHANTED_FLINT_AND_STEEL_USE.get(), SoundDefinition.definition().with(sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/enchanted_flint_and_steel/use"))).subtitle("subtitles.story_mode_reborn.item.enchanted_flint_and_steel.use"));
        add(ENCHANTED_FLINT_AND_STEEL_PLACE_FIRE.get(), SoundDefinition.definition().with(sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/enchanted_flint_and_steel/place_fire"))).subtitle("subtitles.story_mode_reborn.item.enchanted_flint_and_steel.place_fire"));

        add(CREEPER_AMBIENT.get(), SoundDefinition.definition().with(
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/say1")).volume(0.65),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/say2")).volume(0.65),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/say3")).volume(0.65),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/say4")).volume(0.65),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/say5")).volume(0.65),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/say6")).volume(0.65)).subtitle("subtitles.entity.creeper.ambient"));

        add(CREEPER_HISS.get(), SoundDefinition.definition().with(
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/hiss1")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/hiss2")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/hiss3")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/hiss4")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/hiss5")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/hiss6")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/hiss7"))).subtitle("subtitles.entity.creeper.hiss"));


        add(CHARGED_CREEPER_HISS.get(), SoundDefinition.definition().with(
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/chargedhiss1")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/chargedhiss2")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/chargedhiss3")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/chargedhiss4")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/chargedhiss5")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/chargedhiss6")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/chargedhiss7"))).subtitle("subtitles.entity.creeper.chargedhiss"));

        add(CREEPER_STEP.get(), SoundDefinition.definition().with(
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/step1")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/step2")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/step3")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/step4")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/step5")),
                sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/creeper/step6"))).subtitle("subtitles.block.generic.footsteps"));

        add(ENDERMAN_BIG_SCREAM.get(), SoundDefinition.definition().with(sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/endermen/bigscream"))).subtitle("subtitles.entity.enderman.scream"));

        add(ENDERMAN_APPEAR.get(), SoundDefinition.definition().with(sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/endermen/appear"))).subtitle("subtitles.entity.enderman.appear"));

        add(ENDERMAN_DISAPPEAR.get(), SoundDefinition.definition().with(sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/endermen/disappear"))).subtitle("subtitles.entity.enderman.disappear"));

        add(PLAYER_APPEAR.get(), SoundDefinition.definition().with(sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/endermen/appear"))).subtitle("subtitles.entity.player.appear"));

        add(PLAYER_DISAPPEAR.get(), SoundDefinition.definition().with(sound(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mob/endermen/disappear"))).subtitle("subtitles.entity.player.disappear"));
    }
}
