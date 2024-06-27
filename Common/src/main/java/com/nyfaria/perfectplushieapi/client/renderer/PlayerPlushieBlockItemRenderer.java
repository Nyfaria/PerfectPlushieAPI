package com.nyfaria.perfectplushieapi.client.renderer;

import com.nyfaria.perfectplushieapi.client.model.PlayerPlushieBlockItemModel;
import com.nyfaria.perfectplushieapi.item.PlayerGeoPlushieBlockItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PlayerPlushieBlockItemRenderer extends GeoItemRenderer<PlayerGeoPlushieBlockItem> {
    public PlayerPlushieBlockItemRenderer() {
        super(new PlayerPlushieBlockItemModel());
    }
}
