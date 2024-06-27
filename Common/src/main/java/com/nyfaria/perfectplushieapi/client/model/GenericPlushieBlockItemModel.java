package com.nyfaria.perfectplushieapi.client.model;

import com.nyfaria.perfectplushieapi.item.PlayerGeoPlushieBlockItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GenericPlushieBlockItemModel extends GeoModel<PlayerGeoPlushieBlockItem> {
    @Override
    public ResourceLocation getModelResource(PlayerGeoPlushieBlockItem animatable) {
        return null;
    }

    @Override
    public ResourceLocation getTextureResource(PlayerGeoPlushieBlockItem animatable) {
        return null;
    }

    @Override
    public ResourceLocation getAnimationResource(PlayerGeoPlushieBlockItem animatable) {
        return null;
    }
}
