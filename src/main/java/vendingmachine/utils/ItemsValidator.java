package vendingmachine.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static vendingmachine.exception.ErrorMessage.DUPLICATE_ITEM_NAMES;

public class ItemsValidator {
    public static void validateUniqueValue(List<String> elements) {
        Set<String> uniqueElements = new HashSet<>(elements);
        if (elements.size() != uniqueElements.size()) {
            throw new IllegalArgumentException(DUPLICATE_ITEM_NAMES.getMessage());
        }
    }
}
