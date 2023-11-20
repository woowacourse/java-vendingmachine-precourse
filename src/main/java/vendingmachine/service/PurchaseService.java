package vendingmachine.service;

import vendingmachine.domain.Products;

public class PurchaseService {
    private final Products products;
    private final int inputAmount;

    public PurchaseService(final Products products, final int inputAmount) {
        this.products = products;
        this.inputAmount = inputAmount;
    }


    public static PurchaseService of(final Products products, final Integer inputAmount) {
        return new PurchaseService(products, inputAmount);
    }
}
