package net.pandarix.verdantvibes.block.custom;

import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.text.Text;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.pandarix.verdantvibes.VerdantVibes;
import net.pandarix.verdantvibes.VerdantVibesClient;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VerdantPlantBlock extends PlantBlock implements Fertilizable {
    //FACING
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    private final VoxelShape voxelShape;
    private final List<Block> mayPlaceOn;

    public VerdantPlantBlock(AbstractBlock.Settings settings, List<Block> mayPlaceOn, VoxelShape pVoxelShape) {
        super(settings);
        this.mayPlaceOn = mayPlaceOn;
        this.voxelShape = pVoxelShape;
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockToPlaceOn = world.getBlockState(pos.down());
        if (mayPlaceOn.contains(blockToPlaceOn.getBlock())) {
            if(blockToPlaceOn.isOf(Blocks.WATER)){
                return !world.getBlockState(pos.down(2)).isOf(Blocks.WATER);
            }
            return true;
        }
        return super.canPlaceAt(state, world, pos);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return voxelShape.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable(this.getTranslationKey() + ".info").formatted(Formatting.DARK_GRAY, Formatting.ITALIC));
        super.appendTooltip(stack, world, tooltip, options);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        Block.dropStack(world, pos, new ItemStack(this));
    }
}
