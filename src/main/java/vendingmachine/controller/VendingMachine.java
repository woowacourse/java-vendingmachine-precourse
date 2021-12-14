package vendingmachine.controller;

import vendingmachine.domain.HoldingAmount;
import vendingmachine.domain.InputAmount;
import vendingmachine.service.Products;
import vendingmachine.io.ConsolePrinter;
import vendingmachine.io.UserInput;

public class VendingMachine {

    private final Products products;
    private final HoldingAmount holdingAmount;
    private final ConsolePrinter printer;

    public VendingMachine() {
        printer = new ConsolePrinter();
        holdingAmount = UserInput.getValidHoldingAmount();
        printer.printHoldingAmount(holdingAmount);
        products = UserInput.getProductSeller();
    }

    public void run() {
        InputAmount inputAmount = UserInput.getValidInputAmount();
        printer.printInputAmount(inputAmount);
        while (products.isPurchaseAvailable(inputAmount)) {
            String productName = UserInput.getProductOrder();
            order(productName, inputAmount);
            printer.printInputAmount(inputAmount);
        }
        printer.printChanges(holdingAmount.returnChanges(inputAmount));
    }

    private void order(String name, InputAmount inputAmount) {
        try {
            products.orderProduct(name, inputAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            order(name, inputAmount);
        }
    }
}
