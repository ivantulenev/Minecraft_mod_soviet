package com.Soviet.sovietmod.block.custom;


import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.BedPart;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;

public class DoubleTableBlock extends HorizontalBlock {
    public static final EnumProperty<DoubleTablePart> TABLE_PART = EnumProperty.create("part", DoubleTablePart.class);
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;
    protected DoubleTableBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
    }
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        Direction direction = p_196258_1_.getHorizontalDirection();
        BlockPos blockpos = p_196258_1_.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(direction);
        return p_196258_1_.getLevel().getBlockState(blockpos1).canBeReplaced(p_196258_1_) ? this.defaultBlockState().setValue(FACING, direction) : null;
    }
    private static Direction getNeighbourDirection(DoubleTablePart p_208070_0_, Direction p_208070_1_) {
        return p_208070_0_ == DoubleTablePart.LEFT ? p_208070_1_ : p_208070_1_.getOpposite();
    }
    public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
        if (p_196271_2_ == getNeighbourDirection(p_196271_1_.getValue(TABLE_PART), p_196271_1_.getValue(FACING))) {
            return p_196271_3_.is(this) && p_196271_3_.getValue(TABLE_PART) != p_196271_1_.getValue(TABLE_PART) ? p_196271_1_.setValue(OCCUPIED, p_196271_3_.getValue(OCCUPIED)) : Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
        }
    }
    public enum DoubleTablePart implements IStringSerializable {
        LEFT("left"),
        RIGHT("right");

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
