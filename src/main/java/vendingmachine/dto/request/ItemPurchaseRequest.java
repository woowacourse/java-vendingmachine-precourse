package vendingmachine.dto.request;

import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_EMPTY_ITEM_TO_PURCHASE_INPUT;

public class ItemPurchaseRequest {
    private final String input;

    public ItemPurchaseRequest(String input) {
        this.input = input;
    }

    public String toItemNameToPurchase() {
        validate(input);
        return input;
    }

    private void validate(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_EMPTY_ITEM_TO_PURCHASE_INPUT);
        }
    }
}
