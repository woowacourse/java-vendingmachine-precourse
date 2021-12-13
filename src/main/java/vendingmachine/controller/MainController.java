package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MainController {

    VendingMachine vendingMachine = new VendingMachine();

    public void run() {
        vendingMachine.generateRandomCoin(InputView.inputVendingMachineMoney());
        OutputView.printCoinByVendingMachine(vendingMachine.getCoin());
        InputController.makeProductsList(vendingMachine);
        System.out.println(InputView.inputMoney());
    }
}
