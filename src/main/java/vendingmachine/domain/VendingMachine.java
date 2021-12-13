package vendingmachine.domain;

import vendingmachine.utils.ConsolePrinter;
import vendingmachine.utils.UserInput;

public class VendingMachine {

    private ProductSeller productSeller;
    private CashHolder cashHolder;
    private ConsolePrinter printer;

    public VendingMachine() {
        printer = new ConsolePrinter();
        cashHolder = UserInput.getValidHoldingAmount();
        printer.printHoldingAmount(cashHolder);
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
        printer.printChanges(cashHolder.returnChanges(inputAmount));
    }
}
