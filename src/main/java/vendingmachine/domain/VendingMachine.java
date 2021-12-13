package vendingmachine.domain;

import vendingmachine.utils.ConsolePrinter;
import vendingmachine.utils.UserInput;

public class VendingMachine {

    private ProductSeller productSeller;
    private HoldingAmount holdingAmount;
    private ConsolePrinter printer;

    public VendingMachine() {
        printer = new ConsolePrinter();
        holdingAmount = UserInput.getValidHoldingAmount();
        printer.printHoldingAmount(holdingAmount);
        productSeller = UserInput.getProductSeller();
    }

    public void run() {
        InputAmount inputAmount = UserInput.getValidInputAmount();
        printer.printInputAmount(inputAmount);
        while (productSeller.isPurchaseAvailable(inputAmount)) {
            String productName = UserInput.getProductOrder();
            productSeller.orderProduct(productName, inputAmount);
            printer.printInputAmount(inputAmount);
        }
        printer.printChanges(holdingAmount.returnChanges(inputAmount));
    }
}
