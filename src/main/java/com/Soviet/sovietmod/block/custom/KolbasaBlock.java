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
import javax.annotation.ParametersAreNonnullByDefault;


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
    @ParametersAreNonnullByDefault
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
        return Block.box(2.600000000000003, -2.7755575615628914e-17, 6.300000000000001, 14.200000000000003, 3, 9.299999999999997);
    }

    public static VoxelShape makeShape_S_N() {
        return Block.box(6.400000000000006, -2.7755575615628914e-17, 2.1999999999999984, 9.400000000000002, 3, 13.799999999999997);
    }

}
