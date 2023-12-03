package vendingmachine.service;

import vendingmachine.domain.Items;
import vendingmachine.domain.Count;
import vendingmachine.domain.Item;
import vendingmachine.domain.ItemName;
import vendingmachine.domain.Price;
import vendingmachine.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ItemService {
    private static final String ITEMS_DELIMITER = ";";
    private static final char ITEM_DELIMITER_CHAR = ',';
    private static final String ITEM_DELIMITER = ",";
    public static final int ITEM_DELIMITER_COUNT = 2;

    public static Items getItems(String string) {
        return getItems(string.split(ITEMS_DELIMITER));
    }

    private static Items getItems(String[] splited) {
        List<Item> items = Arrays.stream(splited)
                .map(string -> getItem(string.trim()))
                .collect(Collectors.toList());
        return new Items(items);
    }

    private static Item getItem(String string) {
        validateItemStringFormat(string);
        validateItemDelimiter(string);
        string = removeBracket(string);
        String[] splited = string.split(ITEM_DELIMITER);
        return getItem(splited[0].trim(), splited[1].trim(), splited[2].trim());
    }

    private static void validateItemStringFormat(String string) {
        if (!isWrappedInSquareBracket(string)) {
            throw new IllegalArgumentException("[ERROR] 입력 포맷이 올바르지 않습니다.");
        }
    }

    private static void validateItemDelimiter(String string) {
        if (countItemDelimiterCount(string) != ITEM_DELIMITER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 입력 포맷이 올바르지 않습니다.");
        }
    }

    private static String removeBracket(String string) {
        return string.substring(1, string.length() - 1);
    }

    private static boolean isWrappedInSquareBracket(String string) {
        return string.charAt(0) == '[' && string.charAt(string.length() - 1) == ']';
    }

    private static int countItemDelimiterCount(String string) {
        int cnt = 0;
        for (char c : string.toCharArray()) {
            if (c == ITEM_DELIMITER_CHAR) {
                cnt++;
            }
        }
        return cnt;
    }

    private static Item getItem(String itemName, String price, String count) {
        Validator.validateNumber(price);
        Validator.validateNumber(count);
        return new Item(
                new ItemName(itemName),
                new Price(Integer.parseInt(price)),
                new Count(Integer.parseInt(count))
        );
    }
}
