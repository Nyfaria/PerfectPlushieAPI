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

public abstract class DualColoredPlushieBlockEntity extends BlockEntity implements GeoBlockEntity {

    private Vec3i color1;
    private Vec3i color2;
    private AnimatableInstanceCache animatableManager = GeckoLibUtil.createInstanceCache(this);

    public DualColoredPlushieBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void load(CompoundTag tag) {
        loadData(tag);
        super.load(tag);
    }

    private void loadData(CompoundTag tag) {
        int[] color1A = tag.getIntArray("color1");
        int[] color2A = tag.getIntArray("color2");
        color1 = new Vec3i(color1A[0], color1A[1], color1A[2]);
        color2 = new Vec3i(color2A[0], color2A[1], color2A[2]);
    }

    public int getRed1() {
        return color1.getX();
    }

    public int getGreen1() {
        return color1.getY();
    }

    public int getBlue1() {
        return color1.getZ();
    }

    public int getRed2() {
        return color2.getX();
    }

    public int getGreen2() {
        return color2.getY();
    }

    public int getBlue2() {
        return color2.getZ();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        saveData(pTag);
    }

    private void saveData(CompoundTag pTag) {
        pTag.putIntArray("color1", new int[]{color1.getX(), color1.getY(), color1.getZ()});
        pTag.putIntArray("color2", new int[]{color2.getX(), color2.getY(), color2.getZ()});
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

    public void setColor1(Vec3i color1) {
        this.color1 = color1;
    }

    public void setColor2(Vec3i color2) {
        this.color2 = color2;
    }
}
