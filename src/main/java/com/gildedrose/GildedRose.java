package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

    void updateQuality() {
        for (Item item : items) {

            if (item.name.equals(AGED_BRIE)) {
                increaseQuality(item);
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                updateBackStagePassesQuality(item);

            } else {
                if (!item.name.equals(SULFURAS)) {
                    decreaseQuality(item);
                }
            }


            if (!item.name.equals(SULFURAS)) {
                decreaseSellIn(item);
            }


            if (item.sellIn < 0) {
                if (item.name.equals(AGED_BRIE)) {
                    increaseQuality(item);
                } else {
                    if (item.name.equals(BACKSTAGE_PASSES)) {
                        item.quality = 0;
                    } else {
                        if (!item.name.equals(SULFURAS)) {
                            decreaseQuality(item);
                        }
                    }
                }
            }
        }
    }

    private void updateBackStagePassesQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }

    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}