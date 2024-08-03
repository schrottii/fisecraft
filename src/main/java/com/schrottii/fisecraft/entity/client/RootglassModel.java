package com.schrottii.fisecraft.entity.client;

import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.entity.custom.RootglassEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RootglassModel extends AnimatedGeoModel<RootglassEntity> {
    @Override
    public ResourceLocation getModelLocation(RootglassEntity object) {
        return new ResourceLocation(Fisecraft.MODID, "geo/rootglass.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(RootglassEntity object) {
        return new ResourceLocation(Fisecraft.MODID, "textures/entity/rootglass.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(RootglassEntity animatable) {
        return new ResourceLocation(Fisecraft.MODID, "animations/rootglass.animation.json");
    }
}