package com.nyfaria.perfectplushieapi.api;

import com.nyfaria.perfectplushieapi.registration.RegistryObject;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class PlushieStore {
    public static List<RegistryObject<Block>> playerBlocks = new ArrayList<>();
    public static List<RegistryObject<Block>> playerBlocksCommon = new ArrayList<>();
    public static List<RegistryObject<Block>> playerBlocksRare = new ArrayList<>();
    public static List<RegistryObject<Block>> playerBlocksEpic = new ArrayList<>();
    public static List<RegistryObject<Block>> geoPlushieBlocks = new ArrayList<>();
    public static List<RegistryObject<? extends Block>> plushieBlocks = new ArrayList<>();
}
