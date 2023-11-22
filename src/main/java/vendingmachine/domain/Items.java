package vendingmachine.domain;

import vendingmachine.utils.ItemsValidator;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import static vendingmachine.exception.ErrorMessage.*;

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

    public long findPurchasableMinimumPrice() {
        return items.stream()
                .filter(Item::hasQuantity)
                .mapToLong(Item::providePrice)
                .min()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_ORDER_ITEM.getMessage()));
    }

    public boolean hasNoQuantity() {
        return items.stream()
                .allMatch(Item::hasNoQuantity);
    }

}
