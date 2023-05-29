package com.gildedrose;

public class SulfurasItemUpdater implements ItemUpdater {
    public void updateItem(Item item) {
        item.quality = 80;
        item.sellIn = null;
    }
}
