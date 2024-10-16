package com.nyfaria.perfectplushieapi.init;

import com.mojang.serialization.Codec;
import com.nyfaria.perfectplushieapi.Constants;
import com.nyfaria.perfectplushieapi.loot.ArchaeologyLootModifier;
import com.nyfaria.perfectplushieapi.loot.VillageLootModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LootModifierInit {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Constants.MODID);

    public static final RegistryObject<Codec<VillageLootModifier>> VILLAGE_LOOT_MODIFIER = registerSerializer("add_plushie", VillageLootModifier.CODEC);
    public static final RegistryObject<Codec<ArchaeologyLootModifier>> ARCHAEOLOGY_LOOT_MODIFIER = registerSerializer("add_arch_plushie", ArchaeologyLootModifier.CODEC);

    private static <T extends LootModifier> RegistryObject<Codec<T>> registerSerializer(String id, Codec<T> serializer) {
        return LOOT_MODIFIERS.register(id, () -> serializer);
    }
}
