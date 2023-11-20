package controller;

import utils.Parser;
import view.InputView;
import view.OutputView;

public class VendingMachineController {

    public void run() {
        vendingMachineMoney();
    }

    private int vendingMachineMoney() {
        OutputView.printVendingMachineMoney();
        String amount = InputView.readVendingMachineMoney();
        return Parser.convertToInt(amount);
    }
}
