package com.nyfaria.perfectplushieapi.block;

import com.nyfaria.perfectplushieapi.block.entity.ColoredPlushieBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class ColoredPlushieBlock extends PlushieBlock implements EntityBlock {
    private final List<Vec3i> colors;
    public ColoredPlushieBlock(List<Vec3i> colors) {
        super();
        this.colors = colors;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState $$2, @Nullable LivingEntity $$3, ItemStack stack) {
        if(level.isClientSide)return;
        if (level.getBlockEntity(pos) instanceof ColoredPlushieBlockEntity coloredPlushieBlockEntity) {
            applyColors(coloredPlushieBlockEntity);
        }
    }

    public List<Vec3i> getColors() {
        return colors;
    }
    public void applyColors(ColoredPlushieBlockEntity blockEntity) {
        for (int i = 0; i < colors.size(); i++) {
            blockEntity.setColor(i, colors.get(i));
        }
        blockEntity.updateBlock();
    }
}
