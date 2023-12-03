package vendingmachine.controller;

import vendingmachine.domain.*;
import vendingmachine.util.ExceptionHandler;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class VendingMachineController {

    public static void play() {
        VendingMachine vendingMachine = getVendingMachine();
        OutputView.printVendingMachineCoins(vendingMachine);
        Money money = repeat(InputView::getMoney);
        money = buyItems(money, vendingMachine);
        List<CoinCount> coinCounts = vendingMachine.getRests(money);
        OutputView.printRest(coinCounts);
    }

    private static VendingMachine getVendingMachine() {
        Wallet wallet = repeat(InputView::getWallet);
        Items items = repeat(InputView::getItems);
        return new VendingMachine(wallet, items);
    }

    private static Money buyItems(Money money, VendingMachine vendingMachine) {
        while (true) {
            OutputView.printMoney(money);
            if (isNotAvailable(vendingMachine, money)) {
                break;
            }
            ItemName itemName = InputView.getItemToBuy();
            repeat(() -> vendingMachine.buy(itemName, money));
        }
        return money;
    }

    private static void repeat(Runnable runnable) {
        ExceptionHandler.repeat(runnable, OutputView::printException);
    }

    private static boolean isNotAvailable(VendingMachine vendingMachine, Money money) {
        return vendingMachine.isEmpty() || !vendingMachine.containsAvailableItem(money.getMoney());
    }

    private static <T> T repeat(Supplier<T> supplier) {
        return ExceptionHandler.repeat(supplier, OutputView::printException);
    }

}
