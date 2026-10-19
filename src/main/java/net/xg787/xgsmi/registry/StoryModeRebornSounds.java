package net.xg787.xgsmi.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;

public class StoryModeRebornSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, MOD_ID);

    public static final Supplier<SoundEvent> BOW_PULLING = registerSoundEvent("item.bow.pulling");
    public static final Supplier<SoundEvent> ENCHANTED_FLINT_AND_STEEL_USE = registerSoundEvent("item.enchanted_flint_and_steel.use");
    public static final Supplier<SoundEvent> ENCHANTED_FLINT_AND_STEEL_PLACE_FIRE = registerSoundEvent("item.enchanted_flint_and_steel.place_fire");

    public static final Supplier<SoundEvent> CREEPER_AMBIENT = registerSoundEvent("entity.creeper.ambient");
    public static final Supplier<SoundEvent> CREEPER_HISS = registerSoundEvent("entity.creeper.hiss");
    public static final Supplier<SoundEvent> CHARGED_CREEPER_HISS = registerSoundEvent("entity.creeper.chargedhiss");
    public static final Supplier<SoundEvent> CREEPER_STEP = registerSoundEvent("entity.creeper.step");

    public static final Supplier<SoundEvent> ENDERMAN_BIG_SCREAM = registerSoundEvent("entity.enderman.bigscream");
    public static final Supplier<SoundEvent> ENDERMAN_APPEAR = registerSoundEvent("entity.enderman.appear");
    public static final Supplier<SoundEvent> ENDERMAN_DISAPPEAR = registerSoundEvent("entity.enderman.disappear");

    public static final Supplier<SoundEvent> PLAYER_APPEAR = registerSoundEvent("entity.player.appear");
    public static final Supplier<SoundEvent> PLAYER_DISAPPEAR = registerSoundEvent("entity.player.disappear");

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    private static Supplier<SoundEvent> registerFixedSoundEvent(String name, int range) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createFixedRangeEvent(id, range));
    }
}
