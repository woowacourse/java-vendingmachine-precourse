package vendingmachine.Controller;

import vendingmachine.Service.PurchaseService;
import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;

public class PurchaseController {
    PurchaseService purchaseService = new PurchaseService();

    public void startPurchasing() {
        OutputView.printInputAmount();
        if (!purchaseService.isAvailable()) {
            return;
        }
        purchase();
        startPurchasing();
    }

    private void purchase() {
        try {
            purchaseService.purchase(InputView.getProductToPurchase());
            InputView.inputOver();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            purchase();
        }
    }
}
