package com.nyfaria.perfectplushieapi.client.model;

import com.nyfaria.perfectplushieapi.item.GeoPlushieBlockItem;
import com.nyfaria.perfectplushieapi.item.PlayerGeoPlushieBlockItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import software.bernie.geckolib.model.GeoModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericPlushieBlockItemModel<T extends GeoPlushieBlockItem> extends GeoModel<T> {
    protected final Map<ResourceLocation, ResourceLocation> geoCache = new HashMap<>();
    protected final Map<ResourceLocation, ResourceLocation> textureCache = new HashMap<>();

    @Override
    public ResourceLocation getModelResource(T animatable) {
        return geoCache.computeIfAbsent(getRegistryName(animatable), k -> new ResourceLocation(k.getNamespace(), "geo/block/" + k.getPath() + ".geo.json"));
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return textureCache.computeIfAbsent(getRegistryName(animatable.getBlock()), k -> new ResourceLocation(k.getNamespace(), "textures/block/" + k.getPath() + ".png"));
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return null;
    }

    private static ResourceLocation getRegistryName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
    private static ResourceLocation getRegistryName(Block item) {
        return BuiltInRegistries.BLOCK.getKey(item);
    }
}
