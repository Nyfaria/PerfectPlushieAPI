package com.nyfaria.perfectplushieapi.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
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

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

public class VillageLootModifier extends LootModifier {
    public static final MapCodec<VillageLootModifier> CODEC = RecordCodecBuilder.mapCodec(builder -> codecStart(builder)
            .and(TagEntry.CODEC.listOf().fieldOf("plushies").forGetter(VillageLootModifier::plushies))
            .and(Codec.FLOAT.fieldOf("chance").forGetter(VillageLootModifier::chance))
            .apply(builder, VillageLootModifier::new));

    public final List<TagEntry> plushies;
    private final float chance;

    public VillageLootModifier(LootItemCondition[] conditionsIn, List<TagEntry> plushies, float chance) {
        super(conditionsIn);
        this.plushies = plushies;
        this.chance = chance;

    }

    @Override
    protected @Nonnull ObjectArrayList<ItemStack> doApply(@Nonnull ObjectArrayList<ItemStack> generatedLoot, @Nonnull LootContext context) {
        if (context.getRandom().nextFloat() < chance) {
            TagEntry tagthing = plushies.get(context.getRandom().nextInt(plushies.size()));
            Item item;
            if (tagthing.isTag()) {
                TagKey<Item> itemTag = TagKey.create(Registries.ITEM, tagthing.getId());
                Optional<HolderSet.Named<Item>> tag = BuiltInRegistries.ITEM.getTag(itemTag);
                item = tag.flatMap(set -> set.getRandomElement(context.getRandom())).map(Holder::value).orElse(null);
            } else {
                item = BuiltInRegistries.ITEM.get(tagthing.getId());
            }
            generatedLoot.add(new ItemStack(item));
        }
        return generatedLoot;
    }

    public List<TagEntry> plushies() {
        return plushies;
    }

    public float chance() {
        return chance;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
