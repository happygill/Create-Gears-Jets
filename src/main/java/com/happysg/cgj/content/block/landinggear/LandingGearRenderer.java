package com.happysg.cgj.content.block.landinggear;

import com.jozufozu.flywheel.backend.Backend;
import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.foundation.blockEntity.renderer.SafeBlockEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class LandingGearRenderer extends SafeBlockEntityRenderer<LandingGearBlockEntity> {
    public LandingGearRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected void renderSafe(LandingGearBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource bufferSource, int light, int overlay) {
        if (Backend.canUseInstancing(be.getLevel())) return;

        //TODO add Wheels and axles
    }
}
