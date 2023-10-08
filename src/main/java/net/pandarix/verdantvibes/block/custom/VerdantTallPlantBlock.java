package net.pandarix.verdantvibes.block.custom;

import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.text.Text;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VerdantTallPlantBlock extends TallFlowerBlock {
    //FACING
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private final VoxelShape voxelShape;
    private final List<Block> mayPlaceOn;

    public VerdantTallPlantBlock(AbstractBlock.Settings pProperties, List<Block> mayPlaceOn, VoxelShape pVoxelShape) {
        super(pProperties);
        this.mayPlaceOn = mayPlaceOn;
        this.voxelShape = pVoxelShape;
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (mayPlaceOn.contains(state.getBlock())) {
            if (state.isOf(Blocks.WATER)) {
                return !world.getBlockState(pos.down()).isOf(Blocks.WATER);
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

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        double d0 = Math.abs(entity.getVelocity().y);
        if (d0 < 0.1D && !entity.isSneaking()) {
            double d1 = 0.4D + d0 * 0.8D;
            entity.setVelocity(entity.getVelocity().multiply(d1, 1.0D, d1));
        }
        super.onEntityCollision(state, world, pos, entity);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (ctx.getWorld().isInBuildLimit(ctx.getBlockPos().up()) && ctx.getWorld().getBlockState(ctx.getBlockPos().up()).canReplace(ctx)) {
            return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
        }
        return super.getPlacementState(ctx);
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
}
