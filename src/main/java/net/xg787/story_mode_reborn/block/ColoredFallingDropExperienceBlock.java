package net.xg787.story_mode_reborn.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ColoredFallingDropExperienceBlock extends FallingBlock {
    public static final MapCodec<ColoredFallingDropExperienceBlock> CODEC = RecordCodecBuilder.mapCodec(
            coloredFallingDropExperienceBlockInstance -> coloredFallingDropExperienceBlockInstance.group(experienceCodec(), dustColorCodec(), propertiesCodec())
                    .apply(coloredFallingDropExperienceBlockInstance, ColoredFallingDropExperienceBlock::new)
    );

    protected final ColorRGBA dustColor;
    protected final IntProvider xpRange;

    public static RecordCodecBuilder<ColoredFallingDropExperienceBlock, IntProvider> experienceCodec() {
        return IntProvider.codec(0, 10).fieldOf("experience").forGetter(coloredFallingDropExperienceBlock -> coloredFallingDropExperienceBlock.xpRange);
    }

    public static RecordCodecBuilder<ColoredFallingDropExperienceBlock, ColorRGBA> dustColorCodec() {
        return ColorRGBA.CODEC.fieldOf("falling_dust_color").forGetter(coloredFallingDropExperienceBlock -> coloredFallingDropExperienceBlock.dustColor);
    }

    @Override
    public MapCodec<ColoredFallingDropExperienceBlock> codec() {
        return CODEC;
    }

    public ColoredFallingDropExperienceBlock(IntProvider xpRange, ColorRGBA dustColor, Properties properties) {
        super(properties);
        this.xpRange = xpRange;
        this.dustColor = dustColor;
    }

    public int getDustColor(BlockState state, BlockGetter level, BlockPos pos) {
        return this.dustColor.rgba();
    }
}
