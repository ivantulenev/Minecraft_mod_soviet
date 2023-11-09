package com.Soviet.sovietmod.item;

import com.Soviet.sovietmod.Sovietmod;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Sovietmod.MOD_ID);
    public static final RegistryObject<Item> FURNITURE = ITEMS.register("furniture",
            () -> new Item(new Item.Properties().tab(ModItemTab.FURNITURE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
