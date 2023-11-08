package net.Soviet.sovietmod.block.custom;

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

public class BreadBlock extends HorizontalBlock {
    public static final VoxelShape SHAPE = makeShape();

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
        return SHAPE;
    }

    public static VoxelShape makeShape() {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0, 0.3125, 0.5, 0.09375, 0.6875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.40625, 0, 0.390625, 0.4375, 0.0859375, 0.609375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4140625, 0, 0.3125, 0.44218750000000007, 0.0859375, 0.396875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.41406250000000006, 0, 0.3125, 0.44218750000000007, 0.0859375, 0.396875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5, 0, 0.3125, 0.5625, 0.09375, 0.6875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5625, 0, 0.390625, 0.59375, 0.0859375, 0.609375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5421874999999999, 0, 0.6, 0.5703125, 0.0859375, 0.684375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4296875, 0, 0.6, 0.45781250000000007, 0.0859375, 0.684375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5578124999999999, 0, 0.3125, 0.5859375, 0.0859375, 0.396875), IBooleanFunction.OR);

        return shape;
    }
}
