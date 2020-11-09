package com.gildedrose.updater;

import com.gildedrose.Item;

public class ConjuredItemUpdater extends StandardItemUpdater {
    private static final int AMOUNT = 2;

    @Override
    public void update(Item item) {
        super.updateStandardItem(item, AMOUNT);
    }
}
