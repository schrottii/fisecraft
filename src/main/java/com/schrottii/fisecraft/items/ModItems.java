package com.schrottii.fisecraft.items;

import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.ModCreativeTab;
import com.schrottii.fisecraft.entity.ModEntityTypes;
import com.schrottii.fisecraft.items.custom.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.schrottii.fisecraft.blocks.ModBlocks;

@Mod.EventBusSubscriber(modid = Fisecraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Fisecraft.MODID);

    public static final RegistryObject<Item> HONEYSQUASH = ITEMS.register("honeysquash",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.fisecraft)
                    .food(new FoodProperties.Builder().nutrition(10).saturationMod(6)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 150, 2), 0.5F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 50, 2), 0.5F).build())));

    public static final RegistryObject<Item> TELEPORT_FRUIT = ITEMS.register("enderfruit",
            () -> new TeleportStaff(new Item.Properties().tab(ModCreativeTab.fisecraft)
                    .food(new FoodProperties.Builder().nutrition(4).saturationMod(0)
                            .alwaysEat()
                            .build())));

    public static final RegistryObject<Item> ROOT = ITEMS.register("root",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.fisecraft)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1500, 0), 0.5F)
                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1500, 2), 1.0F)
                            .effect(() -> new MobEffectInstance(MobEffects.POISON, 1500, 4), 1.0F).build())));

    public static final RegistryObject<Item> ESCAPELEVATOR = ITEMS.register("escapelevator",
            () -> new ElevatorItem(new Item.Properties().tab(ModCreativeTab.fisecraft).stacksTo(1)));

    public static final RegistryObject<Item> DIGELEVATOR = ITEMS.register("digelevator",
            () -> new ElevatorItem2(new Item.Properties().tab(ModCreativeTab.fisecraft).stacksTo(1)));

    public static final RegistryObject<Item> ALOEE_VERA = ITEMS.register("aloee_vera",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.fisecraft)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0)
                            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 90, 1), 1.0F).build())));

    public static final RegistryObject<Item> BANDAGE = ITEMS.register("bandage",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.fisecraft)
                    .food(new FoodProperties.Builder().nutrition(0).saturationMod(0)
                            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1.0F).build())));

    public static final RegistryObject<Item> ROOT_SWORD = ITEMS.register("root_sword",
            () -> new RootSwordItem(ModTiers.ROOT, 5, -2.4f,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> ROOT_PICKAXE = ITEMS.register("root_pickaxe",
            () -> new PickaxeItem(ModTiers.ROOT, 3, -2.8f,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> ROOT_SHOVEL = ITEMS.register("root_shovel",
            () -> new ShovelItem(ModTiers.ROOT, 3.5f, -3,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> ROOT_AXE = ITEMS.register("root_axe",
            () -> new AxeItem(ModTiers.ROOT, 8, -3.1f,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> ROOT_HOE = ITEMS.register("root_hoe",
            () -> new HoeItem(ModTiers.ROOT, -1, -1,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));

    public static final RegistryObject<Item> ROOT_HELMET = ITEMS.register("root_helmet",
            () -> new ArmorItem(ModArmorMaterials.ROOT, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> ROOT_CHESTPLATE = ITEMS.register("root_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ROOT, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> ROOT_LEGGINGS = ITEMS.register("root_leggings",
            () -> new ArmorItem(ModArmorMaterials.ROOT, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> ROOT_BOOTS = ITEMS.register("root_boots",
            () -> new ArmorItem(ModArmorMaterials.ROOT, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));

    public static final RegistryObject<Item> KREMELO = ITEMS.register("kremelo",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> KREMELO_SEEDS = ITEMS.register("kremelo_seeds",
            () -> new ItemNameBlockItem(ModBlocks.KREMELO_PLANT.get(), new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> KREMELO_SOUP = ITEMS.register("kremelo_soup",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.fisecraft).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(7.2f).build())));
    public static final RegistryObject<Item> KREMELO_STICKS = ITEMS.register("kremelo_sticks",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.fisecraft)
                    .food(new FoodProperties.Builder().fast().nutrition(4).saturationMod(4).build())));

    // updateWhenNewEntity
    public static final RegistryObject<Item> ROOTGLASS_SPAWN_EGG = ITEMS.register("rootglass_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ROOTGLASS,0x74655C, 0xE2B57D,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> DIREKNIGHT_SPAWN_EGG = ITEMS.register("direknight_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DIREKNIGHT,0x1D0700, 0x850808,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> ENDEYE_SPAWN_EGG = ITEMS.register("endeye_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ENDEYE,0x7E3F78, 0x6C2139,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> ROOTGUARDIAN_SPAWN_EGG = ITEMS.register("rootguardian_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ROOTGUARDIAN,0x74655C, 0xE01818,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));

    public static final RegistryObject<Item> DIRE_PAIN_SWORD = ITEMS.register("dire_pain_sword",
            () -> new DirePainSwordItem(Tiers.DIAMOND, 4, -3.2f,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> DIRE_SHARD = ITEMS.register("dire_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> DIRERER = ITEMS.register("direrer",
            () -> new DirererItem(ModTiers.DIRE, 3, -2.8f,
                    new Item.Properties().tab(ModCreativeTab.fisecraft)));

    public static final RegistryObject<Item> GLASS_SHARD = ITEMS.register("glass_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> GLASS_SHARD_GOLDEN = ITEMS.register("glass_shard_golden",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> HOURGLASS_IDOL = ITEMS.register("hourglass_idol",
            () -> new HourglassIdolItem(new Item.Properties().tab(ModCreativeTab.fisecraft)));
    public static final RegistryObject<Item> FUNNY_HOURGLASS = ITEMS.register("funny_hourglass",
            () -> new HourglassFunnyItem(new Item.Properties().tab(ModCreativeTab.fisecraft)));

    public static final RegistryObject<Item> ENDFISE = ITEMS.register("endfise",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.fisecraft)));

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
