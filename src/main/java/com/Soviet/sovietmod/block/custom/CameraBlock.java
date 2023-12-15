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

public class CameraBlock extends HorizontalBlock {
    public static final VoxelShape SHAPE_N_S = makeShape_N_S();
    public static final VoxelShape SHAPE_W_E = makeShape_W_E();

    public CameraBlock(Properties p_i48377_1_) {
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
            case SOUTH:
                return SHAPE_N_S;
            default:
                return SHAPE_N_S;

        }
    }

    public static VoxelShape makeShape_N_S() {
        return Block.box(4, 0, 6.5, 12, 4, 9.4);
    }

    public static VoxelShape makeShape_W_E() {
        return Block.box(6.55, 0, 3.95, 9.45, 4, 11.95);
    }
}
