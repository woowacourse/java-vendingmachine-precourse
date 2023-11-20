package controller;

import utils.Parser;
import utils.RepeatInput;
import vendingmachine.*;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class VendingMachineController {

    public void run() {
        MachineAmount vendingMoney = RepeatInput.repeatWhenInvalid(this::vendingMachineMoney);
        OutputView.printVendingMachineCoinAmount(new CoinCounter(), vendingMoney);

        Products productsMap = RepeatInput.repeatWhenInvalid(this::productInformation);

        InputAmount inputAmount = RepeatInput.repeatWhenInvalid(this::inputAmount);

    }

    private MachineAmount vendingMachineMoney() {
        OutputView.printVendingMachineMoney();
        String amount = InputView.readAmountInput();
        int vendingMoney = Parser.convertToInt(amount);
        return new MachineAmount(vendingMoney);
    }

    private Products productInformation() {
        OutputView.printOrderDetails();
        String input = InputView.readOrderDetails();
        Map<String, Product> productMap = Parser.convertToProductMap(input);
        return new Products(productMap);
    }

    private InputAmount inputAmount() {
        OutputView.printInputAmount();
        String amount = InputView.readAmountInput();
        int inputAmount = Parser.convertToInt(amount);
        return new InputAmount(inputAmount);
    }
}
