package com.nyfaria.perfectplushieapi.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class PlushieConfig {
    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final PlushieConfig INSTANCE;
    static {
        Pair<PlushieConfig, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(PlushieConfig::new);
        CONFIG_SPEC = pair.getRight();
        INSTANCE = pair.getLeft();
    }
    public final ForgeConfigSpec.DoubleValue village_loot_table_chance;
    public final ForgeConfigSpec.DoubleValue buried_treasure_loot_table_chance;
    public final ForgeConfigSpec.DoubleValue archaeology_loot_table_chance;


    private PlushieConfig(ForgeConfigSpec.Builder builder) {
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
