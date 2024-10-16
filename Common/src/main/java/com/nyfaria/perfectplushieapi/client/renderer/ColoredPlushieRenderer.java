package com.nyfaria.perfectplushieapi.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nyfaria.perfectplushieapi.block.entity.ColoredPlushieBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ColoredPlushieRenderer extends GeoBlockRenderer<ColoredPlushieBlockEntity> {
    public ColoredPlushieRenderer(ResourceLocation model) {
        super(new DefaultedBlockGeoModel<>(model));
    }

    @Override
    public void renderRecursively(PoseStack poseStack, ColoredPlushieBlockEntity animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (animatable.colorCount() > 0) {
            int redx = animatable.getRed(0);
            int greenx = animatable.getGreen(0);
            int bluex = animatable.getBlue(0);
            if (animatable.colorCount() > 1) {
                for (int i = 1; i <= animatable.colorCount(); i++) {
                    if (bone.getName().contains("color" + i)) {
                        redx = animatable.getRed(i - 1);
                        greenx = animatable.getGreen(i - 1);
                        bluex = animatable.getBlue(i - 1);
                    }
                }
            }
            super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, redx / 255f, greenx / 255f, bluex / 255f, alpha);
        } else {
            super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }
}
