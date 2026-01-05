package com.nyfaria.perfectplushieapi.item;

import com.mojang.blaze3d.platform.InputConstants;
import com.nyfaria.perfectplushieapi.platform.Services;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class GenericGeoPlushieBlockItem extends GeoPlushieBlockItem {


    public GenericGeoPlushieBlockItem(Block block, Rarity isRare) {
        super(block, new Properties().rarity(isRare));
    }


    public GenericGeoPlushieBlockItem(Block block) {
        this(block, Rarity.COMMON);
        RenderType.glint();
    }



    public void createRenderer(Consumer<Object> consumer) {
        Services.PLATFORM.registerFabricGeoRenderer(consumer);
    }
}
