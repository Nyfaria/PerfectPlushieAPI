package com.nyfaria.perfectplushieapi.init;

import com.nyfaria.perfectplushieapi.Constants;
import com.nyfaria.perfectplushieapi.block.PlayerPlushieBlock;
import com.nyfaria.perfectplushieapi.block.PlushieBlock;
import com.nyfaria.perfectplushieapi.block.entity.PlayerPlushieBlockEntity;
import com.nyfaria.perfectplushieapi.item.PlayerGeoPlushieBlockItem;
import com.nyfaria.perfectplushieapi.registration.RegistrationProvider;
import com.nyfaria.perfectplushieapi.registration.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class PlushieBlockInit {
    protected static PlushieBlockInit instance;
    public static List<RegistryObject<Block>> playerBlocks = new ArrayList<>();
    public static List<RegistryObject<Block>> playerBlocksCommon = new ArrayList<>();
    public static List<RegistryObject<Block>> playerBlocksRare = new ArrayList<>();
    public static List<RegistryObject<Block>> playerBlocksEpic = new ArrayList<>();
    public static List<RegistryObject<? extends Block>> plushieBlocks = new ArrayList<>();




    public static RegistryObject<Block> registerCommonPlayerPlushie(String name) {
        return registerPlayerPlushie(name, Rarity.COMMON);
    }

    public static RegistryObject<Block> registerRarePlayerPlushie(String name) {
        return registerPlayerPlushie(name, Rarity.RARE);
    }

    public static RegistryObject<Block> registerEpicPlayerPlushie(String name) {
        return registerPlayerPlushie(name, Rarity.EPIC);
    }

    public static RegistryObject<Block> registerPlayerPlushie(String name, Rarity rarity) {
        RegistryObject<Block> block = instance.getBlockProvider().register(name, PlayerPlushieBlock::new);
        instance.getItemProvider().register(name, () -> new PlayerGeoPlushieBlockItem(block.get(), rarity));
        addToList(block, rarity);
        return block;
    }

    public static void addToList(RegistryObject<Block> block, Rarity rarity) {
        switch (rarity) {
            case COMMON -> playerBlocksCommon.add(block);
            case RARE -> playerBlocksRare.add(block);
            case EPIC -> playerBlocksEpic.add(block);
        }
        playerBlocks.add(block);
    }

    public static RegistryObject<Block> registerCommonBasicPlushie(String name) {
        return registerBasicPlushie(name, Rarity.COMMON);
    }

    public static RegistryObject<Block> registerRareBasicPlushie(String name) {
        return registerBasicPlushie(name, Rarity.RARE);
    }

    public static RegistryObject<Block> registerEpicBasicPlushie(String name) {
        return registerBasicPlushie(name, Rarity.EPIC);
    }

    public static RegistryObject<Block> registerBasicPlushie(String name, Rarity rarity) {
        RegistryObject<Block> block = instance.getBlockProvider().register(name, PlushieBlock::new);
        instance.getItemProvider().register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(rarity)));
        plushieBlocks.add(block);

        return block;
    }

    public static RegistryObject<Block> registerCustomPlushie(String name, Supplier<? extends Block> customPlushieBlock) {
        RegistryObject<Block> block = instance.getBlockProvider().register(name, customPlushieBlock);
        instance.getItemProvider().register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(Rarity.COMMON)));
        plushieBlocks.add(block);

        return block;
    }

    public static <T extends Block>  RegistryObject<T> registerCustomItemPlushie(String name, Supplier<T> customPlushieBlock,  Function<RegistryObject<T>, Supplier<? extends BlockItem>> item) {
        var block = instance.getBlockProvider().register(name, customPlushieBlock);
        instance.getItemProvider().register(name, () -> item.apply(block).get());
        plushieBlocks.add(block);

        return block;
    }

    public abstract RegistrationProvider<Block> getBlockProvider();
    public abstract RegistrationProvider<Item> getItemProvider();
}
