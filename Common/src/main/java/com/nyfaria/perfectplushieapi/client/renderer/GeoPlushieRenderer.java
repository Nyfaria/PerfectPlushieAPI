package com.nyfaria.perfectplushieapi.client.renderer;

import com.nyfaria.perfectplushieapi.block.entity.GeoPlushieBlockEntity;
import com.nyfaria.perfectplushieapi.client.model.GeoPlushieModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GeoPlushieRenderer<T extends GeoPlushieBlockEntity> extends GeoBlockRenderer<T> {

    public GeoPlushieRenderer() {
        super(new GeoPlushieModel<T>());
    }
}
