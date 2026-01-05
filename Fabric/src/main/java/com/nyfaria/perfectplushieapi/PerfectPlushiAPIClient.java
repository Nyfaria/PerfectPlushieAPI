package com.nyfaria.perfectplushieapi;

import com.nyfaria.perfectplushieapi.client.renderer.GeoPlushieRenderer;
import com.nyfaria.perfectplushieapi.client.renderer.PlushieRenderer;
import com.nyfaria.perfectplushieapi.client.renderer.WanderingPlushieTraderRenderer;
import com.nyfaria.perfectplushieapi.init.PlushieBlockEntityInit;
import com.nyfaria.perfectplushieapi.init.PlushieEntityInit;
import com.nyfaria.perfectplushieapi.init.PlushieBlockInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class PerfectPlushiAPIClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        BlockEntityRenderers.register(PlushieBlockEntityInit.PLAYER_PLUSHIE_BLOCK_ENTITY.get(), (context) -> new PlushieRenderer());
        BlockEntityRenderers.register(PlushieBlockEntityInit.GEO_PLUSHIE_BLOCK_ENTITY.get(), (context) -> new GeoPlushieRenderer<>());
        EntityRendererRegistry.register(PlushieEntityInit.WANDERING_PLUSHIH_TRADER.get(), WanderingPlushieTraderRenderer::new);
    }
}
