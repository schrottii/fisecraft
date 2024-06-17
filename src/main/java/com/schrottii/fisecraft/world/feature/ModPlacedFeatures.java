package com.schrottii.fisecraft.world.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
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

    public static final Holder<PlacedFeature> BLOCK_OF_ROOTS_PLACED = PlacementUtils.register("block_of_roots",
            ModConfiguredFeatures.BLOCK_OF_ROOTS, RarityFilter.onAverageOnceEvery(2),
            InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());


}