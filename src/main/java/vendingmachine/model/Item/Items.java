package vendingmachine.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import vendingmachine.model.buy.BuyItemName;
import vendingmachine.model.money.Money;

public class Items {
    private static final HashMap<Item, Quantity> items = new HashMap<>();
    public static final String COUNT_UNIT = "개 \n";

    public Items(String[] rawItems) {
        for (String rawItem : rawItems) {
            String itemData = rawItem.substring(1, rawItem.length() - 1);
            String[] itemSplit = itemData.split(",");
            items.put(new Item(itemSplit[0], itemSplit[1]), new Quantity(itemSplit[2]));
        }
    }

    public static boolean containsName(String buyItemName) {
        return items.keySet().stream()
            .anyMatch(item -> item.sameName(buyItemName));
    }

    public boolean isSellable(BuyItemName buyItemName, Money money) {
        return isExist(buyItemName) && moneyLeft(buyItemName, money);
    }

    private boolean isExist(BuyItemName buyItemName) {
        Item findItem = items.keySet().stream()
            .filter(item -> item.sameName(buyItemName))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
        return items.get(findItem).isNotZero();
    }

    private boolean moneyLeft(BuyItemName buyItemName, Money money) {
        Item findItem = items.keySet().stream()
            .filter(item -> item.sameName(buyItemName))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
        return money.isAffordable(findItem);
    }

    public void sell(BuyItemName buyItemName, Money money) {
        Item findItem = items.keySet().stream()
            .filter(item -> item.sameName(buyItemName))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
        items.put(findItem, items.get(findItem).decrease());
        money.decrease(findItem.getPrice());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<Item> items = new ArrayList<>(Items.items.keySet());
        for (Item item : items) {
            stringBuilder.append(item.toString());
            stringBuilder.append(" " + Items.items.get(item) + COUNT_UNIT);
        }
        return stringBuilder.toString();
    }
}
