package com.nyfaria.perfectplushieapi.block.entity;

import com.nyfaria.perfectplushieapi.init.PlushieBlockEntityInit;
import com.nyfaria.perfectplushieapi.init.PlushieBlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.*;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class PlayerPlushieBlockEntity extends BlockEntity implements GeoBlockEntity {
    private AnimatableInstanceCache animatableManager = GeckoLibUtil.createInstanceCache(this);

    public PlayerPlushieBlockEntity(BlockPos pos, BlockState state) {
        super(PlushieBlockEntityInit.PLAYER_PLUSHIE_BLOCK_ENTITY.get(), pos, state);
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableManager;
    }
}
