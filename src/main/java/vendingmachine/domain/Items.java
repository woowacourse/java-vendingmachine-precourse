package vendingmachine.domain;

import vendingmachine.utils.ItemsValidator;

import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.exception.ErrorMessage.CANNOT_BUY_ORDER_ITEM;
import static vendingmachine.exception.ErrorMessage.INVALID_ORDER_ITEM_NAME;

public class Items {
    private final List<Item> items;

    private Items(List<Item> items) {
        this.items = items;
    }

    public static Items from(List<Item> items) {
        validateUniqueName(items);
        return new Items(items);
    }

    private static void validateUniqueName(List<Item> items) {
        List<String> names = items.stream()
                .map(Item::provideName)
                .collect(Collectors.toList());
        ItemsValidator.validateUniqueValue(names);
    }

    public Item buyItem(String itemName, long priceAmount) {
        Item item = findItemByName(itemName);
        item.buyItem(priceAmount);
        return item;
    }

    private Item findItemByName(String name) {
        return items.stream()
                .filter(item -> item.provideName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_ORDER_ITEM_NAME.getMessage()));
    }
}
