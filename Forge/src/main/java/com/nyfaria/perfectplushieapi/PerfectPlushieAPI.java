package com.nyfaria.perfectplushieapi;

import com.nyfaria.perfectplushieapi.datagen.ModLootModifierProvider;
import com.nyfaria.perfectplushieapi.init.LootModifierInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PerfectPlushieAPI {
    
    public PerfectPlushieAPI() {
        CommonClass.init();
        LootModifierInit.LOOT_MODIFIERS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    @SubscribeEvent
    public static void onData(GatherDataEvent event){
        PackOutput packOutput = event.getGenerator().getPackOutput();
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        boolean includeServer = event.includeServer();
        boolean includeClient = event.includeClient();
        generator.addProvider(includeServer, new ModLootModifierProvider(packOutput));

    }

}