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

public class VinylRecordPlayerKinoBlock extends HorizontalBlock {

    public static final VoxelShape SHAPE = makeShape();

    public VinylRecordPlayerKinoBlock(Properties p_i48377_1_) {
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
        return VoxelShapes.join(Block.box(3.0999999999999996, 0, 3.599999999999998, 12.9, 1.8, 12.399999999999999), Block.box(4.8999999999999995, 1.8, 4.999999999999998, 11.100000000000001, 2.400000000000001, 10.999999999999998), IBooleanFunction.OR);
    }

}
