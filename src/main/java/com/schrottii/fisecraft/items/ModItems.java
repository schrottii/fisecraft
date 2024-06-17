package com.schrottii.fisecraft.items;

import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.ModCreativeTab;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
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
            () -> new Item(new Item.Properties().tab(ModCreativeTab.fisecraft)
                    .food(new FoodProperties.Builder().nutrition(10).saturationMod(6)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 150, 2), 0.5F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 50, 2), 0.5F).build())));

    public static final RegistryObject<Item> TELEPORT_FRUIT = ITEMS.register("enderfruit",
            () -> new TeleportStaff(new Item.Properties().tab(ModCreativeTab.fisecraft)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(0)
                            .alwaysEat()
                            .build())));

    public static final RegistryObject<Item> ROOT = ITEMS.register("root",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.fisecraft)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3000, 0), 0.5F)
                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3000, 2), 1.0F)
                            .effect(() -> new MobEffectInstance(MobEffects.POISON, 3000, 4), 1.0F).build())));

    public static final RegistryObject<Item> ESCAPELEVATOR = ITEMS.register("escapelevator",
            () -> new ElevatorItem(new Item.Properties().tab(ModCreativeTab.fisecraft).stacksTo(1)));

    public static final RegistryObject<Item> DIGELEVATOR = ITEMS.register("digelevator",
            () -> new ElevatorItem2(new Item.Properties().tab(ModCreativeTab.fisecraft).stacksTo(1)));





    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
