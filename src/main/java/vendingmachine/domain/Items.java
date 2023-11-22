package vendingmachine.domain;

import vendingmachine.utils.ItemsValidator;

import java.util.List;
import java.util.stream.Collectors;

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


}
