package com.nyfaria.perfectplushieapi.block;

import com.nyfaria.perfectplushieapi.block.entity.PlayerPlushieBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.*;

public class PlayerPlushieBlock extends PlushieBlock implements EntityBlock {
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
}