package com.nyfaria.perfectplushieapi.block;

import com.nyfaria.perfectplushieapi.block.entity.ColoredPlushieBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public abstract class RandomDualColoredPlushieBlock extends ColoredPlushieBlock implements EntityBlock {
    public RandomDualColoredPlushieBlock() {
        super(new ArrayList<>());
    }

    @Override
    public RenderShape getRenderShape(BlockState $$0) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }


    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState $$2, @Nullable LivingEntity $$3, ItemStack stack) {
        if (level.isClientSide) return;
        if (level.getBlockEntity(pos) instanceof ColoredPlushieBlockEntity) {
            Vec3i color1;
            Vec3i color2;
            if (stack.hasTag()) {
                CompoundTag colors = stack.getTag().getCompound("colors");
                CompoundTag color1Tag = colors.getCompound("0");
                color1 = new Vec3i(color1Tag.getInt("red"), color1Tag.getInt("green"), color1Tag.getInt("blue"));
                CompoundTag color2Tag = colors.getCompound("1");
                color2 = new Vec3i(color2Tag.getInt("red"), color2Tag.getInt("green"), color2Tag.getInt("blue"));
            } else {
                color1 = new Vec3i(level.random.nextInt(255), level.random.nextInt(255), level.random.nextInt(255));
                color2 = new Vec3i(level.random.nextInt(255), level.random.nextInt(255), level.random.nextInt(255));
            }
            getColors().clear();
            getColors().add(color1);
            getColors().add(color2);
            super.setPlacedBy(level, pos, $$2, $$3, stack);
        }
    }

}