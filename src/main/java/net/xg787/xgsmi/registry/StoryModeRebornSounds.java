package net.xg787.xgsmi.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;

public class StoryModeRebornSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, MOD_ID);

    public static final Supplier<SoundEvent> ENCHANTED_FLINT_AND_STEEL_USE = registerSoundEvent("enchanted_flint_and_steel_use");
    public static final Supplier<SoundEvent> ENCHANTED_FLINT_AND_STEEL_PLACE_FIRE = registerSoundEvent("enchanted_flint_and_steel_place_fire");


    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    private static Supplier<SoundEvent> registerFixedSoundEvent(String name, int range) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createFixedRangeEvent(id, range));
    }
}
