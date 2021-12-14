package vendingmachine.domain.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Items {
    private final Map<Item, Integer> items = new HashMap<>();

    public void add(Item itemToAdd, int numberOfItemsToAdd) {
        items.computeIfPresent(itemToAdd, (item, numberOfItem) -> numberOfItem + numberOfItemsToAdd);
        items.computeIfAbsent(itemToAdd, numberOfItem -> numberOfItemsToAdd);
    }

    public int countItems(Item item) {
        return items.getOrDefault(item, 0);
    }

    public Optional<Item> findByItemName(String name) {
        return items.keySet().stream()
                .filter(item -> item.getName().equals(name)).findAny();
    }

    public boolean isInStock(Item item) {
        if (countItems(item) > 0) {
            return true;
        }
        return false;
    }

    public void reduce(Item itemToReduce) {
        items.computeIfPresent(itemToReduce, (item, quantity) -> --quantity);
    }

    public int findLowestPriceInStock() {
        return findAllInStock().stream().mapToInt(Item::getPrice).min().orElse(0);
    }

    public boolean isEmptyItems() {
        if (findAllInStock().size() > 0) {
            return false;
        }
        return true;
    }

    private List<Item> findAllInStock() {
        return items.keySet().stream()
                .filter(item -> this.countItems(item) > 0)
                .collect(Collectors.toList());
    }
}
