package com.gildedrose;

import java.util.List;

class GildedRose {
    public List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            ItemUpdater itemUpdater;
            switch (items.get(i).name) {
                case "Aged Brie":
                    itemUpdater = new AgedBrieItemUpdater();
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    itemUpdater = new BackstageTAFKAL80ETCIItemUpdater();
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    itemUpdater = new SulfurasItemUpdater();
                    break;
                default:
                    itemUpdater = new NormalItemUpdater();
                    break;
            }
            itemUpdater.updateItem(items.get(i));
        }
    }
}



