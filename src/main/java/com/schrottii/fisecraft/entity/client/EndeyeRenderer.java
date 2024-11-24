package com.schrottii.fisecraft.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.entity.custom.DireKnightEntity;
import com.schrottii.fisecraft.entity.custom.EndeyeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class EndeyeRenderer extends GeoEntityRenderer<EndeyeEntity> {
    public EndeyeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EndeyeModel());
        this.shadowRadius = 1.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(EndeyeEntity instance) {
        return new ResourceLocation(Fisecraft.MODID, "textures/entity/endeye.png");
    }

    @Override
    public RenderType getRenderType(EndeyeEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {

        stack.scale(2.0F, 2.0F, 2.0F);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}