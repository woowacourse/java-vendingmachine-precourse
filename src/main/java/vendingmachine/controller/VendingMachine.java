package vendingmachine.controller;

import vendingmachine.domain.Changes;
import vendingmachine.domain.HoldingAmount;
import vendingmachine.domain.InputAmount;
import vendingmachine.service.ProductService;

public class VendingMachine {

    private ProductService productService;
    private HoldingAmount holdingAmount;
    private InputAmount inputAmount;

    public Changes getChanges() {
        return holdingAmount.returnChanges(inputAmount);
    }

    public InputAmount getCurrentInputAmount() {
        return inputAmount;
    }

    public HoldingAmount getHoldingAmount() {
        return this.holdingAmount;
    }

    public void fillHoldingAmount(HoldingAmount holdingAmount) {
        this.holdingAmount = holdingAmount;
    }

    public void addProductSeller(ProductService productService) {
        this.productService = productService;
    }

    public void insertMoney(InputAmount inputAmount) {
        this.inputAmount = inputAmount;
    }

    public void order(String name) throws IllegalArgumentException {
        productService.orderProduct(name, inputAmount);
    }

    public boolean isOrderAvailable() {
        return productService.isPurchaseAvailable(inputAmount);
    }
}
