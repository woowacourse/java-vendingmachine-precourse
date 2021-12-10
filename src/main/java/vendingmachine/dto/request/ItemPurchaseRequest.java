package vendingmachine.dto.request;

import vendingmachine.Item;

public class ItemPurchaseRequest {
    private final String input;

    public ItemPurchaseRequest(String input) {
        this.input = input;
    }

    public String toItemNameToPurchase() {
        return input;
    }
}
