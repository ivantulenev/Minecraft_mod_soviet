package com.Soviet.sovietmod.block.custom;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class DoubleTableRightBlock extends HorizontalBlock {
    public static final EnumProperty<DoubleTablePart> TABLE_PART = EnumProperty.create("part", DoubleTablePart.class);
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;

    public DoubleTableRightBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
        registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(TABLE_PART, DoubleTablePart.RIGHT));
    }


    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        return state.getValue(TABLE_PART) == DoubleTablePart.RIGHT ? blockstate.isFaceSturdy(worldIn, blockpos, Direction.UP) : blockstate.is(this);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getClickedPos();
        if (blockpos.getY() < 255 && context.getLevel().getBlockState(blockpos.east()).canBeReplaced(context)) {
            return getStateDefinition().any().setValue(FACING, context.getHorizontalDirection()).setValue(TABLE_PART, DoubleTablePart.RIGHT);
        } else {
            return null;
        }
    }

    private static Direction getNeighbourDirection(DoubleTablePart p_208070_0_, Direction p_208070_1_) {
        return p_208070_0_ == DoubleTablePart.RIGHT ? p_208070_1_ : p_208070_1_.getOpposite();
    }

    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        world.setBlock(pos.east(), state.setValue(TABLE_PART, DoubleTablePart.LEFT), 3);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(TABLE_PART, FACING);
    }

    @Override
    public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!worldIn.isClientSide && player.isCreative()) {
            DoubleTablePart doubletablepart = state.getValue(TABLE_PART);
            if (doubletablepart == DoubleTablePart.LEFT) {
                BlockPos blockPos = pos.west();
                BlockState blockState = worldIn.getBlockState(blockPos);
                if (blockState.getBlock() == state.getBlock() && blockState.getValue(TABLE_PART) == DoubleTablePart.RIGHT) {
                    worldIn.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 35);
                }
            }
            if (doubletablepart == DoubleTablePart.RIGHT) {
                BlockPos blockPos = pos.east();
                BlockState blockState = worldIn.getBlockState(blockPos);
                if (blockState.getBlock() == state.getBlock() && blockState.getValue(TABLE_PART) == DoubleTablePart.LEFT) {
                    worldIn.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 35);
                }
            }
        }
        super.playerWillDestroy(worldIn, pos, state, player);
    }


    public enum DoubleTablePart implements IStringSerializable {
        RIGHT("right"),
        LEFT("left");

        private final String name;

        DoubleTablePart(String p_i49342_3_) {
            this.name = p_i49342_3_;
        }

        public String toString() {
            return this.name;
        }

        public String getSerializedName() {
            return this.name;
        }
    }
}
