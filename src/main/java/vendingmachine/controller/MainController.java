package vendingmachine.controller;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MainController {

    VendingMachine vendingMachine = new VendingMachine();

    public void run() {
        processOfGeneratingCoins();
        OutputView.printCoinByVendingMachine(vendingMachine.getCoin());
        InputController.makeProductsList(vendingMachine);
        processOfInsertMoney();
        while (vendingMachine.checkAdditionalPurchase()) {
            OutputView.printRemainingAmount(vendingMachine.getMoney());
            processOfBuyingProduct();
        }
        processOfPrintingChanges();
    }

    private void processOfGeneratingCoins() {
        try {
            vendingMachine.generateCoins(InputView.inputVendingMachineMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            processOfGeneratingCoins();
        }
    }

    private void processOfInsertMoney() {
        try {
            vendingMachine.insertMoney(new Money(InputView.inputMoney()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            processOfInsertMoney();
        }
    }

    private void processOfBuyingProduct() {
        try {
            vendingMachine.buyProduct(InputView.inputProductToPurchase());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            processOfBuyingProduct();
        }
    }

    private void processOfPrintingChanges() {
        Changes changes = new Changes();
        changes.makeChanges(vendingMachine.getCoin(), vendingMachine.getMoney());
        OutputView.printChanges(changes.getChanges());
    }
}
