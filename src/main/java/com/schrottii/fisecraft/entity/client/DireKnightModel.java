package com.schrottii.fisecraft.entity.client;

import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.entity.custom.DireKnightEntity;
import com.schrottii.fisecraft.entity.custom.RootglassEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DireKnightModel extends AnimatedGeoModel<DireKnightEntity> {
    @Override
    public ResourceLocation getModelLocation(DireKnightEntity object) {
        return new ResourceLocation(Fisecraft.MODID, "geo/direknight.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DireKnightEntity object) {
        return new ResourceLocation(Fisecraft.MODID, "textures/entity/direknight.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(DireKnightEntity animatable) {
        return new ResourceLocation(Fisecraft.MODID, "animations/direknight.animation.json");
    }
}