package silly.chemthunder.stargaze.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silly.chemthunder.stargaze.index.StargazeStatusEffects;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    @Inject(method = "renderCrosshair", at = @At("HEAD"), cancellable = true)
    private void stargaze$disableCrosshairRenderingWhilstUsingSpyglass(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        assert MinecraftClient.getInstance().player != null;
        if (MinecraftClient.getInstance().player.isUsingSpyglass()) {
            ci.cancel();
        }
    }

    @Inject(method = "renderFood", at = @At("HEAD"), cancellable = true)
    private void stargaze$disableHungerBar(DrawContext context, PlayerEntity player, int top, int right, CallbackInfo ci) {
        if (player.hasStatusEffect(StargazeStatusEffects.ENLIGHTENED)) {
            ci.cancel();
        }
    }
}
