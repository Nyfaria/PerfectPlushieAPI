package com.nyfaria.perfectplushieapi;

import com.nyfaria.perfectplushieapi.config.CommonConfig;
import com.nyfaria.perfectplushieapi.init.LootModifierInit;
import com.nyfaria.perfectplushieapi.init.PlushieBlockEntityInit;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PerfectPlushieAPI {

    public PerfectPlushieAPI() {
        CommonClass.init();
        LootModifierInit.LOOT_MODIFIERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.CONFIG_SPEC);
        PlushieBlockEntityInit.loadClass();

    }

}