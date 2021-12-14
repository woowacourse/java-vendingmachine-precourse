package vendingmachine.purchase;

import vendingmachine.vendingMachine.VendingMachine;

public class PurchaseValidator {
    private final VendingMachine vendingMachine;

    public PurchaseValidator(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public boolean isAvailable(Purchase purchase) {
        if(vendingMachine.isAllItemsSoldOut()) {
            return false;
        }

        if(!purchase.isAffordablePrice(vendingMachine.findLowestPriceInStock())) {
            return false;
        }
        return true;
    }
}
