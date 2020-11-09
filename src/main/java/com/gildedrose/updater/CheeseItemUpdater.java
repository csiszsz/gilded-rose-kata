package com.gildedrose.updater;

import com.gildedrose.Item;

public class CheeseItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        increaseQuality(item, DEFAULT_AMOUNT);

        decreaseSellIn(item);

        if (expired(item)) {
            increaseQuality(item, DEFAULT_AMOUNT);
        }
    }
}
