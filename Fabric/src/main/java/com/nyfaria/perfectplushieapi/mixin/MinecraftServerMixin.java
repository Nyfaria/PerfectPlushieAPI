package com.nyfaria.perfectplushieapi.mixin;

import com.nyfaria.perfectplushieapi.init.PlushieBlockEntityInit;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;buildServerStatus()Lnet/minecraft/network/protocol/status/ServerStatus;", ordinal = 0), method = "runServer")
    private void afterSetupServer(CallbackInfo info) {
        ((MappedRegistry)BuiltInRegistries.BLOCK_ENTITY_TYPE).frozen = false;
        PlushieBlockEntityInit.loadClass();
        BuiltInRegistries.BLOCK_ENTITY_TYPE.freeze();
    }
}
