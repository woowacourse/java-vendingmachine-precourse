package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine.ItemName;
import vendingmachine.domain.VendingMachine.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    public static void play() {
        VendingMachine vendingMachine = InputView.getVendingMachine();
        OutputView.printVendingMachineCoins(vendingMachine);
        Money money = InputView.getMoney();
        while (true) {
            OutputView.printMoney(money);
            if (isNotAvailable(vendingMachine, money)) {
                break;
            }
            ItemName itemName = InputView.getItemToBuy();
            money = vendingMachine.buy(itemName, money);
        }
    }

    private static boolean isNotAvailable(VendingMachine vendingMachine, Money money) {
        return vendingMachine.isEmpty() || !vendingMachine.containsAvailableItem(money.getMoney());
    }

}
