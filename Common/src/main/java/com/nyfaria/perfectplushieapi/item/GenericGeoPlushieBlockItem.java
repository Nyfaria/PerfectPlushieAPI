package com.nyfaria.perfectplushieapi.item;

import com.mojang.blaze3d.platform.InputConstants;
import com.nyfaria.perfectplushieapi.client.renderer.PlushieBlockItemRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.lwjgl.glfw.GLFW;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.*;

public class GenericGeoPlushieBlockItem extends GeoPlushieBlockItem {

public GenericGeoPlushieBlockItem(Block block, Rarity isRare) {
        super(block, new Properties().rarity(isRare));
    }

public GenericGeoPlushieBlockItem(Block block) {
        this(block, Rarity.COMMON);
        RenderType.glint();
    }

@Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private PlushieBlockItemRenderer<?> renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new PlushieBlockItemRenderer<>();
                return this.renderer;
            }
        });
    }
}
