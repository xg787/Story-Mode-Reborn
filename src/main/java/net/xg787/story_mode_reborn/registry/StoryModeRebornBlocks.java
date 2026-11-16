package net.xg787.story_mode_reborn.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.valueproviders.UniformInt;
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
import net.xg787.story_mode_reborn.block.*;
import net.xg787.story_mode_reborn.item.RedstoneHeartItem;

import java.util.function.Supplier;

import static net.xg787.story_mode_reborn.StoryModeReborn.MOD_ID;
import static net.xg787.story_mode_reborn.block.BlockReferences.*;
import static net.xg787.story_mode_reborn.registry.StoryModeRebornItems.WHITE_PUMPKIN_SEEDS;

public class StoryModeRebornBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);

    public static final DeferredBlock<Block> SAND_PRISMARINE_ORE = register("sand_prismarine_ore", () -> new ColoredFallingDropExperienceBlock(UniformInt.of(2, 5), new ColorRGBA(14406560), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> PRISMARINE_ORE = register("prismarine_ore", () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)));
    public static final DeferredBlock<Block> DEEPSLATE_PRISMARINE_ORE = register("deepslate_prismarine_ore", () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    public static final DeferredBlock<WallBlock> PRISMARINE_BRICK_WALL = register("prismarine_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS).forceSolidOn()));

    public static final DeferredBlock<Block> SMOOTH_PRISMARINE = register("smooth_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<StairBlock> SMOOTH_PRISMARINE_STAIRS = registerStairs("smooth_prismarine_stairs", SMOOTH_PRISMARINE);
    public static final DeferredBlock<SlabBlock> SMOOTH_PRISMARINE_SLAB = registerSlab("smooth_prismarine_slab", SMOOTH_PRISMARINE);
    public static final DeferredBlock<WallBlock> SMOOTH_PRISMARINE_WALL = register("smooth_prismarine_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS).forceSolidOn()));

    public static final DeferredBlock<Block> CHISELED_SMOOTH_PRISMARINE = register("chiseled_smooth_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<Block> CARVED_PRISMARINE = register("carved_prismarine", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<Block> CARVED_PRISMARINE_ARROW = register("carved_prismarine_arrow", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<Block> CARVED_PRISMARINE_WAVE = register("carved_prismarine_wave", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<Block> PRISMARINE_KEY = register("prismarine_key", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<Block> PRISMARINE_RUNE_BLANK = register("prismarine_rune_blank", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<Block> PRISMARINE_RUNE_A = register("prismarine_rune_a", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<Block> PRISMARINE_RUNE_B = register("prismarine_rune_b", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<Block> PRISMARINE_RUNE_C = register("prismarine_rune_c", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<Block> PRISMARINE_RUNE_D = register("prismarine_rune_d", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<Block> PRISMARINE_RUNE_E = register("prismarine_rune_e", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<Block> PRISMARINE_RUNE_F = register("prismarine_rune_f", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<Block> PRISMARINE_RUNE_G = register("prismarine_rune_g", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final DeferredBlock<Block> PRISMARINE_RUNE_H = register("prismarine_rune_h", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));

    public static final DeferredBlock<WallBlock> DARK_PRISMARINE_WALL = register("dark_prismarine_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE).forceSolidOn()));

    public static final DeferredBlock<Block> SMOOTH_DARK_PRISMARINE = register("smooth_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<StairBlock> SMOOTH_DARK_PRISMARINE_STAIRS = registerStairs("smooth_dark_prismarine_stairs", SMOOTH_DARK_PRISMARINE);
    public static final DeferredBlock<SlabBlock> SMOOTH_DARK_PRISMARINE_SLAB = registerSlab("smooth_dark_prismarine_slab", SMOOTH_DARK_PRISMARINE);
    public static final DeferredBlock<WallBlock> SMOOTH_DARK_PRISMARINE_WALL = register("smooth_dark_prismarine_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE).forceSolidOn()));

    public static final DeferredBlock<Block> CHISELED_SMOOTH_DARK_PRISMARINE = register("chiseled_smooth_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> CARVED_DARK_PRISMARINE = register("carved_dark_prismarine", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> CARVED_DARK_PRISMARINE_ARROW = register("carved_dark_prismarine_arrow", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> CARVED_DARK_PRISMARINE_CORNER = register("carved_dark_prismarine_corner", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> CARVED_DARK_PRISMARINE_CORNER_LINE = register("carved_dark_prismarine_corner_line", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> CARVED_DARK_PRISMARINE_SPIRAL = register("carved_dark_prismarine_spiral", () -> new RotatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));

    public static final DeferredBlock<Block> DEEPSLATE_TITANIUM_ORE = register("deepslate_titanium_ore", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DEEPSLATE).strength(5f, 3f).requiresCorrectToolForDrops().mapColor(MapColor.COLOR_BLUE)));
    public static final DeferredBlock<Block> TITANIUM_BLOCK = register("titanium_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.COLOR_BLUE)));
    public static final DeferredBlock<Block> NETHER_ROMEUM_ORE = registerProperties("nether_romeum_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.NETHER_GOLD_ORE).mapColor(MapColor.COLOR_RED).mapColor(MapColor.COLOR_RED)), new Item.Properties().fireResistant());
    public static final DeferredBlock<Block> ROMEUM_BLOCK = registerProperties("romeum_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.COLOR_RED)), new Item.Properties().fireResistant());

    public static final DeferredBlock<Block> WHITE_PUMPKIN = register("white_pumpkin", () -> new WhitePumpkinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instrument(NoteBlockInstrument.DIDGERIDOO).strength(1.0F).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CARVED_WHITE_PUMPKIN = register("carved_white_pumpkin", () -> new EquipableCarvedWhitePumpkinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(1.0F).sound(SoundType.WOOD).isValidSpawn(Blocks::always).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> WHITE_JACK_O_LANTERN = register("white_jack_o_lantern", () -> new CarvedWhitePumpkinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(1.0F).sound(SoundType.WOOD).lightLevel(state -> 15).isValidSpawn(Blocks::always).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> ATTACHED_WHITE_PUMPKIN_STEM = BLOCKS.register("attached_white_pumpkin_stem", () -> new AttachedStemBlock(WHITE_PUMPKIN_STEM_REF, WHITE_PUMPKIN_REF, WHITE_PUMPKIN_SEEDS.getKey(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> WHITE_PUMPKIN_STEM = BLOCKS.register("white_pumpkin_stem", () -> new StemBlock(WHITE_PUMPKIN_REF, ATTACHED_WHITE_PUMPKIN_STEM_REF, WHITE_PUMPKIN_SEEDS.getKey(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().randomTicks().instabreak().sound(SoundType.HARD_CROP).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> ENCHANTED_FIRE_DIAMOND = BLOCKS.register("enchanted_fire_diamond", () -> new EnchantedFireDiamondBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).noCollission().strength(-1.0F, 3600000.0F).lightLevel(state -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_DIAMOND_EXTENSION = BLOCKS.register("enchanted_fire_diamond_extension", () -> new EnchantedFireDiamondExtensionBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).noCollission().strength(-1.0F, 3600000.0F).lightLevel(state -> 15).sound(SoundType.EMPTY).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_EMERALD = BLOCKS.register("enchanted_fire_emerald", () -> new EnchantedFireEmeraldBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).noCollission().strength(-1.0F, 3600000.0F).lightLevel(state -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_EMERALD_EXTENSION = BLOCKS.register("enchanted_fire_emerald_extension", () -> new EnchantedFireEmeraldExtensionBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).noCollission().strength(-1.0F, 3600000.0F).lightLevel(state -> 15).sound(SoundType.EMPTY).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_GOLD = BLOCKS.register("enchanted_fire_gold", () -> new EnchantedFireGoldBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).noCollission().strength(-1.0F, 3600000.0F).lightLevel(state -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_GOLD_EXTENSION = BLOCKS.register("enchanted_fire_gold_extension", () -> new EnchantedFireGoldExtensionBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).noCollission().strength(-1.0F, 3600000.0F).lightLevel(state -> 15).sound(SoundType.EMPTY).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_REDSTONE = BLOCKS.register("enchanted_fire_redstone", () -> new EnchantedFireRedstoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().strength(-1.0F, 3600000.0F).lightLevel(state -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).noLootTable()));
    public static final DeferredBlock<Block> ENCHANTED_FIRE_REDSTONE_EXTENSION = BLOCKS.register("enchanted_fire_redstone_extension", () -> new EnchantedFireRedstoneExtensionBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().strength(-1.0F, 3600000.0F).lightLevel(state -> 15).sound(SoundType.EMPTY).pushReaction(PushReaction.DESTROY).noLootTable()));

    public static final DeferredBlock<Block> REDSTONE_HEART =  BLOCKS.register("redstone_heart", () -> new RedstoneHeartBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_RED)
            .strength(5.0F, 6.0F)
            .sound(SoundType.METAL)
            .noOcclusion()
            .forceSolidOn()
            .lightLevel(state -> 10)
            .isRedstoneConductor(StoryModeRebornBlocks::never)));

    private static DeferredBlock<StairBlock> registerStairs(String name, Supplier<Block> block) {
        return register(name, () -> new StairBlock(block.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(block.get())));
    }

    private static DeferredBlock<SlabBlock> registerSlab(String name, Supplier<Block> block) {
        return register(name, () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(block.get())));
    }

    public static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block){
        DeferredBlock<T> blockItem = BLOCKS.register(name, block);
        StoryModeRebornItems.ITEMS.register(name, () -> new BlockItem(blockItem.get(), new Item.Properties()));
        return blockItem;
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
