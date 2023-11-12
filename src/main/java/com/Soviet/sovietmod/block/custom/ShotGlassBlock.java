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

public class ShotGlassBlock extends HorizontalBlock {

    public static final VoxelShape SHAPE = makeShape();

    public ShotGlassBlock(Properties p_i48377_1_) {
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
                Block.box(8.599999999999998, 0.19999999999999896, 7.3999999999999995, 8.7, 1.3000000000000007, 8.600000000000001),
                Block.box(7.300000000000002, 0.19999999999999896, 7.3999999999999995, 7.400000000000003, 1.3000000000000007, 8.600000000000001),
                Block.box(7.3999999999999995, 0.19999999999999896, 7.300000000000001, 8.600000000000001, 1.3000000000000007, 7.400000000000002),
                Block.box(7.3999999999999995, 0.19999999999999896, 8.599999999999998, 8.600000000000001, 1.3000000000000007, 8.7),
                Block.box(7.3999999999999995, 0, 7.3999999999999995, 8.600000000000001, 0.19999999999999996, 8.600000000000001)
        ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }

}
