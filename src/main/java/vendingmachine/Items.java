package vendingmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Items {
    private Map<Item, Integer> items = new HashMap<>();;

    public void add(Item itemToAdd, int numberOfItemsToAdd) {
        items.computeIfPresent(itemToAdd, (item, numberOfItem) -> numberOfItem + numberOfItemsToAdd);
        items.computeIfAbsent(itemToAdd, numberOfItem -> numberOfItemsToAdd);
    }

    //테스틀르 위한 용도
    public int countItems(Item item) {
        return items.getOrDefault(item, 0);
    }

    public Optional<Item> findItemByItemName(String name) {
        return items.keySet().stream()
                .filter(item -> item.getName().equals(name)).findAny();
    }

    public boolean isInStock(Item item) {
        if(items.get(item) > 0) {
            return true;
        }
        return false;
    }

    public void reduce(Item itemToReduce) {
        items.computeIfPresent(itemToReduce, (item, quantity) -> --quantity);
    }
}
