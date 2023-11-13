package com.Soviet.sovietmod.item;

import com.Soviet.sovietmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemTab {
    public static final ItemGroup FURNITURE = new ItemGroup("sovietModTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.VODKA.get());
        }
    };
}
