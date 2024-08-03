package com.schrottii.fisecraft;

import com.schrottii.fisecraft.entity.ModEntityTypes;
import com.schrottii.fisecraft.event.ModEventBusEvents;
import com.schrottii.fisecraft.items.ModItems;
import com.schrottii.fisecraft.blocks.ModBlocks;
import com.mojang.logging.LogUtils;
import com.schrottii.fisecraft.util.BetterBrewingRecipe;
import com.schrottii.fisecraft.world.feature.ModConfiguredFeatures;
import com.schrottii.fisecraft.world.feature.ModPlacedFeatures;
import com.schrottii.fisecraft.entity.client.RootglassRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("fisecraft")
public class Fisecraft
{

    // Directly reference a slf4j logger
    public static final String MODID = "fisecraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Fisecraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModEnchantments.ENCHANTMENTS.register(modEventBus);
        ModEntityTypes.register(modEventBus);

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

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup (final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SHADOWFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHTFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROOTS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ALOEE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.KREMELO_PLANT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROOT_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROOT_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SMOOTH_ROOT_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SMOOTH_ROOT_TRAPDOOR.get(), RenderType.cutout());

        EntityRenderers.register(ModEntityTypes.ROOTGLASS.get(), RootglassRenderer::new);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    ModItems.ALOEE_VERA.get(), Potions.REGENERATION));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    ModItems.ROOT.get(), Potions.POISON));
        });
    }
}
