package net.Soviet.sovietmod.block.custom;

import net.minecraft.block.AbstractGlassBlock;
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

public class VodkaBlock extends AbstractGlassBlock {
    public static final VoxelShape SHAPE = makeShape();

    public VodkaBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public static VoxelShape makeShape(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0, 0.4375, 0.5625, 0.01874999999999999, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0.01562500000000002, 0.4218750000000001, 0.5625, 0.303125, 0.44062500000000004), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.559375, 0.01562500000000002, 0.4375, 0.5781249999999999, 0.303125, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0.01562500000000002, 0.559375, 0.5625, 0.303125, 0.5781249999999999), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4218750000000001, 0.01562500000000002, 0.4375, 0.44062500000000004, 0.303125, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0.30000000000000004, 0.4375, 0.5625, 0.31875000000000003, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.46875, 0.31875000000000003, 0.46875, 0.53125, 0.43125, 0.53125), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4640625, 0.42500000000000016, 0.4640625, 0.5359375, 0.48750000000000016, 0.5359375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.440625, 0.020312499999999997, 0.440625, 0.559375, 0.20468750000000002, 0.559375), IBooleanFunction.OR);

        return shape;
    }
}
