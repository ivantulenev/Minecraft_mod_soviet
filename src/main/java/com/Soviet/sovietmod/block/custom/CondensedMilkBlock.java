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

public class CondensedMilkBlock extends HorizontalBlock {

    public static final VoxelShape SHAPE = makeShape();

    public CondensedMilkBlock(Properties p_i48377_1_) {
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
                Block.box(7, 0.1, 7, 9, 2.9, 9),
                Block.box(9, 2.9000000000000004, 7, 9.125, 2.9999999999999942, 9),
                Block.box(6.875000000000007, 2.9000000000000004, 7, 7.000000000000007, 2.9999999999999942, 9),
                Block.box(7.0000000000000036, 2.9000000000000004, 6.8750000000000036, 9.000000000000004, 2.9999999999999942, 7.0000000000000036),
                Block.box(7.0000000000000036, 2.9000000000000004, 8.999999999999996, 9.000000000000004, 2.9999999999999942, 9.124999999999996),
                Block.box(9, -7.494005416219807e-16, 7, 9.125, 0.09999999999999312, 9),
                Block.box(6.875000000000007, -7.494005416219807e-16, 7, 7.000000000000007, 0.09999999999999312, 9),
                Block.box(7.0000000000000036, -7.494005416219807e-16, 6.8750000000000036, 9.000000000000004, 0.09999999999999312, 7.0000000000000036),
                Block.box(7.0000000000000036, -7.494005416219807e-16, 8.999999999999996, 9.000000000000004, 0.09999999999999312, 9.124999999999996)
        ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }

}
