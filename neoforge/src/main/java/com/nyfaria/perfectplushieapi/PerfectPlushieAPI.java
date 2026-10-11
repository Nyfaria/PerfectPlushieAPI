package com.nyfaria.perfectplushieapi;

import com.nyfaria.perfectplushieapi.config.CommonConfig;
import com.nyfaria.perfectplushieapi.init.LootModifierInit;
import com.nyfaria.perfectplushieapi.init.PlushieBlockEntityInit;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(Constants.MODID)
public class PerfectPlushieAPI {

    public PerfectPlushieAPI(ModContainer container, IEventBus eventBus) {
        CommonClass.init();
        LootModifierInit.LOOT_MODIFIERS.register(eventBus);
        container.registerConfig(ModConfig.Type.COMMON, CommonConfig.CONFIG_SPEC);
        PlushieBlockEntityInit.loadClass();
    }

}
