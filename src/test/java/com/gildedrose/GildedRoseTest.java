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

    @Test
    void sellInAndQualityShouldLowersByEachDay() {
        Item item = new Item("Random item", 11, 42);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(10, app);
        assertSingleItemQuality(41, app);
    }

    @Test
    void qualityShouldDegradeTwiceAsFastAfterSellInNegative() {
        Item item = new Item("Random item", -11, 42);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(-12, app);
        assertSingleItemQuality(40, app);
    }

    @Test
    void qualityShouldBeNeverNegative() {
        Item item = new Item("Random item", 11, 0);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(10, app);
        assertSingleItemQuality(0, app);
    }

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

    @Test
    void sulfurasQualityAndSellInShouldNeverChange() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 11, 80);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(11, app);
        assertSingleItemQuality(80, app);
    }

    @Test
    void backstagePassesQualityShouldIncreaseAndSellInShouldDescrease() {
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


    private void assertSingleItemSellIn(int i, GildedRose app) {
        assertEquals(i, app.items[0].sellIn);
    }

    private void assertSingleItemQuality(int i, GildedRose app) {
        assertEquals(i, app.items[0].quality);
    }

    private GildedRose addAndUpdateItem(Item item) {
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app;
    }

}
