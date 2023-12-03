package vendingmachine.controller;

import vendingmachine.domain.Items;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine.ItemName;
import vendingmachine.domain.VendingMachine.VendingMachine;
import vendingmachine.domain.VendingMachine.Wallet;
import vendingmachine.util.ExceptionHandler;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.function.Supplier;

public class VendingMachineController {

    public static void play() {
        VendingMachine vendingMachine = getVendingMachine();
        OutputView.printVendingMachineCoins(vendingMachine);
        Money money = repeat(InputView::getMoney);
        money = buyItems(money, vendingMachine);
        OutputView.printRest(money);
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
            money = vendingMachine.buy(itemName, money);
        }
        return money;
    }

    private static boolean isNotAvailable(VendingMachine vendingMachine, Money money) {
        return vendingMachine.isEmpty() || !vendingMachine.containsAvailableItem(money.getMoney());
    }

    private static <T> T repeat(Supplier<T> supplier) {
        return ExceptionHandler.repeat(supplier, OutputView::printException);
    }

}
