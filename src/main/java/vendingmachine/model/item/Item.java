package vendingmachine.model.item;

import vendingmachine.model.item.vo.Price;
import vendingmachine.model.item.vo.Quantity;

import static vendingmachine.exception.ExceptionMessage.ITEM_INFO_BRACKET_EXCEPTION_MESSAGE;

public class Item {
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';
    private static final String INFO_DELIMITER = ",";
    private static final int NUMBER_OF_ITEM_PROPERTIES = 3;
    private final String name;
    private final Price price;
    private final Quantity remainingQuantity;

    public Item(final String itemInfo) {
        validateBracket(itemInfo);
        String[] itemInfoTokens = itemInfo.split(INFO_DELIMITER);
        name = itemInfoTokens[0];
        price = new Price(itemInfoTokens[1]);
        remainingQuantity = new Quantity(itemInfoTokens[2]);
    }

    private void validateBracket(final String itemInfo) {
        char firstLetter = itemInfo.charAt(0);
        char lastLetter = itemInfo.charAt(itemInfo.length() - 1);
        if (firstLetter != LEFT_BRACKET || lastLetter != RIGHT_BRACKET) {
            throw new IllegalArgumentException(ITEM_INFO_BRACKET_EXCEPTION_MESSAGE);
        }
    }
}
