package com.deepocean.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.SquidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.GlowSquidRenderer;
import net.minecraft.world.entity.animal.GlowSquid;

/** Reuses the vanilla glow squid model and texture, drawn 4x bigger. */
public class GiantSquidRenderer extends GlowSquidRenderer {

    public GiantSquidRenderer(EntityRendererProvider.Context context) {
        super(context, new SquidModel<>(context.bakeLayer(ModelLayers.GLOW_SQUID)));
    }

    @Override
    protected void scale(GlowSquid squid, PoseStack poseStack, float partialTick) {
        poseStack.scale(4.0F, 4.0F, 4.0F);
    }
}
