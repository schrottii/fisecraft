package com.schrottii.fisecraft.world.feature;

import com.schrottii.fisecraft.blocks.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static net.minecraft.data.worldgen.features.CaveFeatures.MOSS_VEGETATION;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SHADOWFLOWER =
            FeatureUtils.register("shadowflower", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SHADOWFLOWER.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> LIGHTFLOWER =
            FeatureUtils.register("lightflower", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LIGHTFLOWER.get())))));

    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> ROOTS =
            FeatureUtils.register("roots", Feature.VEGETATION_PATCH,
                    new VegetationPatchConfiguration(BlockTags.STONE_ORE_REPLACEABLES, BlockStateProvider.simple(ModBlocks.ROOTS.get()), PlacementUtils.inlinePlaced(MOSS_VEGETATION), CaveSurface.CEILING, ConstantInt.of(1), 0.0F, 8, 0.0F, UniformInt.of(2, 8), 0.6F));

    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> BLOCK_OF_ROOTS2 =
            FeatureUtils.register("block_of_roots2", Feature.VEGETATION_PATCH,
                    new VegetationPatchConfiguration(BlockTags.STONE_ORE_REPLACEABLES, BlockStateProvider.simple(ModBlocks.BLOCK_OF_ROOTS.get()), PlacementUtils.inlinePlaced(MOSS_VEGETATION), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 16, 0.0F, UniformInt.of(8, 16), 0.6F));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ALOEE =
            FeatureUtils.register("aloee", Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ALOEE.get())))));
/*
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> LUCKY_COLOR_BLOCK =
            FeatureUtils.register("lucky_color_block", Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LUCKY_COLOR_BLOCK.get())));
*/
}