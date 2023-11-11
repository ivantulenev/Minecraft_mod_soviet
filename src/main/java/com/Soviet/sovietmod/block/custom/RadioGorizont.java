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

public class RadioGorizont extends HorizontalBlock {

    public static final VoxelShape RADIO_N = makeShape_N();

    public static final VoxelShape RADIO_S = makeShape_S();

    public static final VoxelShape RADIO_W = makeShape_W();

    public static final VoxelShape RADIO_E = makeShape_E();

    public RadioGorizont(Properties p_i48377_1_) {
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
                return RADIO_S;
            case EAST:
                return RADIO_E;
            case WEST:
                return RADIO_W;
            default:
                return RADIO_N;
        }
    }

    public static VoxelShape makeShape_S(){
        return VoxelShapes.join(Block.box(2.9999999999999982,
                0, 2, 13.4, 8, 4.9),
                Block.box(12.3, 8, 4, 12.6, 13.8,
                        4.199999999999999), IBooleanFunction.OR);
    }

    public static VoxelShape makeShape_W(){
        return VoxelShapes.join(Block.box(11.1, 0, 2.9999999999999982, 14, 8, 13.4), Block.box(11.8, 8, 12.3, 12, 13.8, 12.6), IBooleanFunction.OR);
    }

    public static VoxelShape makeShape_N(){
        return VoxelShapes.join(Block.box(2.5999999999999996, 0, 11.1, 13.000000000000002, 8, 14), Block.box(3.4000000000000004, 8, 11.8, 3.6999999999999993, 13.8, 12), IBooleanFunction.OR);
    }

    public static VoxelShape makeShape_E(){
        return VoxelShapes.join(Block.box(2, 0, 2.5999999999999996, 4.9, 8, 13.000000000000002), Block.box(4, 8, 3.4000000000000004, 4.199999999999999, 13.8, 3.6999999999999993), IBooleanFunction.OR);
    }
}
