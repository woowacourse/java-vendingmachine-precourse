package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MainController {

    VendingMachine vendingMachine = new VendingMachine();

    public void run() {
        vendingMachine.generateRandomCoin(InputView.inputVendingMachineMoney());
        OutputView.printCoinByVendingMachine(vendingMachine.getCoin());
        InputController.makeProductsList(vendingMachine);
        vendingMachine.insertMoney(new Money(InputView.inputMoney()));
        while (vendingMachine.checkAdditionalPurchase()) {
            OutputView.printRemainingAmount(vendingMachine.getMoney());
            vendingMachine.buyProduct(InputView.inputProductToPurchase());
        }
    }
}
