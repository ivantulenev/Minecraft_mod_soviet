package com.Soviet.sovietmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class DiningTableBlock extends HorizontalBlock {
    public static final VoxelShape SHAPE = makeShape();

    public DiningTableBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
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

    public static VoxelShape makeShape() {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.006249999999999999, 0, 0.95, 0.05625, 0.9375, 0.99375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0.9375, 0, 1, 1, 1), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.006249999999999999, 0, 0.012499999999999956, 0.05625, 0.9375, 0.05625000000000002), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.94375, 0, 0.012499999999999956, 0.99375, 0.9375, 0.05625000000000002), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.94375, 0, 0.95, 0.99375, 0.9375, 0.99375), IBooleanFunction.OR);

        return shape;
    }
}
