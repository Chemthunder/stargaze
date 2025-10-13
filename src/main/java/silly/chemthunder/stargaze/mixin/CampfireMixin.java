package silly.chemthunder.stargaze.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CampfireBlock.class)
public abstract class CampfireMixin extends BlockWithEntity implements Waterloggable {
    protected CampfireMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "onEntityCollision", at = @At("HEAD"))
    private void stargaze$addsAstralShenanigans(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, CallbackInfo ci) {
        if (entity instanceof PlayerEntity player) {
            Hand hand = player.getActiveHand();
            ItemStack stack = player.getStackInHand(hand);
            if (player.isSneaking() && stack.isOf(Items.FLINT_AND_STEEL)) {
                // a
            }
        }
    }
}
