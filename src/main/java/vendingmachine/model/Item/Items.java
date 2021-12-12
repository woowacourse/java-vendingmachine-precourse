package vendingmachine.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import vendingmachine.model.buy.BuyItemName;
import vendingmachine.model.money.Money;

public class Items {
    private static final HashMap<Item, Quantity> items = new HashMap<>();

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<Item> items = new ArrayList<>(Items.items.keySet());
        for (Item item : items) {
            stringBuilder.append(item.toString());
            stringBuilder.append(" " + Items.items.get(item) + "개 \n");
        }
        return stringBuilder.toString();
    }

    public boolean isSellable(BuyItemName buyItemName, Money money) {
        return isExist(buyItemName) && moneyLeft(buyItemName, money);
    }

    private boolean isExist(BuyItemName buyItemName) {
        Optional<Item> findItem = items.keySet().stream().filter(item -> item.sameName(buyItemName)).findFirst();
        return findItem.isPresent() && items.get(findItem).isNotZero();
    }

    private boolean moneyLeft(BuyItemName buyItemName, Money money) {
        Optional<Item> findItem = items.keySet().stream().filter(item -> item.sameName(buyItemName)).findFirst();
        return money.isAffordable(findItem.get());
    }
}
