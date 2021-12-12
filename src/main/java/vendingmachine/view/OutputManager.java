package vendingmachine.view;

import vendingmachine.model.Coin;
import vendingmachine.model.VendingMachine;

public class OutputManager {
    public static void printVendingMachineStatus(VendingMachine vendingMachine) {
        System.out.println("자판기가 보유한 동전");
        for (Coin coin: Coin.values()) {
            int coinCount = vendingMachine.getCoinCount(coin);
            System.out.println(coin + " - " + coinCount + "개");
        }
        System.out.println();
    }

    public static void printCurrentUserAmount(VendingMachine vendingMachine) {
        System.out.println("투입 금액:" + vendingMachine.getRemainderMoney());
    }
}
