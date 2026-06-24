package net.xg787.xgsmi.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.xg787.xgsmi.entity.projectile.PrismarineArrow;

import java.util.function.Supplier;

import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;

public class StoryModeRebornEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, MOD_ID);

    public static final Supplier<EntityType<PrismarineArrow>> PRISMARINE_ARROW = ENTITY_TYPES.register(
            "prismarine_arrow", () -> EntityType.Builder.<PrismarineArrow>of(PrismarineArrow::new, MobCategory.MISC).sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20).build("prismarine_arrow")
    );
}
