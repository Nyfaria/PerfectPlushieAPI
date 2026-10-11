package com.nyfaria.perfectplushieapi.block;

import com.mojang.serialization.MapCodec;
import com.nyfaria.perfectplushieapi.block.entity.GeoPlushieBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.*;

public class GeoPlushieBlock extends PlushieBlock implements EntityBlock {
    public static final MapCodec<GeoPlushieBlock> CODEC = simpleCodec(properties -> new GeoPlushieBlock());

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new GeoPlushieBlockEntity(pPos, pState);
    }
}
