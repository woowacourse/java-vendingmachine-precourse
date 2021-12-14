package vendingmachine.controller;

import vendingmachine.ApplicationConsole;
import vendingmachine.service.PurchaseService;

public class PurchaseController {
    private final PurchaseService purchaseService;
    private final ApplicationConsole applicationConsole;

    public PurchaseController(PurchaseService purchaseService, ApplicationConsole applicationConsole) {
        this.purchaseService = purchaseService;
        this.applicationConsole = applicationConsole;
    }

    public void start() {
        insertMoney();
        purchase();
        getChanges();
    }

    private void insertMoney() {
        purchaseService.insertMoney(applicationConsole.inputAvailableMoney());
    }

    private void purchase() {
        while (purchaseService.isPurchaseAvailable()) {
            try {
                showAvailableMoney();
                purchaseByItemName();
            } catch (IllegalArgumentException error) {
                showErrorMessage(error.getMessage());
            }
        }
    }

    private void getChanges() {
        showAvailableMoney();
        applicationConsole.printChange(purchaseService.change());
    }

    private void showAvailableMoney() {
        applicationConsole.printAvailableMoney(purchaseService.showAvailableMoney());
    }

    private void purchaseByItemName() {
        purchaseService.purchaseByItemName(applicationConsole.inputItemsToPurchase());
    }

    private void showErrorMessage(String errorMessage) {
        applicationConsole.printErrorMessage(errorMessage);
    }
}
