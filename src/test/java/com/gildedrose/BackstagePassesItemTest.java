package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRoseTest.*;

class BackstagePassesItemTest {

    @Test
    void backstagePassesQualityShouldIncreaseAndSellInShouldDecrease() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 42);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(10, app);
        assertSingleItemQuality(43, app);
    }

    @Test
    void backstagePassesQualityShouldNeverBeMoreThanFifty() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(10, app);
        assertSingleItemQuality(50, app);
    }

    @Test
    void backstagePassesQualityShouldIncreaseByTwoWhenSellInLessOrEqualToTen() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 42);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(9, app);
        assertSingleItemQuality(44, app);
    }

    @Test
    void backstagePassesQualityShouldIncreaseByThreeWhenSellInLessOrEqualToFive() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 42);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(4, app);
        assertSingleItemQuality(45, app);
    }

    @Test
    void backstagePassesQualityShouldDropToZeroWhenSellInNegative() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 42);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(-1, app);
        assertSingleItemQuality(0, app);
    }
}
