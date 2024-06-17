package com.schrottii.fisecraft.blocks;

import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.ModCreativeTab;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Fisecraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BLOCKS.getEntries().stream().map(RegistryObject::get).forEach( (block) -> {
            final Item.Properties properties = new Item.Properties().tab(ModCreativeTab.fisecraft);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Fisecraft.MODID);

    public static final RegistryObject<Block> SHADOWFLOWER = BLOCKS.register("shadowflower",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 120,  Block.Properties.of(Material.PLANT).strength(0.5f, 1f).speedFactor(0.6f).noCollission()));

    public static final RegistryObject<Block> LIGHTFLOWER = BLOCKS.register("lightflower",
            () -> new FlowerBlock(MobEffects.NIGHT_VISION, 120,  Block.Properties.of(Material.PLANT).strength(0.2f, 1f).lightLevel((state) -> 6).speedFactor(1.2f).noCollission()));

    public static final RegistryObject<Block> ROOTS = BLOCKS.register("roots",
            () -> new GrassBlock(Block.Properties.of(Material.STONE).strength(0.8f, 1f).speedFactor(0.2f).noCollission()));

    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
