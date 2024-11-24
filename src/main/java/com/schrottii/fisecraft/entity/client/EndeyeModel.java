package com.schrottii.fisecraft.entity.client;

import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.entity.custom.DireKnightEntity;
import com.schrottii.fisecraft.entity.custom.EndeyeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EndeyeModel extends AnimatedGeoModel<EndeyeEntity> {
    @Override
    public ResourceLocation getModelLocation(EndeyeEntity object) {
        return new ResourceLocation(Fisecraft.MODID, "geo/endeye.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EndeyeEntity object) {
        return new ResourceLocation(Fisecraft.MODID, "textures/entity/endeye.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EndeyeEntity animatable) {
        return new ResourceLocation(Fisecraft.MODID, "animations/endeye.animation.json");
    }
}