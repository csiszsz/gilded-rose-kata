package com.gildedrose.updater;

import com.gildedrose.Item;

public interface ItemUpdater {
    int MIN_QUALITY_VALUE = 0;
    int MAX_QUALITY_VALUE = 50;
    int DEFAULT_AMOUNT = 1;

    void update(Item item);

    default void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    default void decreaseQuality(Item item, int amount) {
        if (item.quality > MIN_QUALITY_VALUE) {
            item.quality -= amount;
        }
    }

    default void increaseQuality(Item item, int amount) {
        if (item.quality < MAX_QUALITY_VALUE) {
            item.quality += amount;
        }
    }

    default boolean expired(Item item) {
        return item.sellIn < 0;
    }
}
