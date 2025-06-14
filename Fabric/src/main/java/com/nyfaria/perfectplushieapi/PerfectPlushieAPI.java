package com.nyfaria.perfectplushieapi;

import com.nyfaria.perfectplushieapi.config.CommonConfig;
import com.nyfaria.perfectplushieapi.config.PlushieConfig;
import com.nyfaria.perfectplushieapi.init.PlushieEntityInit;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraftforge.fml.config.ModConfig;

public class PerfectPlushieAPI implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonClass.init();
        PlushiesLootTableModifier.modifyLootTables();
        PlushieEntityInit.attributeSuppliers.forEach(
                p -> FabricDefaultAttributeRegistry.register(p.entityTypeSupplier().get(), p.factory().get().build()));
        ForgeConfigRegistry.INSTANCE.register(Constants.MODID, ModConfig.Type.COMMON, PlushieConfig.CONFIG_SPEC, "perfectplushie-loot.toml");
        ForgeConfigRegistry.INSTANCE.register(Constants.MODID, ModConfig.Type.COMMON, CommonConfig.CONFIG_SPEC, "perfectplushie-trader.toml");

    }
}
