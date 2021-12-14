package vendingmachine.domain.purchase;

import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_TOO_EXPENSIVE_ITEM_TO_PURCHASE;

public class Purchase {
    private int moneyAvailable;

    public Purchase(int moneyAvailable) {
        this.moneyAvailable = moneyAvailable;
    }

    public int showAvailableMoney() {
        return moneyAvailable;
    }

    public boolean isAffordablePrice(int minimumPrice) {
        if (moneyAvailable >= minimumPrice) {
            return true;
        }
        return false;
    }

    public int end() {
        int change = moneyAvailable;
        moneyAvailable = 0;
        return change;
    }

    public void pay(int price) {
        if (!isAffordablePrice(price)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_TOO_EXPENSIVE_ITEM_TO_PURCHASE);
        }
        moneyAvailable -= price;
    }

    public boolean isAvailable(PurchaseValidator purchaseValidator) {
        return purchaseValidator.isAvailableStatus(this);
    }

    public void validate(String itemName, PurchaseValidator purchaseValidator) {
        purchaseValidator.validateByItemName(this, itemName);
    }
}
