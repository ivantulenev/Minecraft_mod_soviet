package net.Soviet.sovietmod.Init.Block;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class InitBlocks extends Block
{
    public InitBlocks() {
        super(Properties.of(Material.WOOD) // Материал блока (замените на необходимый)
                .strength(2.0F, 5.0F)); // Жёсткость и устойчивость блока
    }


}


