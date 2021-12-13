package vendingmachine.view;

import vendingmachine.model.Coin;
import vendingmachine.model.VendingMachine;

import java.util.HashMap;

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
        System.out.println("투입 금액: " + vendingMachine.getRemainderMoney() + "원");
    }

    public static void printRemainderCoinCount(HashMap<Coin, Integer> remainderCoinCount) {
        System.out.println("잔돈");
        for (Coin coin : Coin.values()) {
            int count = remainderCoinCount.get(coin);
            if (count != 0) {
                System.out.println(coin + " - " + count + "개");
            }
        }
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printBlank() {
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

}
