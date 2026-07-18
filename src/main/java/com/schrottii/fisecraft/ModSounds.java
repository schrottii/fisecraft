package com.schrottii.fisecraft;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Fisecraft.MODID);

    public static final RegistryObject<SoundEvent> BOSS_MUSIC = SOUNDS.register("boss_music",
            () -> new SoundEvent(new ResourceLocation(Fisecraft.MODID, "boss_music")));
}