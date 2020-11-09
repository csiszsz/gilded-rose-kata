package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        Arrays.stream(items).forEach(item -> UpdaterFactory.getUpdater(item).update(item));
    }
}