package vendingmachine.controller;

import vendingmachine.domain.*;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.function.Supplier;

public class VendingMachineController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private VendingMachine vendingMachine;

    public void runVendingMachine() {
        makeCoins();
    }

    private Coins makeCoins() {
        Coins coins = new Coins();
        coins.makeRandomCoins(new RandomNumberGenerator(), askMoney());
        outputView.printCoins(coins);
        return coins;
    }

    private Money askMoney() {
        outputView.printInputVendingMachineAmount();
        Money money = reenterProcess(inputView::readMoney);
        outputView.printNewLine();
        return money;
    }

    private <T> T reenterProcess(Supplier<T> reader) {
        while (true) {
            try {
                return reader.get();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }
}
