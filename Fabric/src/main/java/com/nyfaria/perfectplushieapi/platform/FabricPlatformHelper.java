package com.nyfaria.perfectplushieapi.platform;

import com.nyfaria.perfectplushieapi.client.renderer.ColoredPlushieBlockItemRenderer;
import com.nyfaria.perfectplushieapi.client.renderer.PlayerPlushieBlockItemRenderer;
import com.nyfaria.perfectplushieapi.platform.services.IPlatformHelper;
import com.nyfaria.perfectplushieapi.registration.RegistryObject;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.SpawnEggItem;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public Supplier<Object> getRenderProvider(GeoItem item) {
        return GeoItem.makeRenderer(item);
    }
    @Override
    public void registerFabricRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private PlayerPlushieBlockItemRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null)
                    this.renderer = new PlayerPlushieBlockItemRenderer();

                return this.renderer;
            }
        });
    }
    @Override
    public void registerFabricColorRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private ColoredPlushieBlockItemRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null)
                    this.renderer = new ColoredPlushieBlockItemRenderer();

                return this.renderer;
            }
        });
    }


    @Override
    public <T extends Mob>  SpawnEggItem createSpawnEggItem(RegistryObject<EntityType<T>> entityTypeRegistryObject, int primaryColor, int secondaryColor) {
        return new SpawnEggItem(entityTypeRegistryObject.get(), primaryColor, secondaryColor, new SpawnEggItem.Properties());
    }
}
