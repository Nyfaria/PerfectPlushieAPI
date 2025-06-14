package com.nyfaria.perfectplushieapi.init;

import com.nyfaria.perfectplushieapi.Constants;
import com.nyfaria.perfectplushieapi.platform.Services;
import com.nyfaria.perfectplushieapi.registration.RegistrationProvider;
import com.nyfaria.perfectplushieapi.registration.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;

public class PlushieItemInit {
    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MODID);
    public static final RegistryObject<Item> WANDERING_TRADER_SPAWN_EGG = registerSpawnEgg(
            "wandering_plushie_trader_spawn_egg",
            PlushieEntityInit.WANDERING_PLUSHIH_TRADER,
            0x906834, 0xa4471f);



    public static<T extends Mob> RegistryObject<Item> registerSpawnEgg(String id, RegistryObject<EntityType<T>> entity, int primaryColor, int secondaryColor) {
        return PlushieItemInit.ITEMS.register(id, () -> Services.PLATFORM.createSpawnEggItem(entity, primaryColor, secondaryColor));
    }

    public static void loadClass() {
    }
}
