package com.gildedrose.updater;

import com.gildedrose.Item;

public class BackstagePassesItemUpdater implements ItemUpdater {
    private static final int QUALITY_AFTER_CONCERT = 0;

    @Override
    public void update(Item item) {
        updateQuality(item);

        decreaseSellIn(item);

        if (expired(item)) {
            item.quality = QUALITY_AFTER_CONCERT;
        }
    }

    private void updateQuality(Item item) {
        increaseQuality(item, DEFAULT_AMOUNT);
        if (item.sellIn < 11) {
            increaseQuality(item, DEFAULT_AMOUNT);
        }
        if (item.sellIn < 6) {
            increaseQuality(item, DEFAULT_AMOUNT);
        }
    }
}
