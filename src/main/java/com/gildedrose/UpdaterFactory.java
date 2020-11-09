package com.gildedrose;

import com.gildedrose.updater.*;

import java.util.HashMap;
import java.util.Map;

class UpdaterFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

    private static Map<String, ItemUpdater> ITEM_TYPES;

    static {
        ITEM_TYPES = new HashMap<>();
        ITEM_TYPES.put(AGED_BRIE, new CheeseItemUpdater());
        ITEM_TYPES.put(BACKSTAGE_PASSES, new BackstagePassesItemUpdater());
        ITEM_TYPES.put(SULFURAS, new LegendaryItemUpdater());
        ITEM_TYPES.put(CONJURED, new ConjuredItemUpdater());
    }

    static ItemUpdater getUpdater(Item item) {
        if (ITEM_TYPES.keySet().contains(item.name)) {
            return ITEM_TYPES.get(item.name);
        }
        return new StandardItemUpdater();
    }
}
