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

public class ConcreteWasteBlock extends HorizontalBlock {

    public static final VoxelShape SHAPE_E = makeShape_E();
    public static final VoxelShape SHAPE_N = makeShape_N();
    public static final VoxelShape SHAPE_S = makeShape_S();
    public static final VoxelShape SHAPE_W = makeShape_W();

    public ConcreteWasteBlock(Properties p_i48377_1_) {
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
    public static VoxelShape makeShape_W(){

        return Stream.of(
                Block.box(3, 0, 4.1, 10.600000000000001, 2, 9),
                Block.box(2.8, 0, 9, 6.000000000000002, 2, 13.8),
                Block.box(1.7999999999999998, 0, 5.5, 4.000000000000002, 2, 11.100000000000001),
                Block.box(3.4, 2, 6.999999999999998, 6.200000000000002, 4.000000000000002, 12.2)
        ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }


    public static VoxelShape makeShape_N(){

        return Stream.of(
                Block.box(4.1, 0, 5.399999999999999, 9, 2, 13),
                Block.box(9, 0, 9.999999999999998, 13.8, 2, 13.2),
                Block.box(5.5, 0, 11.999999999999998, 11.100000000000001, 2, 14.2),
                Block.box(8.087362032596449, 2, 9.06653808871037, 13.287362032596452, 4.000000000000002, 11.866538088710374)
        ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }

    public static VoxelShape makeShape_E(){
        return Stream.of(
                Block.box(5.399999999999999, 0, 7, 13, 2, 11.9),
                Block.box(9.999999999999998, 0, 2.1999999999999993, 13.2, 2, 7),
                Block.box(11.999999999999998, 0, 4.899999999999999, 14.2, 2, 10.5),
                Block.box(9.06653808871037, 2, 2.7126379674035483, 11.866538088710374, 4.000000000000002, 7.912637967403551)
        ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }
    public static VoxelShape makeShape_S(){

        return Stream.of(
                Block.box(7, 0, 3, 11.9, 2, 10.600000000000001),
                Block.box(2.1999999999999993, 0, 2.8000000000000007, 7, 2, 6.000000000000002),
                Block.box(4.899999999999999, 0, 1.8000000000000007, 10.5, 2, 4.000000000000002),
                Block.box(2.7126379674035483, 2, 4.133461911289626, 7.912637967403551, 4.000000000000002, 6.93346191128963)
        ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }
}
