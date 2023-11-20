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

    public void purchase() {
        //TODO : products에 존재하나?
        //현재 금액으로 구매가 가능한가?
    }
}
