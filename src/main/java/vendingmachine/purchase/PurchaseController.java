package vendingmachine.purchase;

import vendingmachine.VendingMachineConsole;

public class PurchaseController {
    private final PurchaseService purchaseService;
    private final VendingMachineConsole vendingMachineConsole;

    public PurchaseController(PurchaseService purchaseService, VendingMachineConsole vendingMachineConsole) {
        this.purchaseService = purchaseService;
        this.vendingMachineConsole = vendingMachineConsole;
    }

    public void start() {
        insertMoney();
        purchase();
        getChanges();
    }

    private void insertMoney() {
        purchaseService.insertMoney(vendingMachineConsole.inputAvailableMoney());
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
        vendingMachineConsole.printChange(purchaseService.giveChange());
    }

    private void showAvailableMoney() {
        vendingMachineConsole.printAvailableMoney(purchaseService.showAvailableMoney());
    }

    private void purchaseByItemName() {
        purchaseService.purchaseByItemName(vendingMachineConsole.inputItemsToPurchase());
    }

    private void showErrorMessage(String errorMessage) {
        vendingMachineConsole.printErrorMessage(errorMessage);
    }
}
