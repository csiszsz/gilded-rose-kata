package com.gildedrose.updater;

import com.gildedrose.Item;

public class StandardItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        updateStandardItem(item, DEFAULT_AMOUNT);
    }

    void updateStandardItem(Item item, int amount) {
        decreaseQuality(item, amount);

        decreaseSellIn(item);

        if (expired(item)) {
            decreaseQuality(item, amount);
        }
    }
}
