package vendingmachine.Service;

import vendingmachine.Domain.VendingMachine;
import vendingmachine.Validation.ProductToPurchaseValidation;

public class PurchaseService {
    ProductToPurchaseValidation validation = new ProductToPurchaseValidation();

    public void purchase(String name) {
        validation.isValid(name);
        VendingMachine.findAndPurchase(name);
    }

    public boolean isAvailable() {
        return VendingMachine.isAnyThingToPurchase();
    }

}
