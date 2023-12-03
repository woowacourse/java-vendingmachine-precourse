package vendingmachine.controller;

import vendingmachine.domain.VendingMachine.Item;
import vendingmachine.domain.VendingMachine.ItemName;
import vendingmachine.domain.VendingMachine.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    public static void play() {
        VendingMachine vendingMachine = InputView.getVendingMachine();
        OutputView.printVendingMachineCoins(vendingMachine);
        int money = InputView.getMoney();
        while (true) {
            OutputView.printMoney(money);
            if (isNotAvailable(vendingMachine, money)) {
                break;
            }
            ItemName itemName = InputView.getItemToBuy();
            money = vendingMachine.buy(itemName, money);
        }
    }

    private static boolean isNotAvailable(VendingMachine vendingMachine, int money) {
        return vendingMachine.isEmpty() || !vendingMachine.containsAvailableItem(money);
    }

}
