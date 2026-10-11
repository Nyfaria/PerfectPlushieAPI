package com.nyfaria.perfectplushieapi.api;

import com.nyfaria.perfectplushieapi.block.*;
import com.nyfaria.perfectplushieapi.registration.RegistryObject;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class PlushieStore {
    public static List<RegistryObject<Block,PlushieBlock>> playerBlocks = new ArrayList<>();
    public static List<RegistryObject<Block,PlushieBlock>> playerBlocksCommon = new ArrayList<>();
    public static List<RegistryObject<Block,PlushieBlock>> playerBlocksRare = new ArrayList<>();
    public static List<RegistryObject<Block,PlushieBlock>> playerBlocksEpic = new ArrayList<>();
    public static List<RegistryObject<Block,PlushieBlock>> geoPlushieBlocks = new ArrayList<>();
    public static List<RegistryObject<Block,PlushieBlock>> plushieBlocks = new ArrayList<>();
}
