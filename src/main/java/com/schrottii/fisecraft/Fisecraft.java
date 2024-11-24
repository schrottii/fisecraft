package com.schrottii.fisecraft;

import com.schrottii.fisecraft.config.FisecraftClientConfigs;
import com.schrottii.fisecraft.config.FisecraftCommonConfigs;
import com.schrottii.fisecraft.entity.ModEntityTypes;
import com.schrottii.fisecraft.entity.client.DireKnightRenderer;
import com.schrottii.fisecraft.entity.client.EndeyeRenderer;
import com.schrottii.fisecraft.entity.client.RootguardianRenderer;
import com.schrottii.fisecraft.entity.custom.DireKnightEntity;
import com.schrottii.fisecraft.entity.custom.EndeyeEntity;
import com.schrottii.fisecraft.entity.custom.RootglassEntity;
import com.schrottii.fisecraft.event.ModEventBusEvents;
import com.schrottii.fisecraft.items.ModItems;
import com.schrottii.fisecraft.blocks.ModBlocks;
import com.mojang.logging.LogUtils;
import com.schrottii.fisecraft.util.BetterBrewingRecipe;
import com.schrottii.fisecraft.util.ModTags;
import com.schrottii.fisecraft.world.feature.ModConfiguredFeatures;
import com.schrottii.fisecraft.world.feature.ModPlacedFeatures;
import com.schrottii.fisecraft.entity.client.RootglassRenderer;
import com.schrottii.fisecraft.world.structure.ModStructures;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.Registry;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;
import net.minecraftforge.fml.ModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("fisecraft")
public class Fisecraft
{

    // Directly reference a slf4j logger
    public static final String MODID = "fisecraft";
    public static final Logger LOGGER = LogManager.getLogger();

    public Fisecraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModEnchantments.ENCHANTMENTS.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        ModStructures.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);

        try {
            // Code that might throw an exception
            GeckoLib.initialize();
        } catch (Exception e) {
            // Log the original error if needed
            e.printStackTrace();

            // Throw a new exception with a custom message
            throw new RuntimeException("Error: Geckolib is not installed", e);
        }

        //ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, FisecraftClientConfigs.SPEC, "fisecraft-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FisecraftCommonConfigs.SPEC, "fisecraft-common.toml");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup (final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SHADOWFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHTFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROOTS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ALOEE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.KREMELO_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SMOOTH_ROOT_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SMOOTH_ROOT_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROOTGUARDIAN_TROPHY.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROOT_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROOT_TRAPDOOR.get(), RenderType.translucent());

        // updateWhenNewEntity
        EntityRenderers.register(ModEntityTypes.ROOTGLASS.get(), RootglassRenderer::new);
        EntityRenderers.register(ModEntityTypes.DIREKNIGHT.get(), DireKnightRenderer::new);
        EntityRenderers.register(ModEntityTypes.ENDEYE.get(), EndeyeRenderer::new);
        EntityRenderers.register(ModEntityTypes.ROOTGUARDIAN.get(), RootguardianRenderer::new);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    ModItems.ALOEE_VERA.get(), Potions.REGENERATION));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    ModItems.ROOT.get(), Potions.POISON));

            //ModEntityTypes.placeSpawns();
            // updateWhenNewEntity
            SpawnPlacements.register(ModEntityTypes.ROOTGLASS.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    RootglassEntity::checkRootglassSpawnRules);

            SpawnPlacements.register(ModEntityTypes.DIREKNIGHT.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    DireKnightEntity::checkDireKnightSpawnRules);

            SpawnPlacements.register(ModEntityTypes.ENDEYE.get(),
                    SpawnPlacements.Type.NO_RESTRICTIONS,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    EndeyeEntity::checkEndeyeSpawnRules);

            // ROOTGUARDIAN does not spawn naturally
        });
    }
}
