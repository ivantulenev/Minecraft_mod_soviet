package com.Soviet.sovietmod.block;

import com.Soviet.sovietmod.Sovietmod;
import com.Soviet.sovietmod.item.ModItemTab;
import com.Soviet.sovietmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, Sovietmod.MOD_ID);
    public static final RegistryObject<Block> CLOSET = registerBlock("closet",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModItemTab.FURNITURE)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
