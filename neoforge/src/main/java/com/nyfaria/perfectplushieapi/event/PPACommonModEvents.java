package com.nyfaria.perfectplushieapi.event;

import com.nyfaria.perfectplushieapi.init.PlushieEntityInit;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PPACommonModEvents {

    @SubscribeEvent
    public static void attribs(EntityAttributeCreationEvent e) {
        PlushieEntityInit.attributeSuppliers.forEach(p -> e.put(p.entityTypeSupplier().get(), p.factory().get().build()));

    }
}
