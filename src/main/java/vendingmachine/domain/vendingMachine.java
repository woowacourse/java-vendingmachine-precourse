package vendingmachine.domain;

import java.util.List;
import java.util.Map;

public class vendingMachine {

    private static final String NOT_FOUND_ITEM_EXCEPTION = "해당 상품은 존재하지 않습니다.";

    private final Map<Coin, Integer> coins;
    private final List<Item> items;

    public vendingMachine(Map<Coin, Integer> coins, List<Item> items) {
        this.coins = coins;
        this.items = items;
    }

    public void buyItem(Money money, String itemName) {
        Item item = findItem(itemName);
        item.reduceQuantity();
        money.reduceAmount(item.getPrice());
    }

    private Item findItem(String itemName) {
        return items.stream()
                .filter(item -> item.isSameName(itemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ITEM_EXCEPTION));
    }
}
