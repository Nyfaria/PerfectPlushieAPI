package com.nyfaria.perfectplushieapi.block.entity;

import com.nyfaria.perfectplushieapi.init.PlushieBlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.*;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class GeoPlushieBlockEntity extends BlockEntity implements GeoBlockEntity {
    private AnimatableInstanceCache animatableManager = GeckoLibUtil.createInstanceCache(this);

    public GeoPlushieBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(PlushieBlockEntityInit.GEO_PLUSHIE_BLOCK_ENTITY.get(), pPos, pBlockState);
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableManager;
    }
}
