package com.nyfaria.perfectplushieapi.client.renderer;

import com.nyfaria.perfectplushieapi.block.entity.PlayerPlushieBlockEntity;
import com.nyfaria.perfectplushieapi.client.model.PlayerPlushieModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PlushieRenderer extends GeoBlockRenderer<PlayerPlushieBlockEntity> {
    public PlushieRenderer() {
        super(new PlayerPlushieModel());
    }
}
