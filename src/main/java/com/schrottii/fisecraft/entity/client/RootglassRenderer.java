package com.schrottii.fisecraft.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.entity.custom.RootglassEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RootglassRenderer extends GeoEntityRenderer<RootglassEntity> {
    public RootglassRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RootglassModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(RootglassEntity instance) {
        return new ResourceLocation(Fisecraft.MODID, "textures/entity/rootglass.png");
    }

    @Override
    public RenderType getRenderType(RootglassEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}