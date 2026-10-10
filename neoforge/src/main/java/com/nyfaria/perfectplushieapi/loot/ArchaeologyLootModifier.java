package com.nyfaria.perfectplushieapi.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import javax.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class ArchaeologyLootModifier extends LootModifier {
    public static final MapCodec<ArchaeologyLootModifier> CODEC = RecordCodecBuilder.mapCodec(builder -> codecStart(builder)
            .and(TagEntry.CODEC.listOf().fieldOf("plushies").forGetter(ArchaeologyLootModifier::plushies))
            .and(Codec.INT.listOf().fieldOf("weights").forGetter(ArchaeologyLootModifier::weights))
            .and(Codec.FLOAT.fieldOf("chance").forGetter(ArchaeologyLootModifier::chance))
            .apply(builder, ArchaeologyLootModifier::new));


    public final List<TagEntry> plushies;
    private final List<Integer> weights;
    private final float chance;

    public ArchaeologyLootModifier(LootItemCondition[] conditionsIn, List<TagEntry> plushies, List<Integer> weights, float chance) {
        super(conditionsIn);
        this.plushies = plushies;
        this.weights = weights;
        this.chance = chance;

    }

    @Override
    protected @Nonnull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() < chance) {
            List<Item> plushieList = new ArrayList<>();
            for (int i = 0; i < plushies.size(); i++) {
                TagEntry tagEntry = plushies.get(i);
                int weight = weights.get(i);
                if (tagEntry.isTag()) {
                    TagKey<Item> itemTag = TagKey.create(Registries.ITEM, tagEntry.getId());
                    BuiltInRegistries.ITEM.getTag(itemTag).ifPresent(tag -> tag.stream().map(net.minecraft.core.Holder::value).forEach(item -> {
                        for (int j = 0; j < weight; j++) {
                            plushieList.add(item);
                        }
                    }));
                } else {
                    plushieList.add(BuiltInRegistries.ITEM.get(tagEntry.getId()));
                }
            }
        }
        return generatedLoot;
    }

    public List<TagEntry> plushies() {
        return plushies;
    }

    private List<Integer> weights() {
        return weights;
    }

    public float chance() {
        return chance;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
