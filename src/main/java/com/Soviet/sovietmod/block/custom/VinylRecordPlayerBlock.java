package com.Soviet.sovietmod.block.custom;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.JukeboxTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Objects;

public class VinylRecordPlayerBlock extends JukeboxBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final VoxelShape SHAPE = makeShape();
    public static final BooleanProperty LOCKED = BooleanProperty.create("locked");

    public static final BooleanProperty HAS_RECORD = BlockStateProperties.HAS_RECORD;


    public VinylRecordPlayerBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LOCKED, HAS_RECORD, FACING);
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getBlock().defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(LOCKED, false)
                .setValue(HAS_RECORD, false);
    }

    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity livingEntity, ItemStack stack) {
        super.setPlacedBy(world, pos, state, livingEntity, stack);
        CompoundNBT compoundnbt = stack.getOrCreateTag();
        if (compoundnbt.contains("BlockEntityTag")) {
            CompoundNBT compoundnbt1 = compoundnbt.getCompound("BlockEntityTag");
            if (compoundnbt1.contains("RecordItem")) {
                world.setBlock(pos, state.setValue(HAS_RECORD, Boolean.TRUE), 2);
            }
        }

    }

    @Override
    @MethodsReturnNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    private void dropRecording(World world, BlockPos pos) {
        if (!world.isClientSide) {
            TileEntity tileentity = world.getBlockEntity(pos);
            if (tileentity instanceof JukeboxTileEntity) {
                JukeboxTileEntity jukeboxtileentity = (JukeboxTileEntity) tileentity;
                ItemStack itemstack = jukeboxtileentity.getRecord();
                if (!itemstack.isEmpty()) {
                    world.levelEvent(1010, pos, 0);
                    jukeboxtileentity.clearContent();
                    float f = 0.7F;
                    double d0 = (double) (world.random.nextFloat() * 0.7F) + (double) 0.15F;
                    double d1 = (double) (world.random.nextFloat() * 0.7F) + (double) 0.060000002F + 0.6D;
                    double d2 = (double) (world.random.nextFloat() * 0.7F) + (double) 0.15F;
                    ItemStack itemstack1 = itemstack.copy();
                    ItemEntity itementity = new ItemEntity(world, (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, itemstack1);
                    itementity.setDefaultPickUpDelay();
                    world.addFreshEntity(itementity);
                }
            }
        }
    }

    @Override
    public void setRecord(IWorld world, BlockPos pos, BlockState state, ItemStack stack) {
        TileEntity tileentity = world.getBlockEntity(pos);
        if (tileentity instanceof JukeboxTileEntity) {
            ((JukeboxTileEntity) tileentity).setRecord(stack.copy());
            world.setBlock(pos, state.setValue(HAS_RECORD, Boolean.TRUE), 2);
        }
    }

    @MethodsReturnNonnullByDefault
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        System.out.println("use");
        if (state.getValue(HAS_RECORD) && !Screen.hasShiftDown() && !state.getValue(LOCKED)) {
            this.dropRecording(world, pos);
            state = state.setValue(HAS_RECORD, Boolean.FALSE);
            world.setBlock(pos, state, 2);
            return ActionResultType.sidedSuccess(world.isClientSide);
        }

        if (player.getItemInHand(hand).getItem() instanceof MusicDiscItem && !state.getValue(LOCKED)
                && !state.getValue(HAS_RECORD) && !Screen.hasShiftDown()) {
            state = state.setValue(HAS_RECORD, Boolean.TRUE);
            world.setBlock(pos, state, 2);
            /*world.setBlock(pos,state, )*/
            ;
            this.setRecord(world, pos, state, player.getItemInHand(hand));
            world.levelEvent(null, 1010, pos, Item.getId(player.getItemInHand(hand).getItem()));
            player.getItemInHand(hand).shrink(1);
            player.awardStat(Stats.PLAY_RECORD);
            return ActionResultType.sidedSuccess(world.isClientSide);
        }

        state = state.cycle(LOCKED);
        world.setBlock(pos, state, 2);
        return ActionResultType.sidedSuccess(world.isClientSide);
    }

    @Override
    public void onRemove(BlockState state, World world, BlockPos pos, BlockState state1, boolean b) {
        if (!state.is(state1.getBlock())) {
            this.dropRecording(world, pos);
            super.onRemove(state, world, pos, state1, b);
        }
    }

    public static VoxelShape makeShape() {
        return
                VoxelShapes.join(Block.box(3.0999999999999996, 0, 3.599999999999998, 12.9,
                                1.8, 12.399999999999999),
                        Block.box(4.8999999999999995, 1.8,
                                4.999999999999998, 11.100000000000001,
                                2.400000000000001, 10.999999999999998), IBooleanFunction.OR);
    }

}
