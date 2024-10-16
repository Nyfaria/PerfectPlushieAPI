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
import java.util.function.Supplier;

public class PlayerGeoPlushieBlockItem extends GeoPlushieBlockItem {


    public PlayerGeoPlushieBlockItem(Block block, Rarity isRare) {
        super(block, new Properties().rarity(isRare));
    }


    public PlayerGeoPlushieBlockItem(Block block) {
        this(block, Rarity.COMMON);
        RenderType.glint();
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        if (flag.isAdvanced() || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
            Arrays.stream(Component.translatable("plushie.description." + BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath()).getString().split("\n")).forEach(
                    s -> tooltip.add(Component.literal(s).withStyle(ChatFormatting.AQUA))
            );
        } else {
            tooltip.add(Component.translatable("tooltip.perfectplushies.advanced", Component.translatable("tooltip.perfectplushies.shift").withStyle(ChatFormatting.YELLOW)));
        }
    }

    public Supplier<Object> getRenderProvider() {
        return Services.PLATFORM.getRenderProvider(this);
    }


}
