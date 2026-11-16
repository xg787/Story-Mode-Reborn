package net.xg787.story_mode_reborn.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.xg787.story_mode_reborn.registry.StoryModeRebornBlocks;

import java.util.Set;

import static net.xg787.story_mode_reborn.registry.StoryModeRebornBlocks.*;
import static net.xg787.story_mode_reborn.registry.StoryModeRebornItems.*;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(WHITE_PUMPKIN.get());
        dropSelf(CARVED_WHITE_PUMPKIN.get());
        dropSelf(WHITE_JACK_O_LANTERN.get());
        add(ATTACHED_WHITE_PUMPKIN_STEM.get(), block -> createAttachedStemDrops(ATTACHED_WHITE_PUMPKIN_STEM.get(), WHITE_PUMPKIN_SEEDS.get()));
        add(WHITE_PUMPKIN_STEM.get(), block -> createStemDrops(WHITE_PUMPKIN_STEM.get(), WHITE_PUMPKIN_SEEDS.get()));
        add(SAND_PRISMARINE_ORE.get(), this::createPrismarineOreDrops);
        add(PRISMARINE_ORE.get(), this::createPrismarineOreDrops);
        add(DEEPSLATE_PRISMARINE_ORE.get(), this::createPrismarineOreDrops);
        dropSelf(PRISMARINE_BRICK_WALL.get());
        dropSelf(SMOOTH_PRISMARINE.get());
        dropSelf(SMOOTH_PRISMARINE_STAIRS.get());
        dropSelf(SMOOTH_PRISMARINE_SLAB.get());
        dropSelf(SMOOTH_PRISMARINE_WALL.get());
        dropSelf(CHISELED_SMOOTH_PRISMARINE.get());
        dropSelf(CARVED_PRISMARINE.get());
        dropSelf(CARVED_PRISMARINE_ARROW.get());
        dropSelf(CARVED_PRISMARINE_WAVE.get());
        dropSelf(PRISMARINE_KEY.get());
        dropSelf(PRISMARINE_RUNE_BLANK.get());
        dropSelf(PRISMARINE_RUNE_A.get());
        dropSelf(PRISMARINE_RUNE_B.get());
        dropSelf(PRISMARINE_RUNE_C.get());
        dropSelf(PRISMARINE_RUNE_D.get());
        dropSelf(PRISMARINE_RUNE_E.get());
        dropSelf(PRISMARINE_RUNE_F.get());
        dropSelf(PRISMARINE_RUNE_G.get());
        dropSelf(PRISMARINE_RUNE_H.get());
        dropSelf(DARK_PRISMARINE_WALL.get());
        dropSelf(SMOOTH_DARK_PRISMARINE.get());
        dropSelf(SMOOTH_DARK_PRISMARINE_STAIRS.get());
        dropSelf(SMOOTH_DARK_PRISMARINE_SLAB.get());
        dropSelf(SMOOTH_DARK_PRISMARINE_WALL.get());
        dropSelf(CHISELED_SMOOTH_DARK_PRISMARINE.get());
        dropSelf(CARVED_DARK_PRISMARINE.get());
        dropSelf(CARVED_DARK_PRISMARINE_ARROW.get());
        dropSelf(CARVED_DARK_PRISMARINE_CORNER.get());
        dropSelf(CARVED_DARK_PRISMARINE_CORNER_LINE.get());
        dropSelf(CARVED_DARK_PRISMARINE_SPIRAL.get());
        add(DEEPSLATE_TITANIUM_ORE.get(), block -> createOreDrop(DEEPSLATE_TITANIUM_ORE.get(), RAW_TITANIUM.get()));
        add(NETHER_ROMEUM_ORE.get(), block -> createOreDrop(NETHER_ROMEUM_ORE.get(), RAW_ROMEUM.get()));
        dropSelf(TITANIUM_BLOCK.get());
        dropSelf(ROMEUM_BLOCK.get());
        dropSelf(REDSTONE_HEART.get());
    }

    protected LootTable.Builder createPrismarineOreDrops(Block block) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(Items.PRISMARINE_SHARD)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 9.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return StoryModeRebornBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
