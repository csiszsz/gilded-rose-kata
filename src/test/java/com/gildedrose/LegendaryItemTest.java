package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRoseTest.*;

class LegendaryItemTest {

    @Test
    void sulfurasQualityAndSellInShouldNeverChange() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 11, 80);

        GildedRose app = addAndUpdateItem(item);

        assertSingleItemSellIn(11, app);
        assertSingleItemQuality(80, app);
    }

}
