package com.nyfaria.perfectplushieapi.block;

import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;

public abstract class PlayerPlushieBlock extends PlushieBlock implements EntityBlock {
    @Override
    public RenderShape getRenderShape(BlockState $$0) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }



    @Override
    public String getMessageSender() {
        return "Player Plushie";
    }
}