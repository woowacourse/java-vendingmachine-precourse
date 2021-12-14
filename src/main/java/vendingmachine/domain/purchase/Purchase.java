package vendingmachine.domain.purchase;

public class Purchase {
    private int moneyAvailable;

    public Purchase(int moneyAvailable) {
        this.moneyAvailable = moneyAvailable;
    }

    public boolean isAvailable(PurchaseValidator purchaseValidator) {
        return purchaseValidator.isAvailableStatus(this);
    }

    public int showAvailableMoney() {
        return moneyAvailable;
    }

    public boolean isAffordablePrice(int price) {
        if (moneyAvailable >= price) {
            return true;
        }
        return false;
    }

    public void validate(String itemName, PurchaseValidator purchaseValidator) {
        purchaseValidator.validateByItemName(this, itemName);
    }

    public void pay(int price) {
        moneyAvailable -= price;
    }

    public int end() {
        int change = moneyAvailable;
        moneyAvailable = 0;
        return change;
    }
}
