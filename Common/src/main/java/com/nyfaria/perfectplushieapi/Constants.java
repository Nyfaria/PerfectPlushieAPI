package com.nyfaria.perfectplushieapi;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MODID = "perfectplushieapi";
	public static final String MOD_NAME = "Perfect Plushie API";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public ResourceLocation modLoc(String path) {
		return new ResourceLocation(MODID, path);
	}
	public static ResourceLocation mcLoc(String path) {
		return new ResourceLocation( path);
	}
}