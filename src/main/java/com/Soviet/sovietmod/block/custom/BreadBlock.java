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
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BreadBlock extends HorizontalBlock {
    public static final VoxelShape SHAPE_N_S = makeShape_N_S();
    public static final VoxelShape SHAPE_W_E = makeShape_W_E();

    public BreadBlock(Properties p_i48377_1_) {
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
            case EAST:
                return SHAPE_W_E;
            case WEST:
                return SHAPE_W_E;
            default:
                return SHAPE_N_S;
        }
    }

    public static VoxelShape makeShape_N_S() {

        return Block.box(6.4, 0, 5, 9.6, 1.5, 11);
    }
    public static VoxelShape makeShape_W_E() {

        return Block.box(5, 0, 6.4, 11, 1.5, 9.6);
    }

}
