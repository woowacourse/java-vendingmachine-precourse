package vendingmachine.domain;

import vendingmachine.domain.VendingMachine.Item;
import vendingmachine.domain.VendingMachine.ItemName;

import java.util.List;

public class Items {
    private final List<Item> items;

    public Items(List<Item> items) {
        validateDuplication(items);
        this.items = items;
    }

    private void validateDuplication(List<Item> items) {
        int cnt = (int) items.stream()
                .map(Item::getName)
                .distinct()
                .count();
        if (items.size() != cnt) {
            throw new IllegalArgumentException("[ERROR] 중복된 메뉴가 존재합니다.");
        }
    }

    public boolean isEmpty() {
        return items.stream()
                .allMatch(Item::isEmpty);
    }

    public boolean containsAvailableItem(int money) {
        return items.stream()
                .anyMatch(item -> item.isAvailable(money));
    }

    public Item find(ItemName itemName) {
        return items.stream()
                .filter(item -> item.is(itemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 메뉴가 존재하지 않습니다."));
    }
}
