package net.grimveil.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShortPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import net.grimveil.block.ModBlocks;

public class BysmalGrassPlant extends ShortPlantBlock {
    public BysmalGrassPlant(Settings settings) {
        super(settings);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos below = pos.down();
        BlockState floor = world.getBlockState(below);
        return floor.isOf(ModBlocks.BYSMAL_GRASS_BLOCK) ||
                floor.isOf(ModBlocks.BYSMAL_MOSS_BLOCK) ||
                floor.isOf(ModBlocks.BYSMAL_DIRT);
    }
}
