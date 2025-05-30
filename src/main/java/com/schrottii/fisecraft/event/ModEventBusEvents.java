package com.schrottii.fisecraft.event;

import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.entity.ModEntityTypes;
import com.schrottii.fisecraft.entity.custom.DireKnightEntity;
import com.schrottii.fisecraft.entity.custom.EndeyeEntity;
import com.schrottii.fisecraft.entity.custom.RootglassEntity;
import com.schrottii.fisecraft.entity.custom.RootguardianEntity;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Fisecraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {

    }
    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {

    }
    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {

    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        // updateWhenNewEntity
        event.put(ModEntityTypes.ROOTGLASS.get(), RootglassEntity.setAttributes());
        event.put(ModEntityTypes.DIREKNIGHT.get(), DireKnightEntity.setAttributes());
        event.put(ModEntityTypes.ENDEYE.get(), EndeyeEntity.setAttributes());
        event.put(ModEntityTypes.ROOTGUARDIAN.get(), RootguardianEntity.setAttributes());
    }
}