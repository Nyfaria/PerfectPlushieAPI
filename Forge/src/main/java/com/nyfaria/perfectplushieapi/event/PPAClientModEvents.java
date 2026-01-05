package com.nyfaria.perfectplushieapi.event;

import com.nyfaria.perfectplushieapi.client.renderer.GeoPlushieRenderer;
import com.nyfaria.perfectplushieapi.client.renderer.PlushieRenderer;
import com.nyfaria.perfectplushieapi.client.renderer.WanderingPlushieTraderRenderer;
import com.nyfaria.perfectplushieapi.init.PlushieBlockEntityInit;
import com.nyfaria.perfectplushieapi.init.PlushieBlockInit;
import com.nyfaria.perfectplushieapi.init.PlushieEntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PPAClientModEvents {

    @SubscribeEvent
    public static void onRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(PlushieBlockEntityInit.PLAYER_PLUSHIE_BLOCK_ENTITY.get(), (context) -> new PlushieRenderer());
        event.registerBlockEntityRenderer(PlushieBlockEntityInit.GEO_PLUSHIE_BLOCK_ENTITY.get(), (context) -> new GeoPlushieRenderer<>());
        event.registerEntityRenderer(PlushieEntityInit.WANDERING_PLUSHIH_TRADER.get(), WanderingPlushieTraderRenderer::new);
    }
}
