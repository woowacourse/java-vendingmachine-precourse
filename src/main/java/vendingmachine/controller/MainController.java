package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;

public class MainController {

    VendingMachine vendingMachine = new VendingMachine();

    public void run() {
        vendingMachine.generateRandomCoin(InputView.inputVendingMachineMoney());
        System.out.println(vendingMachine.coinTable);
    }
}
