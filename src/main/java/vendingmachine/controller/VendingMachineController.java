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
    private Money playerMoney;

    public void runVendingMachine() {
        makeVendingMachine();
        operateVendingMachine();
        showResult();
    }

    private String askBuyingProduct() {
        outputView.printRemainMoney(playerMoney);
        outputView.printInputProductName();
        String name = inputView.readProductName();
        outputView.printNewLine();
        return name;
    }

    private void makeVendingMachine() {
        Money money = askMachineMoney();
        Coins coins = makeCoins(money);
        Products products = askProducts();

        vendingMachine = VendingMachine.of(coins, products);
    }

    private Money askMachineMoney() {
        outputView.printInputVendingMachineAmount();
        Money money = reenterProcess(inputView::readMoney);
        outputView.printNewLine();
        return money;
    }

    private Coins makeCoins(Money money) {
        Coins coins = new Coins();
        coins.makeRandomCoins(new RandomNumberGenerator(), money);
        outputView.printVendingMachineCoins(coins);
        return coins;
    }

    private Products askProducts() {
        outputView.printInputProducts();
        Products products = reenterProcess(inputView::readProducts);
        outputView.printNewLine();
        return products;
    }

    private void operateVendingMachine() {
        playerMoney = askPlayerMoney();
        while (vendingMachine.isSellProduct(playerMoney)) {
            buyProduct();
        }
    }

    private Money askPlayerMoney() {
        outputView.printInputMoney();
        Money money = reenterProcess(inputView::readMoney);
        outputView.printNewLine();
        return money;
    }

    private void buyProduct() {
        while (true) {
            try {
                vendingMachine.purchaseProduct(askBuyingProduct(), playerMoney);
                return;
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }

    private void showResult() {
        outputView.printRemainMoney(playerMoney);
        outputView.printChanges(vendingMachine.makeChanges(playerMoney));
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
