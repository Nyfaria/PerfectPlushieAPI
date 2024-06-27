package com.nyfaria.perfectplushieapi.client.renderer;

import com.nyfaria.perfectplushieapi.client.model.GenericPlushieBlockItemModel;
import com.nyfaria.perfectplushieapi.item.PlayerGeoPlushieBlockItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ColoredPlushieBlockItemRenderer extends GeoItemRenderer<PlayerGeoPlushieBlockItem> {
    public ColoredPlushieBlockItemRenderer() {
        super(new GenericPlushieBlockItemModel());
    }
}
