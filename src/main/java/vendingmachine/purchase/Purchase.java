package vendingmachine.purchase;

import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_TOO_EXPENSIVE_ITEM_TO_PURCHASE;

import vendingmachine.item.Item;

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
}
