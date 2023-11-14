package com.Soviet.sovietmod.item;

import com.Soviet.sovietmod.Sovietmod;
import com.Soviet.sovietmod.sound.ModSounds;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;
import net.minecraft.util.datafix.fixes.JukeboxRecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Sovietmod.MOD_ID);
    public static final RegistryObject<Item> KINO_PEREMEN_DISC = ITEMS.register("kino_peremen",
            () -> new MusicDiscItem(1, ModSounds.KINO_PEREMEN,
                    (new Item.Properties()).stacksTo(1).rarity(Rarity.RARE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
