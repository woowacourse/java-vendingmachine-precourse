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

        int remainder = RepeatInput.repeatWhenInvalid(() -> purchaseProcess(productsMap, inputAmount));

        OutputView.printRemainChanges(new CoinCounter(), vendingMoney, remainder);


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

    private int purchaseProcess(Products products, InputAmount inputAmount) {
        while(inputAmount.getMoney() >= products.getMininumProduct()) {
            OutputView.printPurchaseProduct(inputAmount);
            String purchaseName = InputView.readPurchaseName(products);
            int purchasePrice = products.findInputAmount(purchaseName);
            inputAmount.subtractMoney(purchasePrice);
        }
        return inputAmount.getMoney();
    }
}
