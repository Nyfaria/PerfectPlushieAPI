package com.nyfaria.perfectplushieapi.item;

import com.nyfaria.perfectplushieapi.platform.Services;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class GeoPlushieBlockItem extends BlockItem implements GeoItem {

    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);

    public GeoPlushieBlockItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableInstanceCache;
    }

    public Supplier<Object> getRenderProvider() {
        return Services.PLATFORM.getRenderProvider(this);
    }
    public void createRenderer(Consumer<Object> consumer) {
        Services.PLATFORM.registerFabricRenderer(consumer);
    }
}
