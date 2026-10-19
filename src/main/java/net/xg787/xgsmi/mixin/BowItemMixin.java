package net.xg787.xgsmi.mixin;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.xg787.xgsmi.StoryModeRebornConfig;
import net.xg787.xgsmi.registry.StoryModeRebornSounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BowItem.class)
public class BowItemMixin {
    @Inject(method = "use", at = @At(value = "TAIL"))
    private void use(Level level, Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        if (StoryModeRebornConfig.BOW_PULLING_SOUND.get()) {
            level.playSound(null, player.getOnPos(), StoryModeRebornSounds.BOW_PULLING.get(), SoundSource.PLAYERS, 0.3F, 1);
        }
    }
}
