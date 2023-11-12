package com.Soviet.sovietmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;


public class KolbasaBlock extends HorizontalBlock {

    public static final VoxelShape SHAPE_W_E = makeShape_W_E();
    public static final VoxelShape SHAPE_S_N = makeShape_S_N();

    public KolbasaBlock(Properties p_i48377_1_) {
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
        switch (state.getValue(FACING)) {
            case SOUTH:
                return SHAPE_S_N;
            case EAST:
                return SHAPE_W_E;
            case WEST:
                return SHAPE_W_E;
            default:
                return SHAPE_S_N;
        }
    }

    public static VoxelShape makeShape_W_E() {
        return Block.box(5.600000000000001, 0.024999999999999925, 7.425000000000001, 10.399999999999999, 1.125, 8.525000000000002);
    }

    public static VoxelShape makeShape_S_N() {
        return Block.box(7.45, 0.024999999999999925, 5.575000000000002, 8.55, 1.125, 10.375);
    }

}
