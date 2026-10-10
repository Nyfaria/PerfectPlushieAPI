package com.nyfaria.perfectplushieapi.event;

import com.nyfaria.perfectplushieapi.init.PlushieEntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PPACommonModEvents {


    @SubscribeEvent
    public static void attribs(EntityAttributeCreationEvent e) {
        PlushieEntityInit.attributeSuppliers.forEach(p -> e.put(p.entityTypeSupplier().get(), p.factory().get().build()));

    }
}
