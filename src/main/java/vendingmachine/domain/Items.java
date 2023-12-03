package vendingmachine.domain;

import vendingmachine.domain.VendingMachine.Item;

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
}
