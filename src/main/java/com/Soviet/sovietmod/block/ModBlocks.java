package com.Soviet.sovietmod.block;

import com.Soviet.sovietmod.Sovietmod;
import com.Soviet.sovietmod.block.custom.*;
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
            () -> new ClosetBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> BREAD = registerBlock("bread",
            () -> new BreadBlock(AbstractBlock.Properties.of(Material.CAKE)));
    public static final RegistryObject<Block> DINING_TABLE = registerBlock("dining_table",
            () -> new DiningTableBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> KETTLE = registerBlock("kettle",
            () -> new KettleBlock(AbstractBlock.Properties.of(Material.METAL)));
    public static final RegistryObject<Block> VODKA = registerBlock("vodka",
            () -> new VodkaBlock(AbstractBlock.Properties.of(Material.GLASS)));

    public static final RegistryObject<Block> RADIATION_BANNER = registerBlock("radiation_banner",
            () -> new RadiationBannerBlock(AbstractBlock.Properties.of(Material.METAL)));

    public static final RegistryObject<Block> RADIO = registerBlock("radio",
            () -> new RadioGorizontBlock(AbstractBlock.Properties.of(Material.WOOD)));

    public static final RegistryObject<Block> VINYL_RECORD_PLAYER = registerBlock("vinyl_record_player2",
            () -> new VinylRecordPlayerBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> VINYL_RECORD_PLAYER_KINO = registerBlock("vinyl_record_player_kino",
            () -> new VinylRecordPlayerKinoBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> DOUBLE_TABLE = registerBlock("double_table",
            () -> new DoubleTableBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> DOUBLE_RIGHT_TABLE = registerBlock("double_right_table",
            () -> new DoubleTableRightBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> PLATE = registerBlock("plate",
            () -> new PlateBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> CONDENSED_MILK = registerBlock("can_of_condensed_milk",
            () -> new CondensedMilkBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> CUT_GLASS = registerBlock("cut_glass",
            () -> new CutGlassBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> KOLBASA = registerBlock("kolbasa",
            () -> new KolbasaBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> SHOT_GLASS = registerBlock("shot_glass",
            () -> new ShotGlassBlock(AbstractBlock.Properties.of(Material.WOOD)));

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
