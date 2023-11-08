package net.Soviet.sovietmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemTab {
    public static final ItemGroup FURNITURE = new ItemGroup("sovietModTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FURNITURE.get());
        }
    };
}
