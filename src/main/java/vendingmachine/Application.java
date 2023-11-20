package vendingmachine;

import vendingmachine.coin.generator.RandomCoinGenerator;
import vendingmachine.controller.InitialController;
import vendingmachine.controller.PurchaseController;

public class Application {
    private static final InitialController initialController = new InitialController();
    private static final PurchaseController purchaseController = new PurchaseController();

    public static void main(String[] args) {
        VendingMachine vendingMachine = initialController.create(new RandomCoinGenerator());
        purchaseController.purchase(vendingMachine);

    }
}
