package com.nyfaria.perfectplushieapi;

import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleMod {
    
    public ExampleMod() {
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();
    }


}