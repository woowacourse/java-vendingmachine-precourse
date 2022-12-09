package vendingmachine.controller;

import vendingmachine.domain.*;
import vendingmachine.domain.coins.Coins;
import vendingmachine.domain.coins.RandomNumberGenerator;
import vendingmachine.domain.products.Products;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.function.Supplier;

public class VendingMachineController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private VendingMachine vendingMachine;

    public void runVendingMachine() {
        makeVendingMachine();
    }

    private void makeVendingMachine() {
        Money money = askMoney();
        Coins coins = makeCoins(money);
        Products products = askProducts();

        vendingMachine = VendingMachine.of(money, coins, products);
    }

    private Products askProducts() {
        outputView.printInputProducts();
        Products products = reenterProcess(inputView::readProducts);
        outputView.printNewLine();
        return products;
    }

    private Coins makeCoins(Money money) {
        Coins coins = new Coins();
        coins.makeRandomCoins(new RandomNumberGenerator(), money);
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
