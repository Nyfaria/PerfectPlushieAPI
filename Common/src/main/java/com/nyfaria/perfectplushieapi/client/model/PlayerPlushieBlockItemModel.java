package com.nyfaria.perfectplushieapi.client.model;

import com.nyfaria.perfectplushieapi.Constants;
import com.nyfaria.perfectplushieapi.item.PlayerGeoPlushieBlockItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import java.util.HashMap;
import java.util.Map;

public class PlayerPlushieBlockItemModel extends GeoModel<PlayerGeoPlushieBlockItem> {

    public final ResourceLocation modDevDoll = new ResourceLocation(Constants.MODID, "geo/player_plushie.geo.json");
    public final Map<ResourceLocation, ResourceLocation> textures = new HashMap<>();
    public final ResourceLocation noAnimations = new ResourceLocation(Constants.MODID, "animations/none.animation.json");


    @Override
    public ResourceLocation getModelResource(PlayerGeoPlushieBlockItem animatable) {
        return modDevDoll;
    }

    @Override
    public ResourceLocation getTextureResource(PlayerGeoPlushieBlockItem animatable) {
        return textures.computeIfAbsent(BuiltInRegistries.ITEM.getKey(animatable), blockRL -> new ResourceLocation(Constants.MODID, "textures/block/" + blockRL.getPath() + ".png"));
    }

    @Override
    public ResourceLocation getAnimationResource(PlayerGeoPlushieBlockItem animatable) {
        return noAnimations;
    }
}
