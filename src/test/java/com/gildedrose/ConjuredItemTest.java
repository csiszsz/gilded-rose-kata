package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRoseTest.*;

class ConjuredItemTest {

    @Test
    void conjuredQualityShouldDecreaseByTwoWhenSellInStrictlyPositive() {
        Item item = new Item("Conjured Mana Cake", 11, 42);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(10, app);
        assertSingleItemQuality(40, app);
    }

    @Test
    void conjuredQualityShouldDecreaseByFourWhenSellInNegative() {
        Item item = new Item("Conjured Mana Cake", -11, 42);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(-12, app);
        assertSingleItemQuality(38, app);
    }

    @Test
    void conjuredQualityShouldDecreaseByFourWhenSellInZero() {
        Item item = new Item("Conjured Mana Cake", 0, 42);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(-1, app);
        assertSingleItemQuality(38, app);
    }
}
