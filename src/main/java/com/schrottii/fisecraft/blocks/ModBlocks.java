package com.schrottii.fisecraft.blocks;

import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.ModCreativeTab;
import com.schrottii.fisecraft.blocks.custom.*;
import com.schrottii.fisecraft.items.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

@Mod.EventBusSubscriber(modid = Fisecraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Fisecraft.MODID);

    public static final RegistryObject<Block> SHADOWFLOWER = registerBlock("shadowflower",
            () -> new CustomFlowerBlock(MobEffects.BLINDNESS, 120,  Block.Properties.of(Material.PLANT).strength(0.5f, 1f).speedFactor(0.6f).noCollission()));
    public static final RegistryObject<Block> LIGHTFLOWER = registerBlock("lightflower",
            () -> new CustomFlowerBlock(MobEffects.NIGHT_VISION, 120,  Block.Properties.of(Material.PLANT).strength(0.2f, 1f).lightLevel((state) -> 6).speedFactor(1.2f).noCollission()));

    public static final RegistryObject<Block> ROOTS = registerBlock("roots",
            () -> new GrassBlock(Block.Properties.of(Material.STONE).strength(0.8f, 1f).speedFactor(0.2f).noCollission()));

    public static final RegistryObject<Block> BLOCK_OF_ROOTS = registerBlock("block_of_roots",
            () -> new Block(Block.Properties.of(Material.STONE).strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHISELED_BLOCK_OF_ROOTS = registerBlock("chiseled_block_of_roots",
            () -> new Block(Block.Properties.of(Material.STONE).strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SHINY_BLOCK_OF_ROOTS = registerBlock("shiny_block_of_roots",
            () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 1200f).requiresCorrectToolForDrops().lightLevel((state) -> 9)));
    public static final RegistryObject<Block> ROUGH_BLOCK_OF_ROOTS = registerBlock("rough_block_of_roots",
            () -> new Block(Block.Properties.of(Material.STONE).strength(4f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_BLOCK_OF_ROOTS = registerBlock("smooth_block_of_roots",
            () -> new Block(Block.Properties.of(Material.STONE).strength(2f, 1200f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ROOT_STAIRS = registerBlock("root_stairs",
            () -> new StairBlock(() -> ModBlocks.BLOCK_OF_ROOTS.get().defaultBlockState(), Block.Properties.of(Material.STONE)
                    .strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ROOT_SLAB = registerBlock("root_slab",
            () -> new SlabBlock(Block.Properties.of(Material.STONE)
                    .strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ROOT_WALL = registerBlock("root_wall",
            () -> new WallBlock(Block.Properties.of(Material.STONE)
                    .strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ROOT_DOOR = registerBlock("root_door",
            () -> new DoorBlock(Block.Properties.of(Material.WOOD)
                    .strength(2f, 1200f).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ROOT_TRAPDOOR = registerBlock("root_trapdoor",
            () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD)
                    .strength(2f, 1200f).noOcclusion().requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SMOOTH_ROOT_STAIRS = registerBlock("smooth_root_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_BLOCK_OF_ROOTS.get().defaultBlockState(), Block.Properties.of(Material.STONE)
                    .strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_ROOT_SLAB = registerBlock("smooth_root_slab",
            () -> new SlabBlock(Block.Properties.of(Material.STONE)
                    .strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_ROOT_WALL = registerBlock("smooth_root_wall",
            () -> new WallBlock(Block.Properties.of(Material.STONE)
                    .strength(2f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_ROOT_DOOR = registerBlock("smooth_root_door",
            () -> new DoorBlock(Block.Properties.of(Material.WOOD)
                    .strength(2f, 1200f).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_ROOT_TRAPDOOR = registerBlock("smooth_root_trapdoor",
            () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD)
                    .strength(2f, 1200f).noOcclusion().requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LAYERED_BLOCK_OF_IRON = registerBlock("layered_block_of_iron",
            () -> new Block(Block.Properties.of(Material.STONE).strength(8f, 1200f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AIRPLANE_BLOCK = registerBlock("airplane_block",
            () -> new AirplaneBlock(Block.Properties.of(Material.STONE).strength(8f, 1200f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALOEE = registerBlock("aloee",
            () -> new CustomFlowerBlock(MobEffects.REGENERATION, 60,  Block.Properties.of(Material.PLANT).strength(0.05f, 1f).noCollission()));
    public static final RegistryObject<Block> ALOEE_BLOCK = registerBlock("aloee_block",
            () -> new Block(Block.Properties.of(Material.PLANT).strength(0.1f, 400f)));

    public static final RegistryObject<Block> SHADOWFLOWER_LAMP = registerBlock("shadowflower_lamp",
            () -> new RedstoneLampBlock(BlockBehaviour.Properties.of(Material.BUILDABLE_GLASS).lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> LIGHTFLOWER_LAMP = registerBlock("lightflower_lamp",
            () -> new RedstoneLampBlock(BlockBehaviour.Properties.of(Material.BUILDABLE_GLASS).lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> ROOT_BARREL = registerBlock("root_barrel",
            () -> new BarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> KREMELO_PLANT = registerBlockWithoutBlockItem("kremelo_plant",
            () -> new KremeloPlantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> KREMELO_BLOCK = registerBlock("kremelo_block",
            () -> new Block(Block.Properties.of(Material.PLANT).strength(0.3f, 1200f)));
    public static final RegistryObject<Block> KREMELO_BLOCK_SMOOTH = registerBlock("kremelo_block_smooth",
            () -> new Block(Block.Properties.of(Material.PLANT).strength(0.3f, 1200f)));

    public static final RegistryObject<Block> AVYRYA_PLANT = registerBlockWithoutBlockItem("avyrya_plant",
            () -> new AvyryaPlantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> AVYRYA_BLOCK = registerBlock("avyrya_block",
            () -> new Block(Block.Properties.of(Material.PLANT).strength(0.3f, 1200f)));
    public static final RegistryObject<Block> AVYRYA_BLOCK_SMOOTH = registerBlock("avyrya_block_smooth",
            () -> new Block(Block.Properties.of(Material.PLANT).strength(0.3f, 1200f)));
    /*
    public static final RegistryObject<Block> LUCKY_COLOR_BLOCK = registerBlock("lucky_color_block",
            () -> new Block(Block.Properties.of(Material.STONE).strength(2f, 1200f)));
*/

    public static final RegistryObject<Block> PAIN_BLOCK = registerBlock("pain_block",
            () -> new PainBlock(Block.Properties.of(Material.MOSS).strength(3.0f, 400f)));
    public static final RegistryObject<Block> HATE_BLOCK = registerBlock("hate_block",
            () -> new PainBlock(Block.Properties.of(Material.MOSS).strength(3.0f, 400f)));
    public static final RegistryObject<Block> PAIN_BLOCK_PAINLESS = registerBlock("pain_block_painless",
            () -> new Block(Block.Properties.of(Material.MOSS).strength(1.0f, 400f)));
    public static final RegistryObject<Block> HATE_BLOCK_HATELESS = registerBlock("hate_block_hateless",
            () -> new Block(Block.Properties.of(Material.MOSS).strength(1.0f, 400f)));
    public static final RegistryObject<Block> GLASSY_SAND = registerBlock("glassy_sand",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).strength(0.5F).sound(SoundType.SAND)));

    public static final RegistryObject<Block> ROOTGUARDIAN_TROPHY = registerBlock("rootguardian_trophy",
            () -> new TrophyBlock(Block.Properties.of(Material.STONE).strength(1.0f, 400f).noOcclusion()));

    public static final RegistryObject<Block> BLOCK_OF_ENDFISE = registerBlock("block_of_endfise",
            () -> new Block(Block.Properties.of(Material.PLANT).strength(0.3f, 2f)));
    public static final RegistryObject<Block> ENDFISE_STONE = registerBlock("endfise_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));

    public static final RegistryObject<Block> ZERULL_ORE = registerBlock("zerull_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(12.0F, 3.0F), UniformInt.of(12, 16)));
    public static final RegistryObject<Block> ZERULL_ORE_DEEPSLATE = registerBlock("zerull_ore_deepslate",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(12.0F, 3.0F), UniformInt.of(12, 16)));
    public static final RegistryObject<Block> BLOCK_OF_ZERULL = registerBlock("block_of_zerull",
            () -> new Block(Block.Properties.of(Material.PLANT).strength(6f, 20f)));







    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, ModCreativeTab.fisecraft);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? p_50760_ : 0;
        };
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
