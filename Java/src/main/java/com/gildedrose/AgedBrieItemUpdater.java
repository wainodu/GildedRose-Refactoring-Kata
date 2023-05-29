package com.gildedrose;

public class AgedBrieItemUpdater implements ItemUpdater {
    public void updateItem(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        item.sellIn--;
    }
}
