package com.Soviet.sovietmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class VodkaBlock extends HorizontalBlock {
    public static final VoxelShape SHAPE = makeShape();

    public VodkaBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult rayTraceResult) {
        if (playerEntity.isShiftKeyDown() && playerEntity.getItemInHand(hand).getItem() == Items.AIR) {
            world.addFreshEntity(new ItemEntity(world, playerEntity.getX() + 0.5, playerEntity.getY() + 0.5, playerEntity.getZ() + 0.5, new ItemStack(this)));
            world.removeBlock(pos, false);
        }
        return ActionResultType.sidedSuccess(world.isClientSide);
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
