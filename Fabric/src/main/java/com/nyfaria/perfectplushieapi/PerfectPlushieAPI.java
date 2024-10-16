package com.nyfaria.perfectplushieapi;

import net.fabricmc.api.ModInitializer;

public class PerfectPlushieAPI implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonClass.init();
        PlushiesLootTableModifier.modifyLootTables();

    }
}
