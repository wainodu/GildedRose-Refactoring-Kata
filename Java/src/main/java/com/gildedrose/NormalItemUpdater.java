package com.gildedrose;

public class NormalItemUpdater implements ItemUpdater {
    public void updateItem(Item item) {
        if (item.sellIn <= 0 && item.quality > 1) {
            item.quality -= 2;
        } else {
            item.quality--;
        }
        item.sellIn--;
        if (item.quality < 0){
            item.quality = 0;
        }
    }
}
