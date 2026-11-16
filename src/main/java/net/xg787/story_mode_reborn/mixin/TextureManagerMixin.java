package net.xg787.story_mode_reborn.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import net.xg787.story_mode_reborn.StoryModeReborn;
import net.xg787.story_mode_reborn.client.texture.AnimatableTexture;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 Credit to the AzureLib team for the original TextureManagerMixin class
 <a href="https://github.com/AzureDoom/AzureLib">...</a>
 **/
@Mixin(value = TextureManager.class, priority = 2020)
public abstract class TextureManagerMixin {

    @Unique
    private final Map<ResourceLocation, Boolean> story_Mode_Reborn$animationCache = new HashMap<>();

    @Shadow
    public abstract void register(ResourceLocation resourceLocation, AbstractTexture abstractTexture);

    @Shadow
    protected abstract AbstractTexture loadTexture(ResourceLocation path, AbstractTexture texture);

    @Inject(
        method = "getTexture(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/texture/AbstractTexture;",
        at = @At("RETURN"),
        cancellable = true,
        require = 1
    )
    private void story_Mode_Reborn$replaceAnimatableTexture(
        ResourceLocation location,
        CallbackInfoReturnable<AbstractTexture> cir
    ) {
        var currentTexture = cir.getReturnValue();

        if (currentTexture == null || currentTexture.getClass() != SimpleTexture.class) {
            return;
        }

        var cached = story_Mode_Reborn$animationCache.get(location);
        if (cached != null && !cached) {
            return;
        }

        if (!story_Mode_Reborn$hasAnimationMetadata(location)) {
            story_Mode_Reborn$animationCache.put(location, false);
            return;
        }

        var animatableTexture = new AnimatableTexture(location);

        try {
            loadTexture(location, animatableTexture);
        } catch (Exception e) {
            StoryModeReborn.LOGGER.error("Failed to load texture {}", location);
            story_Mode_Reborn$animationCache.put(location, false);
            return;
        }

        if (!animatableTexture.isAnimated()) {
            story_Mode_Reborn$animationCache.put(location, false);
            return;
        }

        story_Mode_Reborn$animationCache.put(location, true);

        this.register(location, animatableTexture);
        cir.setReturnValue(animatableTexture);
    }

    @Inject(method = "reload", at = @At("HEAD"))
    private void story_Mode_Reborn$clearAnimationCache(CallbackInfoReturnable<CompletableFuture<Void>> cir) {
        RenderSystem.recordRenderCall(story_Mode_Reborn$animationCache::clear);
    }

    @Unique
    private boolean story_Mode_Reborn$hasAnimationMetadata(ResourceLocation texture) {
        var mcmeta = ResourceLocation.fromNamespaceAndPath(
            texture.getNamespace(),
            texture.getPath() + ".mcmeta"
        );

        try {
            //ignore anything outside of entity texture paths
            if (mcmeta.getPath().contains("entity")) {
                return Minecraft.getInstance()
                        .getResourceManager()
                        .getResource(mcmeta)
                        .isPresent();
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
