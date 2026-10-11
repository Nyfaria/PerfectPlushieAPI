package com.nyfaria.perfectplushieapi.platform;

import com.nyfaria.perfectplushieapi.platform.services.IPlatformHelper;
import com.nyfaria.perfectplushieapi.registration.RegistryObject;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import software.bernie.geckolib.animatable.GeoItem;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public Supplier<Object> getRenderProvider(GeoItem item) {
        return null;
    }

    @Override
    public void registerFabricRenderer(Consumer<Object> consumer) {

    }

    @Override
    public void registerFabricColorRenderer(Consumer<Object> consumer) {

    }

    @Override
    public void registerFabricGeoRenderer(Consumer<Object> consumer) {

    }

    @Override
    public <T extends Mob> SpawnEggItem createSpawnEggItem(RegistryObject<EntityType<?>, EntityType<T>> entityTypeRegistryObject, int primaryColor, int secondaryColor) {
        return new SpawnEggItem(entityTypeRegistryObject.get(), primaryColor, secondaryColor, new SpawnEggItem.Properties());
    }
}
