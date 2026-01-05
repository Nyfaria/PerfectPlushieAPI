package com.nyfaria.perfectplushieapi.init;

import com.nyfaria.perfectplushieapi.Constants;
import com.nyfaria.perfectplushieapi.api.PlushieStore;
import com.nyfaria.perfectplushieapi.block.entity.GeoPlushieBlockEntity;
import com.nyfaria.perfectplushieapi.block.entity.PlayerPlushieBlockEntity;
import com.nyfaria.perfectplushieapi.registration.RegistrationProvider;
import com.nyfaria.perfectplushieapi.registration.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public abstract class PlushieBlockEntityInit {
    public static final RegistrationProvider<BlockEntityType<?>> BLOCK_ENTITIES = RegistrationProvider.get(Registries.BLOCK_ENTITY_TYPE, Constants.MODID);
    public static final RegistryObject<BlockEntityType<PlayerPlushieBlockEntity>> PLAYER_PLUSHIE_BLOCK_ENTITY = BLOCK_ENTITIES.register("player_plushie_block_entity", () -> BlockEntityType.Builder.of(PlayerPlushieBlockEntity::new, PlushieStore.playerBlocks.stream().map(Supplier::get).toArray(Block[]::new)).build(null));
    public static final RegistryObject<BlockEntityType<GeoPlushieBlockEntity>> GEO_PLUSHIE_BLOCK_ENTITY = BLOCK_ENTITIES.register("dumbo_blob_plushie", () -> BlockEntityType.Builder.of(GeoPlushieBlockEntity::new, PlushieStore.geoPlushieBlocks.stream().map(Supplier::get).toArray(Block[]::new)).build(null));
    public static void loadClass() {}
}
