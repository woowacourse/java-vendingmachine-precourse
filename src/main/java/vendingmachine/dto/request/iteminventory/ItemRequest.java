package vendingmachine.dto.request.iteminventory;

import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_WRONG_ITEM_NAME_INPUT;
import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_WRONG_ITEM_PRICE_INPUT;

import vendingmachine.dto.ItemInfo;

public class ItemRequest {
    private static final int MINIMUM_VALUE_OF_ITEM_PRICE = 100;
    private static final int MINIMUM_CURRENCY_UNIT = 10;
    private final String nameInput;
    private final String priceInput;

    public ItemRequest(String nameInput, String priceInput) {
        this.nameInput = nameInput;
        this.priceInput = priceInput;
    }

    public ItemInfo toItemInfo() {
        return new ItemInfo(toItemName(nameInput), toItemPrice(priceInput));
    }

    private String toItemName(String nameInput) {
        validateName(nameInput);
        return nameInput;
    }

    private int toItemPrice(String priceInput) {
        int price;
        try {
            price = Integer.parseInt(priceInput);
            validatePrice(price);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_ITEM_PRICE_INPUT);
        }
        return price;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_ITEM_NAME_INPUT);
        }
    }

    private void validatePrice(int price) {
        if (price < MINIMUM_VALUE_OF_ITEM_PRICE || price % MINIMUM_CURRENCY_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }
}
