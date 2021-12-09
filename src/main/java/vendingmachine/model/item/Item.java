package vendingmachine.model.item;

import static vendingmachine.exception.ExceptionMessage.ITEM_INFO_BRACKET_EXCEPTION_MESSAGE;
import static vendingmachine.exception.ExceptionMessage.ITEM_INFO_NOT_ENOUGH_EXCEPTION_MESSAGE;

import vendingmachine.model.item.vo.Price;
import vendingmachine.model.item.vo.Quantity;

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
        String[] itemProperties = itemInfo.split(INFO_DELIMITER);
        validateNumberOfInfo(itemProperties);
        name = itemProperties[0];
        price = new Price(itemProperties[1]);
        remainingQuantity = new Quantity(itemProperties[2]);
    }

    private void validateBracket(final String itemInfo) {
        char firstLetter = itemInfo.charAt(0);
        char lastLetter = itemInfo.charAt(itemInfo.length() - 1);
        if (firstLetter != LEFT_BRACKET || lastLetter != RIGHT_BRACKET) {
            throw new IllegalArgumentException(ITEM_INFO_BRACKET_EXCEPTION_MESSAGE);
        }
    }

    private void validateNumberOfInfo(final String[] itemProperties) {
        if (itemProperties.length != NUMBER_OF_ITEM_PROPERTIES) {
            throw new IllegalArgumentException(ITEM_INFO_NOT_ENOUGH_EXCEPTION_MESSAGE);
        }
    }
}
