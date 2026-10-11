package com.nyfaria.perfectplushieapi.event;

import com.nyfaria.perfectplushieapi.client.renderer.GeoPlushieRenderer;
import com.nyfaria.perfectplushieapi.client.renderer.PlushieRenderer;
import com.nyfaria.perfectplushieapi.client.renderer.WanderingPlushieTraderRenderer;
import com.nyfaria.perfectplushieapi.init.PlushieBlockEntityInit;
import com.nyfaria.perfectplushieapi.init.PlushieEntityInit;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PPAClientModEvents {

    @SubscribeEvent
    public static void onRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(PlushieBlockEntityInit.PLAYER_PLUSHIE_BLOCK_ENTITY.get(), (context) -> new PlushieRenderer());
        event.registerBlockEntityRenderer(PlushieBlockEntityInit.GEO_PLUSHIE_BLOCK_ENTITY.get(), (context) -> new GeoPlushieRenderer<>());
        event.registerEntityRenderer(PlushieEntityInit.WANDERING_PLUSHIH_TRADER.get(), WanderingPlushieTraderRenderer::new);
    }
}
