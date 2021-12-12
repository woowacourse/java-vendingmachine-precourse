package vendingmachine.Controller;

public class MainController {
    InitController initController = new InitController();
    PurchaseController purchaseController = new PurchaseController();
    ChangeController changeController = new ChangeController();

    public void start() {
        initController.initVendingMachine();
        purchaseController.startPurchasing();
        changeController.returnChange();
    }
}
