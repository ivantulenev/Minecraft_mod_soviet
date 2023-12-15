package com.Soviet.sovietmod.item;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potions;

public class ModFoods {
    public static final Food KOLBASA = (new Food.Builder()).nutrition(4).effect(new EffectInstance(Effects.POISON, 60, 1), 1.0F).build();
    public static final Food CONDENSED_MILK = (new Food.Builder()).nutrition(3).saturationMod(0.6F).build();

}

