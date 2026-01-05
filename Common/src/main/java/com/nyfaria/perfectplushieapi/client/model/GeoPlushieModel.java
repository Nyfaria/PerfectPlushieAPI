package com.nyfaria.perfectplushieapi.client.model;

import com.nyfaria.perfectplushieapi.Constants;
import com.nyfaria.perfectplushieapi.block.entity.GeoPlushieBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import java.util.HashMap;
import java.util.Map;

public class GeoPlushieModel<T extends GeoPlushieBlockEntity> extends GeoModel<T> {
    protected static final ResourceLocation NONE_ANIMATION = new ResourceLocation(Constants.MODID, "animations/none.animation.json");
    protected final Map<ResourceLocation, ResourceLocation> geoCache = new HashMap<>();
    protected final Map<ResourceLocation, ResourceLocation> animationCache = new HashMap<>();
    protected final Map<ResourceLocation, ResourceLocation> textureCache = new HashMap<>();

    @Override
    public ResourceLocation getModelResource(T animatable) {
        return geoCache.computeIfAbsent(BuiltInRegistries.BLOCK.getKey(animatable.getBlockState().getBlock()),
                k -> new ResourceLocation(k.getNamespace(), "geo/block/" + k.getPath() + ".geo.json"));
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return textureCache.computeIfAbsent(BuiltInRegistries.BLOCK.getKey(animatable.getBlockState().getBlock()),
                k -> new ResourceLocation(k.getNamespace(), "textures/block/" + k.getPath() + ".png"));
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return NONE_ANIMATION;
    }
}
