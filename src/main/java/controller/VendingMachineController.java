package controller;

import view.InputView;
import view.OutputView;

public class VendingMachineController {

    public void run() {
        OutputView.printVendingMachineMoney();
        InputView.readVendingMachineMoney();
    }


}
