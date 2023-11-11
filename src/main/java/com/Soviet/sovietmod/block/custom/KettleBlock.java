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
import java.util.stream.Stream;

public class KettleBlock extends HorizontalBlock {

    public static final VoxelShape SHAPE_E = makeShape_E();
    public static final VoxelShape SHAPE_N = makeShape_N();
    public static final VoxelShape SHAPE_S = makeShape_S();
    public static final VoxelShape SHAPE_W = makeShape_W();

    public KettleBlock(Properties p_i48377_1_) {
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
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }
    public static VoxelShape makeShape_N(){

        return Stream.of(
                Block.box(5.599999999999999, 0, 5.500000000000001, 9.999999999999996, 3.1999999999999997, 10.100000000000001),
                Block.box(9.999999999999998, 1.2000000000000002, 7.575, 10.499999999999996, 2.3999999999999995, 8.100000000000001),
                Block.box(10.499999999999996, 1.8000000000000003, 7.575, 10.999999999999995, 2.5999999999999996, 8.100000000000001),
                Block.box(10.999999999999995, 2.2000000000000006, 7.575, 11.399999999999993, 2.9, 8.100000000000001),
                Block.box(5.799999999999997, 3.2, 5.8, 9.799999999999997, 3.7999999999999914, 9.8),
                Block.box(7.299999999999997, 3.8000000000000007, 7.675000000000001, 8.299999999999997, 4.199999999999991, 7.95)
        ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }


    public static VoxelShape makeShape_W(){

        return Stream.of(
                Block.box(5.481250000000003, 0, 6.018750000000006, 10.081250000000002, 3.1999999999999997, 10.418750000000005),
                Block.box(7.556250000000002, 1.2000000000000002, 5.518750000000006, 8.081250000000002, 2.3999999999999995, 6.018750000000004),
                Block.box(7.556250000000002, 1.8000000000000003, 5.018750000000008, 8.081250000000002, 2.5999999999999996, 5.518750000000006),
                Block.box(7.556250000000002, 2.2000000000000006, 4.618750000000009, 8.081250000000002, 2.9, 5.018750000000008),
                Block.box(5.78125, 3.2, 6.218750000000005, 9.781250000000002, 3.7999999999999914, 10.218750000000005),
                Block.box(7.656250000000002, 3.8000000000000007, 7.718750000000005, 7.931250000000002, 4.199999999999991, 8.718750000000005)
        ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }

    public static VoxelShape makeShape_E(){
        return Stream.of(
                Block.box(5.918750000000001, 0, 5.618749999999997, 10.51875, 3.1999999999999997, 10.018749999999995),
                Block.box(7.918750000000001, 1.2000000000000002, 10.018749999999997, 8.443750000000001, 2.3999999999999995, 10.518749999999995),
                Block.box(7.918750000000001, 1.8000000000000003, 10.518749999999995, 8.443750000000001, 2.5999999999999996, 11.018749999999994),
                Block.box(7.918750000000001, 2.2000000000000006, 11.018749999999994, 8.443750000000001, 2.9, 11.418749999999992),
                Block.box(6.218750000000002, 3.2, 5.818749999999996, 10.218750000000004, 3.7999999999999914, 9.818749999999996),
                Block.box(8.068750000000001, 3.8000000000000007, 7.318749999999996, 8.343750000000002, 4.199999999999991, 8.318749999999996)
        ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }
    public static VoxelShape makeShape_S(){

        return Stream.of(
                Block.box(6.000000000000007, 0, 5.9375, 10.400000000000006, 3.1999999999999997, 10.5375),
                Block.box(5.500000000000007, 1.2000000000000002, 7.9375, 6.000000000000005, 2.3999999999999995, 8.4625),
                Block.box(5.000000000000009, 1.8000000000000003, 7.9375, 5.500000000000007, 2.5999999999999996, 8.4625),
                Block.box(4.60000000000001, 2.2000000000000006, 7.9375, 5.000000000000009, 2.9, 8.4625),
                Block.box(6.200000000000006, 3.2, 6.237500000000001, 10.200000000000006, 3.7999999999999914, 10.237500000000002),
                Block.box(7.700000000000006, 3.8000000000000007, 8.0875, 8.700000000000006, 4.199999999999991, 8.3625)
        ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }
}
