package com.nyfaria.perfectplushieapi;

import com.nyfaria.perfectplushieapi.init.PlushieTags;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntries;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntry;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Arrays;

public class PlushiesLootTableModifier {
    public static final String[] VILLAGE_VARIANTS = new String[]{
            "village_armorer",
            "village_butcher",
            "village_cartographer",
            "village_desert_house",
            "village_fisher",
            "village_fletcher",
            "village_mason",
            "village_plains_house",
            "village_savanna_house",
            "village_shepherd",
            "village_snowy_house",
            "village_taiga_house",
            "village_tannery",
            "village_temple",
            "village_toolsmith",
            "village_weaponsmith",
    };

    public static String[] BURIED_VARIANTS = new String[]{
            "buried_treasure",
            "shipwreck_treasure",
            "simple_dungeon",
            "underwater_ruin_big",
            "underwater_ruin_small"
    };

    public static String[] COMMON_ARCHAEOLOGY_VARIANTS = new String[]{
            "archaeology/desert_well",
            "archaeology/desert_pyramid",
            "archaeology/trail_ruins_common",
            "archaeology/trail_ruins_rare",
            "archaeology/ocean_ruin_warm",
            "archaeology/ocean_ruin_cold"
    };

    public static ResourceLocation LOOT_TABLE_RESOURCE_LOCATION;

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            // Regular plushies
            for (String village : VILLAGE_VARIANTS) {
                LOOT_TABLE_RESOURCE_LOCATION = new ResourceLocation("minecraft", "chests/village/" + village);
                if (LOOT_TABLE_RESOURCE_LOCATION.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(TagEntry.expandTag(PlushieTags.VILLAGE_PLUSHIES_ITEMS).when(LootItemRandomChanceCondition.randomChance(0.5f)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))))
                            .add(TagEntry.expandTag(PlushieTags.RARE_VILLAGE_PLUSHIES_ITEMS).when(LootItemRandomChanceCondition.randomChance(0.25f)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))))
                            .add(TagEntry.expandTag(PlushieTags.EPIC_VILLAGE_PLUSHIES_ITEMS).when(LootItemRandomChanceCondition.randomChance(0.1f)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))));
                    tableBuilder.pool(poolBuilder.build());
                }
            }

            // Player plushies
            for (String buried_treasure : BURIED_VARIANTS) {
                LOOT_TABLE_RESOURCE_LOCATION = new ResourceLocation("minecraft", "chests/" + buried_treasure);
                if (LOOT_TABLE_RESOURCE_LOCATION.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(TagEntry.expandTag(PlushieTags.TREASURE_PLUSHIES_ITEMS).when(LootItemRandomChanceCondition.randomChance(0.5f)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))))
                            .add(TagEntry.expandTag(PlushieTags.RARE_TREASURE_PLUSHIES_ITEMS).when(LootItemRandomChanceCondition.randomChance(0.25f)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))))
                            .add(TagEntry.expandTag(PlushieTags.EPIC_TREASURE_PLUSHIES_ITEMS).when(LootItemRandomChanceCondition.randomChance(0.1f)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))));
                    tableBuilder.pool(poolBuilder.build());
                }
            }
            // Archaeology plushies
            for (String buried_treasure : COMMON_ARCHAEOLOGY_VARIANTS) {
                LOOT_TABLE_RESOURCE_LOCATION = new ResourceLocation("minecraft", buried_treasure);
                if (LOOT_TABLE_RESOURCE_LOCATION.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(TagEntry.expandTag(PlushieTags.ARCHAEOLOGY_PLUSHIES_ITEMS).setWeight(4).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))))
                            .add(TagEntry.expandTag(PlushieTags.RARE_ARCHAEOLOGY_PLUSHIES_ITEMS).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))));
                    tableBuilder.pool(poolBuilder.build());
                }
            }

        });
        LootTableEvents.REPLACE.register((resourceManager,lootManager,resourceLocation,table,source) -> {
            if(Arrays.stream(COMMON_ARCHAEOLOGY_VARIANTS).toList().contains(resourceLocation.getPath())) {
                LootTable.Builder builder = LootTable.lootTable();
                LootPool.Builder poolBuilder = LootPool.lootPool();

                Arrays.stream(Arrays.stream(table.pools).findFirst().get().entries).forEach(
                        entry -> {
                            poolBuilder.add(LootItem.lootTableItem(((LootItem) entry).item));
                        }
                );
                poolBuilder.add(TagEntry.expandTag(PlushieTags.ARCHAEOLOGY_PLUSHIES_ITEMS).setWeight(2));
                poolBuilder.add(TagEntry.expandTag(PlushieTags.RARE_ARCHAEOLOGY_PLUSHIES_ITEMS).setWeight(1));
                builder.pool(poolBuilder.build());
                return builder.build();
            }
            return table;
        });
    }
}