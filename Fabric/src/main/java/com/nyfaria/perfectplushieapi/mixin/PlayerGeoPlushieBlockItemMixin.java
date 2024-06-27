package com.nyfaria.perfectplushieapi.mixin;

import com.nyfaria.perfectplushieapi.item.PlayerGeoPlushieBlockItem;
import org.spongepowered.asm.mixin.Mixin;
import software.bernie.geckolib.animatable.GeoItem;

@Mixin(PlayerGeoPlushieBlockItem.class)
public abstract class PlayerGeoPlushieBlockItemMixin implements GeoItem {

}
