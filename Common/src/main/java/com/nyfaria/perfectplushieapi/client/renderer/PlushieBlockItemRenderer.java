package com.nyfaria.perfectplushieapi.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nyfaria.perfectplushieapi.client.model.GenericPlushieBlockItemModel;
import com.nyfaria.perfectplushieapi.item.GeoPlushieBlockItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.nbt.CompoundTag;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PlushieBlockItemRenderer<T extends GeoPlushieBlockItem> extends GeoItemRenderer<T> {
    public PlushieBlockItemRenderer() {
        super(new GenericPlushieBlockItemModel<>());
    }
    
}
