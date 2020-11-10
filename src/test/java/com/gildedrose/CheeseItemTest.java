package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRoseTest.*;

class CheeseItemTest {


    @Test
    void agedBrieQualityShouldIncreaseAndSellInShouldDecrease() {
        Item item = new Item("Aged Brie", 11, 42);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(10, app);
        assertSingleItemQuality(43, app);
    }

    @Test
    void agedBrieQualityShouldNeverBeMoreThanFifty() {
        Item item = new Item("Aged Brie", 11, 50);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(10, app);
        assertSingleItemQuality(50, app);
    }

}
