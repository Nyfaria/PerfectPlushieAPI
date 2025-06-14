package com.nyfaria.perfectplushieapi.datagen;

import com.google.common.collect.ImmutableMap;
import com.nyfaria.perfectplushieapi.Constants;
import com.nyfaria.perfectplushieapi.init.PlushieEntityInit;
import com.nyfaria.perfectplushieapi.init.PlushieItemInit;
import com.nyfaria.perfectplushieapi.registration.RegistryObject;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ModLangProvider extends LanguageProvider {
    protected static final String COMMUNITY_PILLAR_STR = "Community Pillar";

    protected static final Map<String, String> REPLACE_LIST = ImmutableMap.of(
            "tnt", "TNT",
            "sus", "",
            "sizableshrimp", "SizableShrimp",
            "gamerpotion", "GamerPotion",
            "sirjain", "SirJain",
            "rocris", "RoCris",
            "rare", "",
            "epic", ""
    );

    public ModLangProvider(PackOutput gen) {
        super(gen, Constants.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        PlushieItemInit.ITEMS.getEntries().forEach(this::itemLang);
        PlushieEntityInit.ENTITIES.getEntries().forEach(this::entityLang);
        add("tooltip.perfectplushies.advanced", "Hold %s for more information");
        add("tooltip.perfectplushies.shift", "SHIFT");
    }

    protected void itemLang(RegistryObject<Item> entry) {
        if (!(entry.get() instanceof BlockItem) || entry.get() instanceof ItemNameBlockItem) {
            addItem(entry, checkReplace(entry));
        }
    }


    protected void entityLang(RegistryObject<EntityType<?>> entry) {
        addEntityType(entry, checkReplace(entry));
    }

    protected String checkReplace(RegistryObject<?> registryObject) {
        return Arrays.stream(registryObject.getId().getPath().split("_"))
                .map(this::checkReplace)
                .filter(s -> !s.isBlank())
                .collect(Collectors.joining(" "))
                .trim();
    }

    protected String checkReplace(String string) {
        return REPLACE_LIST.containsKey(string) ? REPLACE_LIST.get(string) : StringUtils.capitalize(string);
    }
}
