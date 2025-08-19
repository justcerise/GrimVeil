package net.grimveil.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import net.grimveil.block.ModBlocks;


public class BysmalSaplingBlock extends SaplingBlock {
    public BysmalSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos below = pos.down();
        BlockState floor = world.getBlockState(below);
        return floor.isOf(ModBlocks.BYSMAL_GRASS_BLOCK) ||
                floor.isOf(ModBlocks.BYSMAL_MOSS_BLOCK) ||
                floor.isOf(ModBlocks.BYSMAL_DIRT);
    }
}

