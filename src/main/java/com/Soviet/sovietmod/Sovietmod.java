package com.Soviet.sovietmod;

import com.Soviet.sovietmod.block.ModBlocks;
import com.Soviet.sovietmod.item.ModItems;
import com.Soviet.sovietmod.sound.ModSounds;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jline.keymap.KeyMap;

@Mod("sovietmod")
public class Sovietmod {
    public static final String MOD_ID = "sovietmod";

    public Sovietmod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModSounds.register(eventBus);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.CLOSET.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BREAD.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.DINING_TABLE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.KETTLE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.VODKA.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.RADIATION_BANNER.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.RADIO.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.VINYL_RECORD_PLAYER.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.DOUBLE_TABLE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.DOUBLE_RIGHT_TABLE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.VINYL_RECORD_PLAYER_KINO.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.PLATE.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.CONDENSED_MILK.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.CUT_GLASS.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.KOLBASA.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.SHOT_GLASS.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.CONCRETE_WASTE.get(), RenderType.cutout());
        });
    }

}
