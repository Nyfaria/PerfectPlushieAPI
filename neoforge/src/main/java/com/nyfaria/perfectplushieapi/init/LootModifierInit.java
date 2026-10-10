package com.nyfaria.perfectplushieapi.init;

import com.mojang.serialization.MapCodec;
import com.nyfaria.perfectplushieapi.Constants;
import com.nyfaria.perfectplushieapi.loot.ArchaeologyLootModifier;
import com.nyfaria.perfectplushieapi.loot.VillageLootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class LootModifierInit {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Constants.MODID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<VillageLootModifier>> VILLAGE_LOOT_MODIFIER = registerSerializer("add_plushie", VillageLootModifier.CODEC);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<ArchaeologyLootModifier>> ARCHAEOLOGY_LOOT_MODIFIER = registerSerializer("add_arch_plushie", ArchaeologyLootModifier.CODEC);

    private static <T extends LootModifier> DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<T>> registerSerializer(String id, MapCodec<T> serializer) {
        return LOOT_MODIFIERS.register(id, () -> serializer);
    }
}
