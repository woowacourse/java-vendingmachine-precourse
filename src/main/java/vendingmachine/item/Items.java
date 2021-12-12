package vendingmachine.item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import vendingmachine.item.Item;

public class Items {
    private Map<Item, Integer> items = new HashMap<>();;

    public void add(Item itemToAdd, int numberOfItemsToAdd) {
        items.computeIfPresent(itemToAdd, (item, numberOfItem) -> numberOfItem + numberOfItemsToAdd);
        items.computeIfAbsent(itemToAdd, numberOfItem -> numberOfItemsToAdd);
    }

    //테스트를 위한 public
    public int countItems(Item item) {
        return items.getOrDefault(item, 0);
    }

    public Optional<Item> findItemByItemName(String name) {
        return items.keySet().stream()
                .filter(item -> item.getName().equals(name)).findAny();
    }

    public boolean isInStock(Item item) {
        if(countItems(item) > 0) {
            return true;
        }
        return false;
    }

    public void reduce(Item itemToReduce) {
        items.computeIfPresent(itemToReduce, (item, quantity) -> --quantity);
    }

    public int findLowestPriceInStock() {
        return items.keySet().stream()
                .filter(item -> items.get(item) > 0)
                .map(Item::getPrice)
                .sorted()
                .findFirst()
                .orElse(0);
    }

    public boolean isEmptyItems() {
        Optional<Integer> itemsInStock = items.values().stream().filter(quantity -> quantity > 0).findAny();
        if(itemsInStock.isPresent()) {
            return false;
        }
        return true;
    }
}
