package controller;

import utils.Parser;
import utils.RepeatInput;
import vendingmachine.MachineAmount;
import vendingmachine.CoinCounter;
import view.InputView;
import view.OutputView;

public class VendingMachineController {

    public void run() {
        MachineAmount amount = RepeatInput.repeatWhenInvalid(this::vendingMachineMoney);
        OutputView.printVendingMachineCoinAmount(new CoinCounter(), amount);

        OutputView.printOrderDetails();
        InputView.readOrderDetails();
    }

    private MachineAmount vendingMachineMoney() {
        OutputView.printVendingMachineMoney();
        String amount = InputView.readVendingMachineMoney();
        int money = Parser.convertToInt(amount);
        return new MachineAmount(money);
    }
}
