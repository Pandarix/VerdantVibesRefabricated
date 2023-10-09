package net.pandarix.verdantvibes.block.custom;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.pandarix.verdantvibes.VerdantVibes;
import org.jetbrains.annotations.Nullable;

public class TurnableFlowerPotBlock extends FlowerPotBlock {
    //advancement id for granting the advancement in onBreak, condition of advancement is "impossible" and needs to be executed here
    Identifier ADVANCEMENT_ID = new Identifier(VerdantVibes.MOD_ID, "potters_pivot");

    public TurnableFlowerPotBlock(Block pContent, AbstractBlock.Settings settings) {
        super(pContent, settings);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(player.isSneaking()){
            if(world.getServer() != null){
                AdvancementEntry advancement = world.getServer().getAdvancementLoader().get(ADVANCEMENT_ID);
                if(advancement != null){
                    if(player instanceof ServerPlayerEntity serverPlayer){
                        serverPlayer.getAdvancementTracker().grantCriterion(advancement,"planted_pot");
                    }
                }
            }
            world.setBlockState(pos, state.rotate(BlockRotation.CLOCKWISE_90), 3);
            world.playSound(null, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 0.25f, 1.5f);
            return ActionResult.success(world.isClient());
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() instanceof TurnableFlowerPotBlock || state.getBlock() instanceof FlowerPotBlock){
            if(newState.getBlock() != state.getBlock()){
                world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS);
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    //FACING
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

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
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}
