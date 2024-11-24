package com.schrottii.fisecraft.items;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier ROOT = new ForgeTier(2, 16, 7.0F,
            1.0F, 40, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.ROOT.get()));

    public static final ForgeTier DIRE = new ForgeTier(2, 320, 20.0F,
            2.0F, 10, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.DIRE_SHARD.get()));
}