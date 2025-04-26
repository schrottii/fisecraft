package com.schrottii.fisecraft.blocks.custom;

import com.schrottii.fisecraft.items.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class AvyryaPlantBlock extends CropBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 4);

    public AvyryaPlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getMaxAge() {
        return 4;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.AVYRYA_SEEDS.get();
    }
}