package controller;

import utils.Parser;
import vendingmachine.Amount;
import view.InputView;
import view.OutputView;

public class VendingMachineController {

    public void run() {
        vendingMachineMoney();
    }

    private Amount vendingMachineMoney() {
        OutputView.printVendingMachineMoney();
        String amount = InputView.readVendingMachineMoney();
        return new Amount(amount);
    }
}
