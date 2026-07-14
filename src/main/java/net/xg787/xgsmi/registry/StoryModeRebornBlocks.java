package net.xg787.xgsmi.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.xg787.xgsmi.block.*;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.ANCIENT_DEBRIS;
import static net.minecraft.world.level.block.Blocks.NETHERITE_BLOCK;
import static net.xg787.xgsmi.StoryModeReborn.MOD_ID;
import static net.xg787.xgsmi.block.BlockReferences.*;
import static net.xg787.xgsmi.registry.StoryModeRebornItems.WHITE_PUMPKIN_SEEDS;

public class StoryModeRebornBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);

    public static final DeferredBlock<Block> DEEPSLATE_TITANIUM_ORE = register("deepslate_titanium_ore", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DEEPSLATE).strength(5f, 3f).requiresCorrectToolForDrops().mapColor(MapColor.COLOR_BLUE)));
    public static final DeferredBlock<Block> TITANIUM_BLOCK = register("titanium_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(NETHERITE_BLOCK).mapColor(MapColor.COLOR_BLUE)));
    public static final DeferredBlock<Block> NETHER_ROMEUM_ORE = registerProperties("nether_romeum_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(ANCIENT_DEBRIS).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.NETHER_GOLD_ORE).mapColor(MapColor.COLOR_RED).mapColor(MapColor.COLOR_RED)), new Item.Properties().fireResistant());
    public static final DeferredBlock<Block> ROMEUM_BLOCK = registerProperties("romeum_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(NETHERITE_BLOCK).mapColor(MapColor.COLOR_RED)), new Item.Properties().fireResistant());

    public static final DeferredBlock<Block> WHITE_PUMPKIN = register("white_pumpkin", () -> new WhitePumpkinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instrument(NoteBlockInstrument.DIDGERIDOO).strength(1.0F).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CARVED_WHITE_PUMPKIN = register("carved_white_pumpkin", () -> new EquipableCarvedWhitePumpkinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(1.0F).sound(SoundType.WOOD).isValidSpawn(Blocks::always).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> WHITE_JACK_O_LANTERN = register("white_jack_o_lantern", () -> new CarvedWhitePumpkinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(1.0F).sound(SoundType.WOOD).lightLevel(state -> 15).isValidSpawn(Blocks::always).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> ATTACHED_WHITE_PUMPKIN_STEM = BLOCKS.register("attached_white_pumpkin_stem", () -> new AttachedStemBlock(WHITE_PUMPKIN_STEM_REF, WHITE_PUMPKIN_REF, WHITE_PUMPKIN_SEEDS.getKey(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> WHITE_PUMPKIN_STEM = BLOCKS.register("white_pumpkin_stem", () -> new StemBlock(WHITE_PUMPKIN_REF, ATTACHED_WHITE_PUMPKIN_STEM_REF, WHITE_PUMPKIN_SEEDS.getKey(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().randomTicks().instabreak().sound(SoundType.HARD_CROP).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> ENCHANTED_FIRE_DIAMOND = BLOCKS.register("enchanted_fire_diamond", () -> new EnchantedFireDiamondBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).noCollission().instabreak().lightLevel(state -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_DIAMOND_EXTENSION = BLOCKS.register("enchanted_fire_diamond_extension", () -> new EnchantedFireDiamondExtensionBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).noCollission().strength(-1.0F, 3600000.0F).lightLevel(state -> 15).sound(SoundType.EMPTY).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_EMERALD = BLOCKS.register("enchanted_fire_emerald", () -> new EnchantedFireEmeraldBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).noCollission().instabreak().lightLevel(state -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_EMERALD_EXTENSION = BLOCKS.register("enchanted_fire_emerald_extension", () -> new EnchantedFireEmeraldExtensionBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).noCollission().strength(-1.0F, 3600000.0F).lightLevel(state -> 15).sound(SoundType.EMPTY).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_GOLD = BLOCKS.register("enchanted_fire_gold", () -> new EnchantedFireGoldBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).noCollission().instabreak().lightLevel(state -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_GOLD_EXTENSION = BLOCKS.register("enchanted_fire_gold_extension", () -> new EnchantedFireGoldExtensionBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).noCollission().strength(-1.0F, 3600000.0F).lightLevel(state -> 15).sound(SoundType.EMPTY).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_REDSTONE = BLOCKS.register("enchanted_fire_redstone", () -> new EnchantedFireRedstoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().instabreak().lightLevel(state -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_REDSTONE_EXTENSION = BLOCKS.register("enchanted_fire_redstone_extension", () -> new EnchantedFireRedstoneExtensionBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().strength(-1.0F, 3600000.0F).lightLevel(state -> 15).sound(SoundType.EMPTY).pushReaction(PushReaction.DESTROY).noLootTable()));

    private static DeferredBlock<StairBlock> registerStairs(String name, Supplier<Block> block) {
        return register(name, () -> new StairBlock(block.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(block.get())));
    }

    private static DeferredBlock<SlabBlock> registerSlab(String name, Supplier<Block> block) {
        return register(name, () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(block.get())));
    }

    public static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block){
        DeferredBlock<T> blockItem = BLOCKS.register(name, block);
        registerBlockItem(name, blockItem);
        return blockItem;
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        StoryModeRebornItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static <T extends Block> DeferredBlock<T> registerProperties(String name, Supplier<T> block, Item.Properties properties){
        DeferredBlock<T> blockItem = BLOCKS.register(name, block);
        registerBlockItemProperties(name, blockItem, properties);
        return blockItem;
    }

    public static <T extends Block> void registerBlockItemProperties(String name, DeferredBlock<T> block, Item.Properties properties){
        StoryModeRebornItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }
}
