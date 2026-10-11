package com.nyfaria.perfectplushieapi.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class PlushieConfig {
    public static final ModConfigSpec CONFIG_SPEC;
    public static final PlushieConfig INSTANCE;
    static {
        Pair<PlushieConfig, ModConfigSpec> pair = new ModConfigSpec.Builder().configure(PlushieConfig::new);
        CONFIG_SPEC = pair.getRight();
        INSTANCE = pair.getLeft();
    }
    public final ModConfigSpec.DoubleValue village_loot_table_chance;
    public final ModConfigSpec.DoubleValue buried_treasure_loot_table_chance;
    public final ModConfigSpec.DoubleValue archaeology_loot_table_chance;


    private PlushieConfig(ModConfigSpec.Builder builder) {
        builder.push("loot_table_chances");
        village_loot_table_chance = builder
                .comment("Chance for plushies to appear in village loot tables (default: 0.1)")
                .defineInRange("villageLootTableChance", 0.1, 0.0, 1.0);
        buried_treasure_loot_table_chance = builder
                .comment("Chance for plushies to appear in buried treasure loot tables (default: 0.5)")
                .defineInRange("buriedTreasureLootTableChance", 0.5, 0.0, 1.0);
        archaeology_loot_table_chance = builder
                .comment("Chance for plushies to appear in archaeology loot tables (default: 0.1)")
                .defineInRange("archaeologyLootTableChance", 0.1, 0.0, 1.0);
        builder.pop();
    }
}
