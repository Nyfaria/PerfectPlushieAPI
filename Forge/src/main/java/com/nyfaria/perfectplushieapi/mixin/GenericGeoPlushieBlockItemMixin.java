package com.nyfaria.perfectplushieapi.mixin;

import com.nyfaria.perfectplushieapi.client.renderer.PlayerPlushieBlockItemRenderer;
import com.nyfaria.perfectplushieapi.client.renderer.PlushieBlockItemRenderer;
import com.nyfaria.perfectplushieapi.item.GenericGeoPlushieBlockItem;
import com.nyfaria.perfectplushieapi.item.PlayerGeoPlushieBlockItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Consumer;

@Mixin(GenericGeoPlushieBlockItem.class)
public abstract class GenericGeoPlushieBlockItemMixin extends BlockItem {

    public GenericGeoPlushieBlockItemMixin(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private PlushieBlockItemRenderer<?> renderer = null;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null)
                    this.renderer = new PlushieBlockItemRenderer<>();
                return renderer;
            }
        });
    }

}
