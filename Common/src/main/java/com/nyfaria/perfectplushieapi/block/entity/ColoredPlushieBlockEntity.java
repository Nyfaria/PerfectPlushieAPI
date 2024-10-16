package com.nyfaria.perfectplushieapi.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class ColoredPlushieBlockEntity extends BlockEntity implements GeoBlockEntity {

    private List<Vec3i> colors = new ArrayList<>();
    private AnimatableInstanceCache animatableManager = GeckoLibUtil.createInstanceCache(this);

    public ColoredPlushieBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public int colorCount() {
        return colors.size();
    }

    @Override
    public void load(CompoundTag tag) {
        loadData(tag);
        super.load(tag);
    }

    public List<Vec3i> getColors() {
        return colors;
    }

    public void setColors(List<Vec3i> colors) {
        this.colors = colors;
    }

    public int getRed(int index) {
        return colors.get(index).getX();
    }

    public int getGreen(int index) {
        return colors.get(index).getY();
    }

    public int getBlue(int index) {
        return colors.get(index).getZ();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        saveData(pTag);
    }

    private void saveData(CompoundTag pTag) {
        CompoundTag colorsTag = new CompoundTag();
        for(int i = 0; i < colors.size(); i++) {
            Vec3i color = colors.get(i);
            CompoundTag colorTag = new CompoundTag();
            colorTag.putInt("red", color.getX());
            colorTag.putInt("green", color.getY());
            colorTag.putInt("blue", color.getZ());
            colorsTag.put(String.valueOf(i), colorTag);
        }
        pTag.put("colors", colorsTag);
    }
    private void loadData(CompoundTag tag) {
        CompoundTag colorsTag = tag.getCompound("colors");
        for(String key : colorsTag.getAllKeys()) {
            CompoundTag colorTag = colorsTag.getCompound(key);
            Vec3i color = new Vec3i(colorTag.getInt("red"), colorTag.getInt("green"), colorTag.getInt("blue"));
            colors.add(color);
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        saveData(tag);
        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void updateBlock() {
        BlockState blockState = level.getBlockState(this.getBlockPos());
        this.level.sendBlockUpdated(this.getBlockPos(), blockState, blockState, 3);
        this.setChanged();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableManager;
    }

    public void setColor(int index, Vec3i color) {
        if(colors.size() > index) {
            colors.set(index, color);
        } else {
            colors.add(color);
        }
    }

    public void addColor(Vec3i color) {
        colors.add(color);
    }
}
