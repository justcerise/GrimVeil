package net.grimveil.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.SpreadableBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;
import net.minecraft.world.WorldView;
import net.grimveil.block.ModBlocks;

public class BysmalGrassBlock extends SpreadableBlock {
    public static final MapCodec<BysmalGrassBlock> CODEC = createCodec(BysmalGrassBlock::new);

    public BysmalGrassBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends SpreadableBlock> getCodec() {
        return CODEC;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!canSurvive(state, world, pos)) {
            world.setBlockState(pos, ModBlocks.BYSMAL_DIRT.getDefaultState());
            return;
        }

        if (world.getLightLevel(LightType.SKY, pos.up()) >= 9) {
            for (int i = 0; i < 4; ++i) {
                BlockPos targetPos = pos.add(
                        random.nextInt(3) - 1,
                        random.nextInt(5) - 3,
                        random.nextInt(3) - 1
                );

                if (world.getBlockState(targetPos).isOf(ModBlocks.BYSMAL_DIRT) && canSurvive(state, world, targetPos)) {
                    world.setBlockState(targetPos, this.getDefaultState());
                }
            }
        }
    }

    private static boolean canSurvive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos abovePos = pos.up();
        BlockState aboveState = world.getBlockState(abovePos);

        if (aboveState.getLuminance() > 0) {
            return true;
        }

        if (aboveState.isOpaqueFullCube()) {
            return false;
        }

        return world.getLightLevel(LightType.SKY, abovePos) >= 4 || world.getLightLevel(LightType.BLOCK, abovePos) >= 4;
    }
}
