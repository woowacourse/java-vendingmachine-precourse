package vendingmachine.model.item;

import static vendingmachine.exception.ExceptionMessage.ITEMS_OVERLAP_EXCEPTION_MESSAGE;
import static vendingmachine.exception.ExceptionMessage.WRONG_ITEM_DELIMITER_EXCEPTION_MESSAGE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Items {
    private static final String ITEM_DELIMITER = ";";
    private final List<Item> values;

    public Items(final String userInput) {
        validateWrongDelimiter(userInput);
        String[] itemInfos = userInput.split(ITEM_DELIMITER);
        values = Arrays.stream(itemInfos)
                .map(Item::new)
                .collect(Collectors.toList());
        validateOverlap(itemInfos.length);
    }

    private void validateWrongDelimiter(final String userInput) {
        String firstLetter = String.valueOf(userInput.charAt(0));
        String lastLetter = String.valueOf(userInput.charAt(userInput.length() - 1));
        if (firstLetter.equals(ITEM_DELIMITER) || lastLetter.equals(ITEM_DELIMITER)) {
            throw new IllegalArgumentException(WRONG_ITEM_DELIMITER_EXCEPTION_MESSAGE);
        }
    }

    private void validateOverlap(final int numberOfItems) {
        int distinctCountOfItems = (int) values.stream().distinct().count();
        if (numberOfItems != distinctCountOfItems) {
            throw new IllegalArgumentException(ITEMS_OVERLAP_EXCEPTION_MESSAGE);
        }
    }
}
