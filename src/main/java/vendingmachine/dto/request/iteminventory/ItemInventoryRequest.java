package vendingmachine.dto.request.iteminventory;

import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_WRONG_ITEM_INVENTORY_INPUT;
import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_WRONG_ITEM_QUANTITY_INPUT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vendingmachine.dto.servicedto.ItemInfo;
import vendingmachine.dto.servicedto.ItemInventoryInfo;

public class ItemInventoryRequest {
    private static final int MINIMUM_VALUE_OF_ITEM_QUANTITY = 1;
    private static final String COMMA_DELIMITER_BETWEEN_KINDS_OF_ITEM_INFO = ",";
    private static final String OPENING_BRACKET_FOR_ITEM_INVENTORY_INFO = "[";
    private static final String CLOSING_BRACKET_FOR_ITEM_INVENTORY_INFO = "]";
    private static final int LENGTH_OF_OPENING_BRACKET = 1;
    private static final int LENGTH_OF_CLOSING_BRACKET = 1;
    private static final int NUMBER_OF_INFO_ITEM_INVENTORY_INPUT_TO_HAS = 3;
    private static final int INDEX_OF_ITEM_NAME = 0;
    private static final int INDEX_OF_ITEM_PRICE = 1;
    private static final int INDEX_OF_ITEM_QUANTITY = 2;
    private final String input;

    public ItemInventoryRequest(String input) {
        this.input = input;
    }

    public ItemInventoryInfo toItemInventoryInfo() {
        List<String> input = divideByKindOfInfo();
        return new ItemInventoryInfo(extractItemInfo(input), extractItemQuantity(input));
    }

    private List<String> divideByKindOfInfo() {
        List<String> itemInventoryInfo = new ArrayList<>();
        try {
            validateInfoInBrackets();
            validateNoEmptyInfo();
            itemInventoryInfo = Arrays.asList(splitByComma(removeBracket()));
            validateNumberOfInfo(itemInventoryInfo);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_ITEM_INVENTORY_INPUT);
        }
        return itemInventoryInfo;
    }

    private ItemInfo extractItemInfo(List<String> infoToAdd) {
        ItemRequest itemRequest = new ItemRequest(infoToAdd.get(INDEX_OF_ITEM_NAME).trim(), infoToAdd.get(INDEX_OF_ITEM_PRICE));
        return itemRequest.toItemInfo();
    }

    private int extractItemQuantity(List<String> infoToAdd) {
        try {
            int quantity = Integer.parseInt(infoToAdd.get(INDEX_OF_ITEM_QUANTITY));
            validateItemQuantity(quantity);
            return quantity;
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_ITEM_QUANTITY_INPUT);
        }
    }

    private void validateInfoInBrackets() {
        if (!(input.startsWith(OPENING_BRACKET_FOR_ITEM_INVENTORY_INFO) && input.endsWith(CLOSING_BRACKET_FOR_ITEM_INVENTORY_INFO))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoEmptyInfo() {
        if (input.length() <= LENGTH_OF_OPENING_BRACKET + LENGTH_OF_CLOSING_BRACKET) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberOfInfo(List<String> dividedInfoValue) {
        if (dividedInfoValue.size() != NUMBER_OF_INFO_ITEM_INVENTORY_INPUT_TO_HAS) {
            throw new IllegalArgumentException();
        }
    }

    private String removeBracket() {
        return input.substring(LENGTH_OF_OPENING_BRACKET, input.length() - LENGTH_OF_CLOSING_BRACKET);
    }

    private String[] splitByComma(String itemInventoryInfoValue) {
        return itemInventoryInfoValue.split(COMMA_DELIMITER_BETWEEN_KINDS_OF_ITEM_INFO);
    }

    private void validateItemQuantity(int quantity) {
        if (quantity < MINIMUM_VALUE_OF_ITEM_QUANTITY) {
            throw new IllegalArgumentException();
        }
    }
}
