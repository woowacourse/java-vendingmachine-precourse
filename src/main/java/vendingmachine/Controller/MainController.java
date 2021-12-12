package vendingmachine.Controller;

public class MainController {
    InitController initController = new InitController();
    PurchaseController purchaseController = new PurchaseController();

    public void start() {
        initController.initVendingMachine();
        purchaseController.startPurchasing();
    }
}
