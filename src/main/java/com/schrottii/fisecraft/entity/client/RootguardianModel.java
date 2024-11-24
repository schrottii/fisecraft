package com.schrottii.fisecraft.entity.client;

import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.entity.custom.RootglassEntity;
import com.schrottii.fisecraft.entity.custom.RootguardianEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RootguardianModel extends AnimatedGeoModel<RootguardianEntity> {
    @Override
    public ResourceLocation getModelLocation(RootguardianEntity object) {
        return new ResourceLocation(Fisecraft.MODID, "geo/rootguardian.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(RootguardianEntity object) {
        return new ResourceLocation(Fisecraft.MODID, "textures/entity/rootguardian.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(RootguardianEntity animatable) {
        return new ResourceLocation(Fisecraft.MODID, "animations/rootguardian.animation.json");
    }
}