package vendingmachine.model.item;

import static vendingmachine.exception.ExceptionMessage.ITEM_INFO_FORMAT_EXCEPTION_MESSAGE;

import java.util.Objects;

import vendingmachine.model.item.vo.Price;
import vendingmachine.model.item.vo.Quantity;

public class Item {
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";
    private static final String INFO_DELIMITER = ",";
    private static final int NUMBER_OF_ITEM_PROPERTIES = 3;
    private final String name;
    private final Price price;
    private final Quantity remainingQuantity;

    public Item(String itemInfo) {
        validateBracket(itemInfo);
        itemInfo = removeBracket(itemInfo);
        String[] itemProperties = itemInfo.split(INFO_DELIMITER);
        validateNumberOfInfo(itemProperties);
        name = itemProperties[0];
        price = new Price(itemProperties[1]);
        remainingQuantity = new Quantity(itemProperties[2]);
    }

    private void validateBracket(final String itemInfo) {
        String firstLetter = String.valueOf(itemInfo.charAt(0));
        String lastLetter = String.valueOf(itemInfo.charAt(itemInfo.length() - 1));
        if (!firstLetter.equals(LEFT_BRACKET) || !lastLetter.equals(RIGHT_BRACKET)) {
            throw new IllegalArgumentException(ITEM_INFO_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private String removeBracket(String itemInfo) {
        itemInfo = itemInfo.replace(LEFT_BRACKET, "");
        itemInfo = itemInfo.replace(RIGHT_BRACKET, "");
        return itemInfo;
    }

    private void validateNumberOfInfo(final String[] itemProperties) {
        if (itemProperties.length != NUMBER_OF_ITEM_PROPERTIES) {
            throw new IllegalArgumentException(ITEM_INFO_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
