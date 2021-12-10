package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Items {
    private Map<Item, Integer> items = new HashMap<>();;

    public void addItem(Item itemToAdd, int numberOfItemsToAdd) {
        items.computeIfPresent(itemToAdd, (item, numberOfItem) -> numberOfItem + numberOfItemsToAdd);
        items.computeIfAbsent(itemToAdd, numberOfItem -> numberOfItemsToAdd);
    }

    //테스틀르 위한 용도
    public int countItems(Item item) {
        return items.getOrDefault(item, 0);
    }
}
