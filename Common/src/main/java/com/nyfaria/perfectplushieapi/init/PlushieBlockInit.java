package com.nyfaria.perfectplushieapi.init;

import com.nyfaria.perfectplushieapi.api.PlushieStore;
import com.nyfaria.perfectplushieapi.block.GeoPlushieBlock;
import com.nyfaria.perfectplushieapi.block.PlayerPlushieBlock;
import com.nyfaria.perfectplushieapi.block.PlushieBlock;
import com.nyfaria.perfectplushieapi.item.GenericGeoPlushieBlockItem;
import com.nyfaria.perfectplushieapi.item.GeoPlushieBlockItem;
import com.nyfaria.perfectplushieapi.item.PlayerGeoPlushieBlockItem;
import com.nyfaria.perfectplushieapi.registration.RegistrationProvider;
import com.nyfaria.perfectplushieapi.registration.RegistryObject;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class PlushieBlockInit {
    protected static PlushieBlockInit instance;





    public static RegistryObject<Block,PlushieBlock> registerCommonPlayerPlushie(String name) {
        return registerPlayerPlushie(name, Rarity.COMMON);
    }

    public static RegistryObject<Block,PlushieBlock> registerRarePlayerPlushie(String name) {
        return registerPlayerPlushie(name, Rarity.RARE);
    }

    public static RegistryObject<Block,PlushieBlock> registerEpicPlayerPlushie(String name) {
        return registerPlayerPlushie(name, Rarity.EPIC);
    }

    public static RegistryObject<Block,PlushieBlock> registerPlayerPlushie(String name, Rarity rarity) {
        RegistryObject<Block,PlushieBlock> block = instance.getBlockProvider().register(name, PlayerPlushieBlock::new);
        instance.getItemProvider().register(name, () -> new PlayerGeoPlushieBlockItem(block.get(), rarity));
        addToList(block, rarity);
        return block;
    }

    public static void addToList(RegistryObject<Block,PlushieBlock> block, Rarity rarity) {
        switch (rarity) {
            case COMMON -> PlushieStore.playerBlocksCommon.add(block);
            case RARE -> PlushieStore.playerBlocksRare.add(block);
            case EPIC -> PlushieStore.playerBlocksEpic.add(block);
        }
        PlushieStore.playerBlocks.add(block);
    }

    public static RegistryObject<Block,PlushieBlock> registerCommonBasicPlushie(String name) {
        return registerBasicPlushie(name, Rarity.COMMON);
    }

    public static RegistryObject<Block,PlushieBlock> registerRareBasicPlushie(String name) {
        return registerBasicPlushie(name, Rarity.RARE);
    }

    public static RegistryObject<Block,PlushieBlock> registerEpicBasicPlushie(String name) {
        return registerBasicPlushie(name, Rarity.EPIC);
    }

    public static RegistryObject<Block,PlushieBlock> registerGeoPlushie(String name, Rarity rarity) {
        RegistryObject<Block,PlushieBlock> block = instance.getBlockProvider().register(name, GeoPlushieBlock::new);
        instance.getItemProvider().register(name, () -> new GenericGeoPlushieBlockItem(block.get(), rarity) );
        PlushieStore.geoPlushieBlocks.add(block);
        PlushieStore.plushieBlocks.add(block);
        return block;
    }


    public static RegistryObject<Block,PlushieBlock> registerBasicPlushie(String name, Rarity rarity) {
        RegistryObject<Block,PlushieBlock> block = instance.getBlockProvider().register(name, PlushieBlock::new);
        instance.getItemProvider().register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(rarity)));
        PlushieStore.plushieBlocks.add(block);

        return block;
    }

    @SuppressWarnings("unchecked")
    public static RegistryObject<Block,PlushieBlock> registerCustomPlushie(String name, Supplier<? extends Block> customPlushieBlock) {
        RegistryObject<Block,PlushieBlock> block = (RegistryObject<Block,PlushieBlock>) (RegistryObject<Block,?>) instance.getBlockProvider().register(name, customPlushieBlock);
        instance.getItemProvider().register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(Rarity.COMMON)));
        PlushieStore.plushieBlocks.add(block);

        return block;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Block>  RegistryObject<T,T> registerCustomItemPlushie(String name, Supplier<T> customPlushieBlock,  Function<RegistryObject<T,T>, Supplier<? extends BlockItem>> item) {
        RegistryObject<T,T> block = (RegistryObject<T,T>) (RegistryObject<Block,?>) instance.getBlockProvider().register(name, customPlushieBlock);
        instance.getItemProvider().register(name, () -> item.apply(block).get());
        PlushieStore.plushieBlocks.add((RegistryObject<Block,PlushieBlock>) (RegistryObject<Block,?>) block);

        return block;
    }

    public abstract RegistrationProvider<Block> getBlockProvider();
    public abstract RegistrationProvider<Item> getItemProvider();
}
