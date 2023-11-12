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

public class PlateBlock extends HorizontalBlock {

    public static final VoxelShape SHAPE = makeShape();

    public PlateBlock(Properties p_i48377_1_) {
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
        return Stream.of(
                Block.box(6.3, 0, 6.3, 9.7, 0.19999999999999996, 9.7),
                Block.box(5.9000000000000075, 0.2, 6.3, 6.300000000000006, 0.39999999999999997, 9.7),
                Block.box(6.300000000000006, 0.2, 9.699999999999996, 9.700000000000005, 0.39999999999999997, 10.099999999999994),
                Block.box(9.700000000000003, 0.2, 9.699999999999998, 10.000000000000002, 0.39999999999999997, 9.999999999999996),
                Block.box(9.400000000000004, 0.2, 9.399999999999999, 9.700000000000003, 0.39999999999999997, 9.699999999999998),
                Block.box(6.300000000000008, 0.2, 9.399999999999999, 6.6000000000000085, 0.39999999999999997, 9.699999999999998),
                Block.box(6.300000000000008, 0.2, 6.30000000000001, 6.6000000000000085, 0.39999999999999997, 6.6000000000000085),
                Block.box(9.399999999999997, 0.2, 6.30000000000001, 9.699999999999998, 0.39999999999999997, 6.6000000000000085),
                Block.box(9.7, 0.2, 6.3, 10.099999999999998, 0.39999999999999997, 9.7),
                Block.box(9.700000000000003, 0.2, 6.000000000000007, 10.000000000000002, 0.39999999999999997, 6.300000000000006),
                Block.box(6.000000000000012, 0.2, 6.000000000000007, 6.30000000000001, 0.39999999999999997, 6.300000000000006),
                Block.box(6.000000000000012, 0.2, 9.699999999999996, 6.30000000000001, 0.39999999999999997, 9.999999999999995),
                Block.box(6.300000000000004, 0.2, 5.900000000000006, 9.700000000000003, 0.39999999999999997, 6.300000000000004),
                Block.box(6.600000000000004, 0.2, 5.700000000000007, 9.400000000000002, 0.39999999999999997, 5.900000000000006),
                Block.box(6.600000000000004, 0.2, 10.100000000000005, 9.400000000000002, 0.39999999999999997, 10.3),
                Block.box(10.100000000000005, 0.2, 6.600000000000005, 10.3, 0.39999999999999997, 9.400000000000002),
                Block.box(5.700000000000006, 0.2, 6.600000000000005, 5.900000000000006, 0.39999999999999997, 9.400000000000002)
        ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }

}
