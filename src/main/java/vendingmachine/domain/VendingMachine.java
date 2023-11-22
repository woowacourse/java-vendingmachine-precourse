package vendingmachine.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    private static final String NOT_FOUND_ITEM_EXCEPTION = "해당 상품은 존재하지 않습니다.";

    private final Map<Coin, Integer> coins;
    private final List<Item> items;
    private final Money money;

    public VendingMachine(Map<Coin, Integer> coins, List<Item> items, Money money) {
        this.coins = coins;
        this.items = items;
        this.money = money;
    }

    public boolean canPurchase() {
        return hasEnoughMoney() && !allItemSoldOut();
    }

    private boolean hasEnoughMoney() {
        int minPrice = items.stream()
                .mapToInt(Item::getPrice)
                .min()
                .getAsInt();
        return money.isBiggerOrEqual(minPrice);
    }

    private boolean allItemSoldOut() {
        return items.stream()
                .map(Item::getQuantity)
                .noneMatch(quantity -> quantity > 0);
    }

    public void buyItem(String itemName) {
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

    public Map<Coin, Integer> returnChanges() {
        Map<Coin, Integer> change = new EnumMap<>(Coin.class);
        //TODO: 잔돈 계산 로직 구현
        return change;
    }
}
