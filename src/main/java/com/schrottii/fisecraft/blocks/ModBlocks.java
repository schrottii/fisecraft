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

    public static final RegistryObject<Block> BLOCK_OF_ROOTS = BLOCKS.register("block_of_roots",
            () -> new Block(Block.Properties.of(Material.STONE).strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHISELED_BLOCK_OF_ROOTS = BLOCKS.register("chiseled_block_of_roots",
            () -> new Block(Block.Properties.of(Material.STONE).strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SHINY_BLOCK_OF_ROOTS = BLOCKS.register("shiny_block_of_roots",
            () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 1200f).requiresCorrectToolForDrops().lightLevel((state) -> 9)));
    public static final RegistryObject<Block> ROUGH_BLOCK_OF_ROOTS = BLOCKS.register("rough_block_of_roots",
            () -> new Block(Block.Properties.of(Material.STONE).strength(4f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_BLOCK_OF_ROOTS = BLOCKS.register("smooth_block_of_roots",
            () -> new Block(Block.Properties.of(Material.STONE).strength(2f, 1200f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ROOT_STAIRS = BLOCKS.register("root_stairs",
            () -> new StairBlock(() -> ModBlocks.BLOCK_OF_ROOTS.get().defaultBlockState(), Block.Properties.of(Material.STONE)
                    .strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ROOT_SLAB = BLOCKS.register("root_slab",
            () -> new SlabBlock(Block.Properties.of(Material.STONE)
                    .strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ROOT_WALL = BLOCKS.register("root_wall",
            () -> new WallBlock(Block.Properties.of(Material.STONE)
                    .strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ROOT_DOOR = BLOCKS.register("root_door",
            () -> new DoorBlock(Block.Properties.of(Material.WOOD)
                    .strength(2f, 1200f).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ROOT_TRAPDOOR = BLOCKS.register("root_trapdoor",
            () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD)
                    .strength(2f, 1200f).noOcclusion().requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SMOOTH_ROOT_STAIRS = BLOCKS.register("smooth_root_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_BLOCK_OF_ROOTS.get().defaultBlockState(), Block.Properties.of(Material.STONE)
                    .strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_ROOT_SLAB = BLOCKS.register("smooth_root_slab",
            () -> new SlabBlock(Block.Properties.of(Material.STONE)
                    .strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_ROOT_WALL = BLOCKS.register("smooth_root_wall",
            () -> new WallBlock(Block.Properties.of(Material.STONE)
                    .strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_ROOT_DOOR = BLOCKS.register("smooth_root_door",
            () -> new DoorBlock(Block.Properties.of(Material.WOOD)
                    .strength(2f, 1200f).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_ROOT_TRAPDOOR = BLOCKS.register("smooth_root_trapdoor",
            () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD)
                    .strength(2f, 1200f).noOcclusion().requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LAYERED_BLOCK_OF_IRON = BLOCKS.register("layered_block_of_iron",
            () -> new Block(Block.Properties.of(Material.STONE).strength(8f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AIRPLANE_BLOCK = BLOCKS.register("airplane_block",
            () -> new AirplaneBlock(Block.Properties.of(Material.STONE).strength(8f, 1200f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALOEE = BLOCKS.register("aloee",
            () -> new FlowerBlock(MobEffects.REGENERATION, 60,  Block.Properties.of(Material.PLANT).strength(0.05f, 1f).noCollission()));
/*
    public static final RegistryObject<Block> LUCKY_COLOR_BLOCK = BLOCKS.register("lucky_color_block",
            () -> new Block(Block.Properties.of(Material.STONE).strength(2f, 1200f)));
*/



    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
