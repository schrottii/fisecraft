package com.schrottii.fisecraft.world.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> SHADOWFLOWER_PLACED = PlacementUtils.register("shadowflower",
            ModConfiguredFeatures.SHADOWFLOWER, RarityFilter.onAverageOnceEvery(8),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> LIGHTFLOWER_PLACED = PlacementUtils.register("lightflower",
            ModConfiguredFeatures.LIGHTFLOWER, RarityFilter.onAverageOnceEvery(8),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> ROOTS_PLACED = PlacementUtils.register("roots",
            ModConfiguredFeatures.ROOTS, RarityFilter.onAverageOnceEvery(4),
            InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());

    public static final Holder<PlacedFeature> BLOCK_OF_ROOTS_PLACED2 = PlacementUtils.register("block_of_roots2",
            ModConfiguredFeatures.BLOCK_OF_ROOTS2, RarityFilter.onAverageOnceEvery(8),
            InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-25), VerticalAnchor.absolute(-50)), BiomeFilter.biome());

    public static final Holder<PlacedFeature> ALOEE_PLACED = PlacementUtils.register("aloee",
            ModConfiguredFeatures.ALOEE, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    public static final Holder<PlacedFeature> ZERULL_ORE_PLACED = PlacementUtils.register("zerull_ore_placed",
            ModConfiguredFeatures.ZERULL_ORE, ModOrePlacement.commonOrePlacement(3, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(1))));

/*
    public static final Holder<PlacedFeature> LUCKY_COLOR_BLOCK_PLACED = PlacementUtils.register("lucky_color_block",
            ModConfiguredFeatures.LUCKY_COLOR_BLOCK, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
*/

}