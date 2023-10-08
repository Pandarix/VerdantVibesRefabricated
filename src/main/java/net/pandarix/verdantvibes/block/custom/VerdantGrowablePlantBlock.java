package net.pandarix.verdantvibes.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;

public class VerdantGrowablePlantBlock extends VerdantPlantBlock {
    private final VerdantTallPlantBlock grownPlant;
    public VerdantGrowablePlantBlock(AbstractBlock.Settings settings, List<Block> mayPlaceOn, VoxelShape pVoxelShape, VerdantTallPlantBlock pGrownPlant) {
        super(settings, mayPlaceOn, pVoxelShape);
        grownPlant = pGrownPlant;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if(world.getBlockState(pos.up()).isAir()){
            world.setBlockState(pos, grownPlant.getDefaultState().with(FACING, state.get(FACING)).with(VerdantTallPlantBlock.HALF, DoubleBlockHalf.LOWER), 3);
            world.setBlockState(pos.up(), grownPlant.getDefaultState().with(FACING, state.get(FACING)).with(VerdantTallPlantBlock.HALF, DoubleBlockHalf.UPPER), 3);
        }

        super.grow(world, random, pos, state);
    }
}