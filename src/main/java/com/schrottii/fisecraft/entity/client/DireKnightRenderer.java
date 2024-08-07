package com.schrottii.fisecraft.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.entity.custom.DireKnightEntity;
import com.schrottii.fisecraft.entity.custom.RootglassEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DireKnightRenderer extends GeoEntityRenderer<DireKnightEntity> {
    public DireKnightRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DireKnightModel());
        this.shadowRadius = 1.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(DireKnightEntity instance) {
        return new ResourceLocation(Fisecraft.MODID, "textures/entity/direknight.png");
    }

    @Override
    public RenderType getRenderType(DireKnightEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {

        stack.scale(1.5F, 2.25F, 1.5F);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}