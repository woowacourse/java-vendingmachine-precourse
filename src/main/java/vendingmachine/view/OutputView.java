package vendingmachine.view;

import static vendingmachine.Messages.*;

import java.util.Map;

public class OutputView {

    public void printVendingMachineCoin() {
        System.out.println(OUTPUT_VENDING_MACHINE_COIN);
    }

    public void printCoins(Map<Integer, Integer> vendingMachineCoins) {
        vendingMachineCoins.forEach((key, value) -> System.out.println(key + WON_AND_HYPHEN + value + GAE));
    }

    public void printPurchasingProcess(int money) {
        System.out.printf(OUTPUT_MONEY, money);
    }

    public void printRemainingCoins(Map<Integer, Integer> chargeCoins, int money) {
        printPurchasingProcess(money);
        System.out.println(OUTPUT_CHARGE);
        printCoins(chargeCoins);
    }
}
