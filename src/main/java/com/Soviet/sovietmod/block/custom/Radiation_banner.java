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

public class Radiation_banner extends HorizontalBlock  {

    public static final VoxelShape SHAPE = makeShape();

    public Radiation_banner(Properties p_i48377_1_) {
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

    public static VoxelShape makeShape(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.8375, -0.05, 0.4812500000000002, 0.875, 1.0124999999999997, 0.5187500000000002), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.19375, 0.93125, 0.475, 0.7937500000000001, 1.05625, 0.525), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.40257475625913736, 1.0754101853047735, 0.4765625, 0.5275747562591373, 1.4754101853047745, 0.5234375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.13382475625913737, 1.2629101853047735, 0.4765625, 0.5900747562591384, 1.3941601853047736, 0.5234375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.16507475625913726, 0.9566601853047734, 0.4765625, 0.29632475625913746, 1.4191601853047753, 0.5234375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.2021203552633006, 1.0554285625889874, 0.475, 0.5271203552633015, 1.3116785625889875, 0.525), IBooleanFunction.OR);

        return shape;
    }


}
