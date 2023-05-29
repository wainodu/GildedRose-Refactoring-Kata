package com.gildedrose;

import java.util.Iterator;
import java.util.List;


class GildedRose {
    public List<Item> items;
//    Iterator <Item> iterator = items.iterator();

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
//        while (iterator.hasNext()) {
//            Item item = iterator.next();
//            if (item.sellIn < 2 || item.quality < 0) {
//                iterator.remove();
//            } else if () {
//
//            }
//        }
//        items.stream()
//            .filter(item -> item.quality > 0 && item.sellIn > 0)
//            .collect(Collectors.toList());

       /* for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }*/
}

