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
            if (!item.name.equals(SULFURAS)) {
                switch (item.name) {
                    case AGED_BRIE:
                        increaseQuality(item);
                        break;
                    case BACKSTAGE_PASSES:
                        updateBackStagePassesQuality(item);
                        break;
                    case CONJURED:
                        decreaseQuality(item);
                        decreaseQuality(item);
                        break;
                    default:
                        decreaseQuality(item);
                        break;
                }


                decreaseSellIn(item);


                if (item.sellIn < 0) {
                    switch (item.name) {
                        case AGED_BRIE:
                            increaseQuality(item);
                            break;
                        case BACKSTAGE_PASSES:
                            item.quality = 0;
                            break;
                        case CONJURED:
                            decreaseQuality(item);
                            decreaseQuality(item);
                            break;
                        default:
                            decreaseQuality(item);
                            break;
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
        item.sellIn--;
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}