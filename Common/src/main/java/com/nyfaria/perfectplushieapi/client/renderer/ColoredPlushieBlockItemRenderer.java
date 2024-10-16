package com.nyfaria.perfectplushieapi.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nyfaria.perfectplushieapi.CommonClass;
import com.nyfaria.perfectplushieapi.client.model.GenericPlushieBlockItemModel;
import com.nyfaria.perfectplushieapi.item.GeoPlushieBlockItem;
import com.nyfaria.perfectplushieapi.item.PlayerGeoPlushieBlockItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import java.util.List;

public class ColoredPlushieBlockItemRenderer<T extends GeoPlushieBlockItem> extends GeoItemRenderer<T> {
    public ColoredPlushieBlockItemRenderer() {
        super(new GenericPlushieBlockItemModel<>());
    }

    @Override
    public void renderRecursively(PoseStack poseStack, T animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if(getCurrentItemStack().hasTag() && getCurrentItemStack().getTag().contains("colors")) {
            CompoundTag tag = getCurrentItemStack().getOrCreateTag().getCompound("colors");
            CompoundTag color1 = tag.getCompound("0");
            int red1 = color1.getInt("red");
            int green1 = color1.getInt("green");
            int blue1 = color1.getInt("blue");
            int keys = tag.getAllKeys().size();
            for(int i = 1; i <= keys; i++) {
                if(bone.getName().contains("color" + (i+1))) {
                    CompoundTag color = tag.getCompound(String.valueOf(i));
                    red1 = color.getInt("red");
                    green1 = color.getInt("green");
                    blue1 = color.getInt("blue");
                }
            }
            super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red1 / 255f, green1 / 255f, blue1 / 255f, alpha);
            return;
        }
        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
