package com.schrottii.fisecraft;

import com.schrottii.fisecraft.blocks.ModBlocks;
import com.schrottii.fisecraft.entity.ModEntityTypes;
import com.schrottii.fisecraft.entity.client.DireKnightRenderer;
import com.schrottii.fisecraft.entity.client.EndeyeRenderer;
import com.schrottii.fisecraft.entity.client.RootglassRenderer;
import com.schrottii.fisecraft.entity.client.RootguardianRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class SetupRenders {
    public static void BlockRenders(){
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SHADOWFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHTFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROOTS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ALOEE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.KREMELO_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.AVYRYA_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SMOOTH_ROOT_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SMOOTH_ROOT_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROOTGUARDIAN_TROPHY.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROOT_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROOT_TRAPDOOR.get(), RenderType.translucent());
    }

    public static void EntityRenders(){
        // updateWhenNewEntity
        EntityRenderers.register(ModEntityTypes.ROOTGLASS.get(), RootglassRenderer::new);
        EntityRenderers.register(ModEntityTypes.DIREKNIGHT.get(), DireKnightRenderer::new);
        EntityRenderers.register(ModEntityTypes.ENDEYE.get(), EndeyeRenderer::new);
        EntityRenderers.register(ModEntityTypes.ROOTGUARDIAN.get(), RootguardianRenderer::new);
    }
}
