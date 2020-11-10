package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void itemNameShouldNotChangeAfterUpdate() {
        Item item = new Item("foo", 0, 0);
        GildedRose app = addAndUpdateItem(item);
        assertEquals("foo", app.items[0].name);
    }

    static void assertSingleItemSellIn(int i, GildedRose app) {
        assertEquals(i, app.items[0].sellIn);
    }

    static void assertSingleItemQuality(int i, GildedRose app) {
        assertEquals(i, app.items[0].quality);
    }

    static GildedRose addAndUpdateItem(Item item) {
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app;
    }
}
