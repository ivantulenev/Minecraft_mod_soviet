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
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.stream.Stream;

public class CutGlassBlock extends HorizontalBlock {

    public static final VoxelShape SHAPE = makeShape();

    public CutGlassBlock(Properties p_i48377_1_) {
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
        return SHAPE;
    }

    public static VoxelShape makeShape() {
        return Stream.of(
                Block.box(7.299999999999999, 0.30000000000000054, 7.200000000000005, 8.700000000000001, 2.800000000000002, 7.325000000000005),
                Block.box(7.299999999999999, 0, 7.299999999999999, 8.700000000000001, 0.2999999999999998, 8.700000000000001),
                Block.box(7.175000000000003, 0.30000000000000054, 7.299999999999999, 7.3000000000000025, 2.800000000000002, 8.700000000000001),
                Block.box(8.699999999999996, 0.30000000000000054, 7.299999999999999, 8.824999999999994, 2.800000000000002, 8.700000000000001),
                Block.box(7.299999999999999, 0.30000000000000054, 8.699999999999996, 8.700000000000001, 2.800000000000002, 8.824999999999996)
        ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }

}
