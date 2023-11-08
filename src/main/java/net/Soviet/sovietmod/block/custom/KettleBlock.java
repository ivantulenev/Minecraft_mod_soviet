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

public class KettleBlock extends HorizontalBlock {
    public static final VoxelShape SHAPE_N = makeShape_N();
    public static final VoxelShape SHAPE_S = makeShape_S();
    public static final VoxelShape SHAPE_W = makeShape_W();
    public static final VoxelShape SHAPE_E = makeShape_E();

    public KettleBlock(Properties p_i48377_1_) {
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

    public static VoxelShape makeShape_N(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.375, 0, 0.375, 0.625, 0.012499999999999997, 0.625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.375, -2.2551405187698492e-17, 0.36250000000000004, 0.625, 0.18749999999999997, 0.3750000000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.375, -2.2551405187698492e-17, 0.6250000000000001, 0.625, 0.18749999999999997, 0.6375000000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.6249999999999999, -2.2551405187698492e-17, 0.375, 0.6375, 0.18749999999999997, 0.625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.36249999999999993, -2.2551405187698492e-17, 0.375, 0.3749999999999999, 0.18749999999999997, 0.625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.375, 0.1875, 0.375, 0.625, 0.2, 0.625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.40625, 0.1875, 0.40625, 0.59375, 0.221875, 0.59375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.6, 0.11875000000000002, 0.484375, 0.75, 0.15000000000000002, 0.515625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.6250000000000002, 0.10625, 0.484375, 0.6812500000000001, 0.15, 0.515625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.396875, 0.21875, 0.403125, 0.603125, 0.23125, 0.596875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.46875, 0.2437500000000001, 0.49218750000000006, 0.53125, 0.2562500000000002, 0.5078125), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.51875, 0.2312500000000001, 0.49218750000000006, 0.53125, 0.2437500000000002, 0.5078125), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4687500000000002, 0.2312500000000001, 0.49218750000000006, 0.4812500000000002, 0.2437500000000002, 0.5078125), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.6375000000000003, 0.17500000000000007, 0.4937500000000001, 0.6437500000000003, 0.25000000000000017, 0.50625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.3562500000000002, 0.17500000000000007, 0.4937500000000001, 0.36250000000000016, 0.25000000000000017, 0.50625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.6109375000000004, 0.23593750000000008, 0.4937500000000001, 0.6171875000000003, 0.31406250000000013, 0.50625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.34687500000000043, 0.2718750000000002, 0.4937500000000001, 0.4250000000000005, 0.2781250000000002, 0.50625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.41093750000000046, 0.29843750000000047, 0.4937500000000001, 0.5890625000000005, 0.30468750000000044, 0.50625), IBooleanFunction.OR);

        return shape;
    }
    public static VoxelShape makeShape_S(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.39428616523516824, 0, 0.36875000000000013, 0.6442861652351684, 0.0125, 0.6187500000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.39428616523516824, 0.1875, 0.36875000000000013, 0.6442861652351684, 0.2, 0.6187500000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4161611652351682, 0.21875, 0.3968750000000001, 0.6224111652351684, 0.23125, 0.5906250000000002), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.39428616523516824, 0, 0.6187500000000001, 0.6442861652351684, 0.1875, 0.6312500000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.39428616523516824, 0, 0.3562500000000002, 0.6442861652351684, 0.1875, 0.36875000000000013), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.6442861652351684, 0, 0.36875000000000013, 0.6567861652351683, 0.1875, 0.6187500000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.3817861652351683, 0, 0.36875000000000013, 0.39428616523516824, 0.1875, 0.6187500000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.42553616523516824, 0.1875, 0.40000000000000013, 0.6130361652351684, 0.221875, 0.5875000000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.33244405564921586, 0.005335864391532316, 0.47812500000000013, 0.4824440556492159, 0.036585864391532316, 0.5093750000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.3380361652351682, 0.10625, 0.47812500000000013, 0.39428616523516824, 0.15, 0.5093750000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.48803616523516824, 0.24375, 0.48593750000000013, 0.5505361652351684, 0.25625, 0.5015625000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.48803616523516824, 0.23125, 0.48593750000000013, 0.5005361652351682, 0.24375, 0.5015625000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5380361652351683, 0.23125, 0.48593750000000013, 0.5505361652351684, 0.24375, 0.5015625000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.3755361652351682, 0.17499999999999993, 0.48750000000000016, 0.3817861652351683, 0.25, 0.5000000000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.3443103187882448, 0.13326340973927767, 0.48750000000000016, 0.3505603187882448, 0.2113884097392777, 0.5000000000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4696815532464259, 0.33050964419745876, 0.48750000000000016, 0.5478065532464259, 0.3367596441974588, 0.5000000000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4302236652351682, 0.2984375, 0.48750000000000016, 0.6083486652351684, 0.3046875, 0.5000000000000001), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.6567861652351683, 0.175, 0.48750000000000016, 0.6630361652351684, 0.25, 0.5000000000000001), IBooleanFunction.OR);

        return shape;
    }
    public static VoxelShape makeShape_E(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.37526808261758415, 0, 0.34973191738241594, 0.6252680826175842, 0.0125, 0.599731917382416), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.37526808261758415, 0.1875, 0.34973191738241594, 0.6252680826175842, 0.2, 0.599731917382416), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4033930826175841, 0.21875, 0.3716069173824159, 0.5971430826175842, 0.23125, 0.5778569173824161), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.6252680826175842, 0, 0.34973191738241594, 0.6377680826175841, 0.1875, 0.599731917382416), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.3627680826175842, 0, 0.34973191738241594, 0.37526808261758415, 0.1875, 0.599731917382416), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.37526808261758415, 0, 0.337231917382416, 0.6252680826175842, 0.1875, 0.34973191738241594), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.37526808261758415, 0, 0.599731917382416, 0.6252680826175842, 0.1875, 0.612231917382416), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.40651808261758415, 0.1875, 0.38098191738241594, 0.5940180826175842, 0.221875, 0.568481917382416), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.48464308261758415, 0.005335864391532316, 0.5115740269683684, 0.5158930826175842, 0.036585864391532316, 0.6615740269683684), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.48464308261758415, 0.10625, 0.599731917382416, 0.5158930826175842, 0.15, 0.6559819173824161), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.49245558261758415, 0.24375, 0.44348191738241594, 0.5080805826175842, 0.25625, 0.505981917382416), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.49245558261758415, 0.23125, 0.4934819173824161, 0.5080805826175842, 0.24375, 0.505981917382416), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.49245558261758415, 0.23125, 0.44348191738241594, 0.5080805826175842, 0.24375, 0.455981917382416), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4940180826175842, 0.17499999999999993, 0.612231917382416, 0.5065180826175841, 0.25, 0.6184819173824161), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4940180826175842, 0.13326340973927767, 0.6434577638293395, 0.5065180826175841, 0.2113884097392777, 0.6497077638293395), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4940180826175842, 0.33050964419745876, 0.4462115293711584, 0.5065180826175841, 0.3367596441974588, 0.5243365293711584), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4940180826175842, 0.2984375, 0.3856694173824159, 0.5065180826175841, 0.3046875, 0.5637944173824161), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4940180826175842, 0.175, 0.3309819173824159, 0.5065180826175841, 0.25, 0.337231917382416), IBooleanFunction.OR);

        return shape;
    }
    public static VoxelShape makeShape_W(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.3940180826175841, 0, 0.3940180826175841, 0.6440180826175841, 0.0125, 0.6440180826175841), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.3940180826175841, 0.1875, 0.3940180826175841, 0.6440180826175841, 0.2, 0.6440180826175841), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.42214308261758404, 0.21875, 0.41589308261758406, 0.6158930826175841, 0.23125, 0.6221430826175841), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.38151808261758413, 0, 0.3940180826175841, 0.3940180826175841, 0.1875, 0.6440180826175841), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.6440180826175841, 0, 0.3940180826175841, 0.656518082617584, 0.1875, 0.6440180826175841), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.3940180826175841, 0, 0.6440180826175841, 0.6440180826175841, 0.1875, 0.656518082617584), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.3940180826175841, 0, 0.38151808261758413, 0.6440180826175841, 0.1875, 0.3940180826175841), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4252680826175841, 0.1875, 0.4252680826175841, 0.6127680826175841, 0.221875, 0.6127680826175841), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5033930826175841, 0.005335864391532316, 0.3321759730316317, 0.5346430826175841, 0.036585864391532316, 0.48217597303163173), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5033930826175841, 0.10625, 0.33776808261758406, 0.5346430826175841, 0.15, 0.3940180826175841), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5112055826175841, 0.24375, 0.4877680826175841, 0.5268305826175841, 0.25625, 0.5502680826175841), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5112055826175841, 0.23125, 0.4877680826175841, 0.5268305826175841, 0.24375, 0.500268082617584), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5112055826175841, 0.23125, 0.5377680826175841, 0.5268305826175841, 0.24375, 0.5502680826175841), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5127680826175841, 0.17499999999999993, 0.37526808261758404, 0.5252680826175841, 0.25, 0.38151808261758413), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5127680826175841, 0.13326340973927767, 0.34404223617066065, 0.5252680826175841, 0.2113884097392777, 0.35029223617066063), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5127680826175841, 0.33050964419745876, 0.46941347062884176, 0.5252680826175841, 0.3367596441974588, 0.5475384706288418), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5127680826175841, 0.2984375, 0.42995558261758404, 0.5252680826175841, 0.3046875, 0.6080805826175841), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5127680826175841, 0.175, 0.656518082617584, 0.5252680826175841, 0.25, 0.6627680826175841), IBooleanFunction.OR);

        return shape;
    }
}
