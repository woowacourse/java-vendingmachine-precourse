package vendingmachine.controller;

import java.util.Map;
import vendingmachine.VendingMachine;
import vendingmachine.coin.Coin;
import vendingmachine.exception.RetryExceptionHandler;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class PurchaseController {
    public void purchase(VendingMachine machine) {
        while (machine.isSellable()) {
            RetryExceptionHandler.run(() ->purchaseMenu(machine));
        }
        printResult(machine);
    }

    private void printResult(VendingMachine machine) {
        printRemainMoney(machine);
        Map<Coin, Integer> coinIntegerMap = machine.giveChange();
        OutputView.printChange(coinIntegerMap);
    }

    private static void purchaseMenu(VendingMachine machine) {
        printRemainMoney(machine);
        String menuName = InputView.getMenuName();
        machine.purchase(menuName);
    }

    private static void printRemainMoney(VendingMachine machine) {
        int remainMoney = machine.getRemainMoney();
        OutputView.printRemainMoney(remainMoney);
    }


}
