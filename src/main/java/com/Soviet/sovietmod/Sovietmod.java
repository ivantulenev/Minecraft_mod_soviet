package com.Soviet.sovietmod;

import com.Soviet.sovietmod.block.ModBlocks;
import com.Soviet.sovietmod.item.ModItems;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("sovietmod")
public class Sovietmod
{
    public static final String MOD_ID = "sovietmod";
    private static final Logger LOGGER = LogManager.getLogger();

    public Sovietmod()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(()->{});
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
    event.enqueueWork(()->{
        RenderTypeLookup.setRenderLayer(ModBlocks.CLOSET.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BREAD.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DINING_TABLE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.KETTLE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.VODKA.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.RADIATION_BANNER.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.RADIO.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.VINYL_RECORD_PLAYER.get(), RenderType.translucent());
    });
    }

}
