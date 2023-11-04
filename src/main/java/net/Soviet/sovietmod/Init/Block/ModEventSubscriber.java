package net.Soviet.sovietmod.Init.Block;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.ObjectHolder;
import net.Soviet.sovietmod.sovietmod;

@Mod.EventBusSubscriber(modid = sovietmod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber
{
    @ObjectHolder(sovietmod.MOD_ID)
    public static class ModBlocks {
        public static final Block closet = null;
    }

    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                new InitBlocks().setRegistryName(sovietmod.MOD_ID, "closet")
        );
    }

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new BlockItem(ModBlocks.closet, new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS))
                        .setRegistryName(sovietmod.MOD_ID, "closet")
        );
    }
}
