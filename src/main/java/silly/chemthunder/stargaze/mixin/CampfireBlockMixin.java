package silly.chemthunder.stargaze.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CampfireBlock.class)
public abstract class CampfireBlockMixin extends BlockWithEntity implements Waterloggable {
    protected CampfireBlockMixin(Settings settings) {
        super(settings);
    }

//    @Inject(method = "onEntityCollision", at = @At("HEAD"))
//    private void stargaze$astralShenanigans(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, CallbackInfo ci) {
//        BlockPos belowPos = pos.down();
//
//        if (world.getBlockState(belowPos).isOf(Blocks.SOUL_SAND) && entity instanceof PlayerEntity player) {
//            if (player != null) {
//                player.sendMessage(Text.translatable("text.stargaze.campfire_attack").formatted(Formatting.BLACK), true);
//            }
//        }
//    }


    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockPos belowPos = pos.down();

        if (world.getBlockState(belowPos).isOf(Blocks.SOUL_SAND)) {

        }
        super.randomTick(state, world, pos, random);
    }
}
