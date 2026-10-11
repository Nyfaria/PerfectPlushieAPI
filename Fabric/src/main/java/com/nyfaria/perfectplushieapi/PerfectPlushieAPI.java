package com.nyfaria.perfectplushieapi;

import com.nyfaria.perfectplushieapi.config.CommonConfig;
import com.nyfaria.perfectplushieapi.config.PlushieConfig;
import com.nyfaria.perfectplushieapi.init.PlushieEntityInit;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.neoforged.fml.config.ModConfig;

public class PerfectPlushieAPI implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonClass.init();
        PlushiesLootTableModifier.modifyLootTables();
        PlushieEntityInit.attributeSuppliers.forEach(
                p -> FabricDefaultAttributeRegistry.register(p.entityTypeSupplier().get(), p.factory().get().build()));
        NeoForgeConfigRegistry.INSTANCE.register(Constants.MODID, ModConfig.Type.COMMON, PlushieConfig.CONFIG_SPEC, "perfectplushie-loot.toml");
        NeoForgeConfigRegistry.INSTANCE.register(Constants.MODID, ModConfig.Type.COMMON, CommonConfig.CONFIG_SPEC, "perfectplushie-trader.toml");

    }
}
