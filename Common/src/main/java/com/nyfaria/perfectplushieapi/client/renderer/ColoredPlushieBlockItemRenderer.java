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
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.component.CustomData;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import java.util.List;

public class ColoredPlushieBlockItemRenderer<T extends GeoPlushieBlockItem> extends GeoItemRenderer<T> {
    public ColoredPlushieBlockItemRenderer() {
        super(new GenericPlushieBlockItemModel<>());
    }

    @Override
    public void renderRecursively(PoseStack poseStack, T animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
        CustomData customData = getCurrentItemStack().getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        if(!customData.isEmpty() && customData.copyTag().contains("colors")) {
            CompoundTag tag = customData.copyTag().getCompound("colors");
            CompoundTag color1 = tag.getCompound("0");
            int red1 = color1.getInt("red");
            int green1 = color1.getInt("green");
            int blue1 = color1.getInt("blue");
            int keys = tag.getAllKeys().size();
            for(int i = 1; i <= keys; i++) {
                if(bone.getName().contains("color" + (i+1))) {
                    CompoundTag colorTag = tag.getCompound(String.valueOf(i));
                    red1 = colorTag.getInt("red");
                    green1 = colorTag.getInt("green");
                    blue1 = colorTag.getInt("blue");
                }
            }
            float alpha = FastColor.ARGB32.alpha(color) / 255f;
            super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, FastColor.ARGB32.colorFromFloat(alpha, red1 / 255f, green1 / 255f, blue1 / 255f));
            return;
        }
        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
    }
}
