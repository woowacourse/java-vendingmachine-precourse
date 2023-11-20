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
        int money = Parser.convertToInt(amount);
        return new Amount(money);
    }
}
