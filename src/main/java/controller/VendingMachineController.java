package controller;

import utils.Parser;
import utils.RepeatInput;
import vendingmachine.MachineAmount;
import vendingmachine.CoinCounter;
import vendingmachine.Product;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class VendingMachineController {

    public void run() {
        MachineAmount amount = RepeatInput.repeatWhenInvalid(this::vendingMachineMoney);
        OutputView.printVendingMachineCoinAmount(new CoinCounter(), amount);

        Map<String, Product> productMap = RepeatInput.repeatWhenInvalid(this::productInformation);
    }

    private MachineAmount vendingMachineMoney() {
        OutputView.printVendingMachineMoney();
        String amount = InputView.readVendingMachineMoney();
        int money = Parser.convertToInt(amount);
        return new MachineAmount(money);
    }

    private Map<String, Product> productInformation() {
        OutputView.printOrderDetails();
        String input = InputView.readOrderDetails();
        Map<String, Product> productMap = Parser.convertToProductMap(input);
        return productMap;
    }
}
