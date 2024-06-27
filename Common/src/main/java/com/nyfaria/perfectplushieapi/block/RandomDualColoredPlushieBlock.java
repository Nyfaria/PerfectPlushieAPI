package com.nyfaria.perfectplushieapi.block;

import com.nyfaria.perfectplushieapi.block.entity.DualColoredPlushieBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public abstract class RandomDualColoredPlushieBlock extends PlushieBlock implements EntityBlock {
    @Override
    public RenderShape getRenderShape(BlockState $$0) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }



    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState $$2, @Nullable LivingEntity $$3, ItemStack stack) {
        super.setPlacedBy(level, pos, $$2, $$3, stack);
        if (level.getBlockEntity(pos) instanceof DualColoredPlushieBlockEntity) {
            Vec3i color1;
            Vec3i color2;
            if(stack.hasTag()){
                int[] color1A = stack.getTag().getIntArray("color1");
                int[] color2A = stack.getTag().getIntArray("color2");
                color1 = new Vec3i(color1A[0], color1A[1], color1A[2]);
                color2 = new Vec3i(color2A[0], color2A[1], color2A[2]);
            } else {
                color1 = new Vec3i(level.random.nextInt(255), level.random.nextInt(255), level.random.nextInt(255));
                color2 = new Vec3i(level.random.nextInt(255), level.random.nextInt(255), level.random.nextInt(255));
            }
            DualColoredPlushieBlockEntity blockEntity = (DualColoredPlushieBlockEntity) level.getBlockEntity(pos);
            if (blockEntity != null) {
                blockEntity.setColor1(color1);
                blockEntity.setColor2(color2);
            }
        }
    }

}