package net.pandarix.verdantvibes.block.custom;

import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VerdantPetalPlantBlock extends FlowerbedBlock implements Fertilizable {
    private final VoxelShape voxelShape;
    private final List<Block> mayPlaceOn;

    public VerdantPetalPlantBlock(AbstractBlock.Settings settings, List<Block> mayPlaceOn, VoxelShape pVoxelShape) {
        super(settings);
        this.mayPlaceOn = mayPlaceOn;
        this.voxelShape = pVoxelShape;
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (mayPlaceOn.contains(state.getBlock())) {
            if(state.isOf(Blocks.WATER)){
                return !world.getBlockState(pos.down()).isOf(Blocks.WATER);
            }
            return true;
        }

        return super.canPlaceAt(state, world, pos);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return voxelShape;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable(this.getTranslationKey() + ".info").formatted(Formatting.DARK_GRAY, Formatting.ITALIC));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
