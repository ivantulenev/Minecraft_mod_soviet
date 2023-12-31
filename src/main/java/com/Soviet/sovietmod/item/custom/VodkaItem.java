package com.Soviet.sovietmod.item.custom;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class VodkaItem extends BlockItem {
    public VodkaItem(Block p_i48527_1_, Properties p_i48527_2_) {
        super(p_i48527_1_, p_i48527_2_);
    }


    @Override
    @ParametersAreNonnullByDefault
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity entity) {
        PlayerEntity player = (PlayerEntity) entity;
        player.addEffect(new EffectInstance(Effects.CONFUSION, 3600));
        if (!player.isCreative()) {
            stack.shrink(1);
            //TODO(duduc): change to custom bottle (maybe?)
            ItemStack emptyBottle = new ItemStack(Items.GLASS_BOTTLE);
            if (!player.inventory.add(emptyBottle)) {
                player.drop(emptyBottle, false);
            }
        }
        return super.finishUsingItem(stack, world, entity);
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    @Override
    @ParametersAreNonnullByDefault
    @MethodsReturnNonnullByDefault
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    @MethodsReturnNonnullByDefault
    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    @MethodsReturnNonnullByDefault
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    @MethodsReturnNonnullByDefault
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        return DrinkHelper.useDrink(p_77659_1_, p_77659_2_, p_77659_3_);
    }
}
