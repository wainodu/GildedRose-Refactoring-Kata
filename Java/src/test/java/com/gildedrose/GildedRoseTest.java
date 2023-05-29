package com.gildedrose;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    static Stream<Integer> provideParams() {
        return Stream.of(1, 3, 5, 10, 25, 50);
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void normalItemShouldUpdateProperly(int days) {
        Item NormalItem = new Item("foo", 5, 7);
        List<Item> items = new ArrayList<>();
        items.add(NormalItem);
        int startQuality = NormalItem.quality;
        int startSellIn = NormalItem.sellIn;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(startSellIn - days, app.items.get(0).sellIn);
        if ((startQuality < days) ||
            ((startSellIn < days) && (startQuality < ((2 * (days - startSellIn)) + startSellIn)))) {
            assertEquals(0, app.items.get(0).quality);
        } else if (startSellIn > days) {
            assertEquals(startQuality - days, app.items.get(0).quality);
        } else {
            assertEquals(startQuality - ((2 * (days - startSellIn)) + startSellIn), app.items.get(0).quality);
        }
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void backstageItemShouldUpdateProperly(int days) {
        Item NormalItem = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 45);
        List<Item> items = new ArrayList<>();
        items.add(NormalItem);
        int startQuality = NormalItem.quality;
        int startSellIn = NormalItem.sellIn;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(startSellIn - days, app.items.get(0).sellIn);
        if (startSellIn < days) {
            assertEquals(0, app.items.get(0).quality);
        } else if (((startQuality + days) > 50) || ((startSellIn < 10) && ((startQuality + (days * 2)) > 50))) {
            assertEquals(50, app.items.get(0).quality);
        } else if (startSellIn <= 5) {
            assertEquals(startQuality + 3 * (startSellIn - days), app.items.get(0).quality);
        } else if (startSellIn > 10) {
            assertEquals(startQuality + days, app.items.get(0).quality);
        } else if (startSellIn <= 10 && startSellIn > 5) {
            assertEquals(startQuality + 2 * days, app.items.get(0).quality);
        } else if (startSellIn <= 5 && startSellIn > 0) {
            assertEquals(startQuality + 3 * days, app.items.get(0).quality);
        } else {
            assertEquals(0, app.items.get(0).quality);
        }
    }


    @ParameterizedTest
    @MethodSource("provideParams")
    void agedBrieItemShouldUpdateProperly(int days) {
        Item NormalItem = new Item("Aged Brie", 4, 43);
        List<Item> items = new ArrayList<>();
        items.add(NormalItem);
        int startQuality = NormalItem.quality;
        int startSellIn = NormalItem.sellIn;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(startSellIn - days, app.items.get(0).sellIn);
        if (startQuality + days > 50) {
            assertEquals(50, app.items.get(0).quality);
        } else {
            assertEquals(startQuality + days, app.items.get(0).quality);
        }
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void sulfurasItemShouldUpdateProperly(int days) {
        Item NormalItem = new Item("Sulfuras, Hand of Ragnaros", 7, 45);
        List<Item> items = new ArrayList<>();
        items.add(NormalItem);
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(80, app.items.get(0).quality);
        assertEquals(null, app.items.get(0).sellIn);
    }
}
