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
                    (new Item.Properties()).stacksTo(1).tab(ModItemTab.FURNITURE).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> KINO_GPUPA_KROVI = ITEMS.register("grupa_krovi",
            () -> new MusicDiscItem(1, ModSounds.KINO_GRUPA_KROVI,
                    (new Item.Properties()).stacksTo(1).tab(ModItemTab.FURNITURE).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> KINO_SPOKOINOGO_SNA = ITEMS.register("spokoinogo_sna",
            () -> new MusicDiscItem(1, ModSounds.KINO_SPOKOINOGO_SNA,
                    (new Item.Properties()).stacksTo(1).tab(ModItemTab.FURNITURE).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> KINO_PACHKA_SIGARET = ITEMS.register("pachka_sigaret",
            () -> new MusicDiscItem(1, ModSounds.KINO_PACHKA_SIGARET,
                    (new Item.Properties()).stacksTo(1).tab(ModItemTab.FURNITURE).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> KINO_KONCHITSA_LETO = ITEMS.register("konchitsa_leto",
            () -> new MusicDiscItem(1, ModSounds.KINO_KONCHITSA_LETO,
                    (new Item.Properties()).stacksTo(1).tab(ModItemTab.FURNITURE).rarity(Rarity.RARE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
