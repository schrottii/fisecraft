package com.schrottii.fisecraft.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.entity.custom.RootglassEntity;
import com.schrottii.fisecraft.entity.custom.RootguardianEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RootguardianRenderer extends GeoEntityRenderer<RootguardianEntity> {
    public RootguardianRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RootguardianModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(RootguardianEntity instance) {
        return new ResourceLocation(Fisecraft.MODID, "textures/entity/rootguardian.png");
    }

    @Override
    public RenderType getRenderType(RootguardianEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {

        stack.scale(4.2F, 4.5F, 4.2F);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}