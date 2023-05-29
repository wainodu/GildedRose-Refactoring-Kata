package com.gildedrose;

public class BackstageTAFKAL80ETCIItemUpdater implements ItemUpdater {
    public void updateItem(Item item) {
        if ((item.quality < 50) && (item.sellIn > 0)) {
            if ((item.sellIn > 5) && (item.sellIn <= 10)) {
                item.quality += 2;
            } else if (item.sellIn <= 5) {
                item.quality += 3;
            }
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
        if (item.quality > 50) {
            item.quality = 50;
        }
    }
}


