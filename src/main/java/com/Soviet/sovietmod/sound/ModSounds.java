package com.Soviet.sovietmod.sound;

import com.Soviet.sovietmod.Sovietmod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "sovietmod");
    public static final RegistryObject<SoundEvent> KINO_PEREMEN = registerSoundEvent("kino_peremen");
    public static final RegistryObject<SoundEvent> KINO_GRUPA_KROVI = registerSoundEvent("grupa_krovi");
    public static final RegistryObject<SoundEvent> KINO_SPOKOINOGO_SNA = registerSoundEvent("spokoinogo_sna");
    public static final RegistryObject<SoundEvent> KINO_PACHKA_SIGARET = registerSoundEvent("pachka_sigaret");
    public static final RegistryObject<SoundEvent> KINO_KONCHITSA_LETO = registerSoundEvent("konchitsa_leto");

    public static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Sovietmod.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
