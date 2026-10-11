package com.nyfaria.perfectplushieapi.block;

import com.mojang.serialization.*;
import com.nyfaria.perfectplushieapi.block.entity.PlayerPlushieBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.*;

public class PlayerPlushieBlock extends PlushieBlock implements EntityBlock {
    public static final MapCodec<PlayerPlushieBlock> CODEC = simpleCodec(properties -> new PlayerPlushieBlock());

    @Override
    public RenderShape getRenderShape(BlockState $$0) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }



    @Override
    public String getMessageSender() {
        return "Player Plushie";
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PlayerPlushieBlockEntity(pPos, pState);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
}