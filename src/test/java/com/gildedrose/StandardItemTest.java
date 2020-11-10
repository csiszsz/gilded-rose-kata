package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRoseTest.*;

class StandardItemTest {

    @Test
    void sellInAndQualityShouldDecreaseByEachDay() {
        Item item = new Item("Random item", 11, 42);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(10, app);
        assertSingleItemQuality(41, app);
    }

    @Test
    void qualityShouldDecreaseByTwoWhenSellInNegative() {
        Item item = new Item("Random item", -11, 42);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(-12, app);
        assertSingleItemQuality(40, app);
    }

    @Test
    void qualityShouldDecreaseByTwoWhenSellInZero() {
        Item item = new Item("Random item", 0, 42);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(-1, app);
        assertSingleItemQuality(40, app);
    }

    @Test
    void qualityShouldBeNeverNegative() {
        Item item = new Item("Random item", 11, 0);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(10, app);
        assertSingleItemQuality(0, app);
    }

}
