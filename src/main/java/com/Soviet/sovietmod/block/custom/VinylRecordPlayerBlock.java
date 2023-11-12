package com.Soviet.sovietmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class VinylRecordPlayerBlock extends HorizontalBlock {

    public static final VoxelShape SHAPE = makeShape();
    public static final BooleanProperty LOCKED = BooleanProperty.create("locked");

    public VinylRecordPlayerBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
        registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(LOCKED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LOCKED, FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getBlock().defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result) {
        state = state.cycle(LOCKED);
        world.setBlock(pos, state, 10);
        return ActionResultType.sidedSuccess(world.isClientSide);
    }

    public static VoxelShape makeShape() {
        return
                VoxelShapes.join(Block.box(3.0999999999999996, 0, 3.599999999999998, 12.9,
                                1.8, 12.399999999999999),
                        Block.box(4.8999999999999995, 1.8,
                                4.999999999999998, 11.100000000000001,
                                2.400000000000001, 10.999999999999998), IBooleanFunction.OR);
    }

}
