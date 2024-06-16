package com.schrottii.fisecraft.items;

import com.schrottii.fisecraft.Fisecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Fisecraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Fisecraft.MODID);

    public static final RegistryObject<Item> CUSTOM_ITEM = ITEMS.register("honeysquash",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(20)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 150, 2), 0.5F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 50, 2), 0.5F).build())));

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
