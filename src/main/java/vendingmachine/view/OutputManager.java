package vendingmachine.view;

import vendingmachine.ErrorMessage;
import vendingmachine.NormalMessage;
import vendingmachine.model.Coin;
import vendingmachine.model.VendingMachine;

import java.util.HashMap;

public class OutputManager {
    public static void printVendingMachineStatus(VendingMachine vendingMachine) {
        System.out.println(NormalMessage.VENDING_MACHINE_OWNED_COINS);
        for (Coin coin: Coin.values()) {
            int coinCount = vendingMachine.getCoinCount(coin);
            System.out.println(coin + " - " + coinCount + NormalMessage.ITEM_SUFFIX);
        }
        System.out.println();
    }

    public static void printCurrentUserAmount(VendingMachine vendingMachine) {
        System.out.println(NormalMessage.USER_AMOUNT_DISPLAY_GUIDE + vendingMachine.getRemainderMoney() + NormalMessage.AMOUNT_SUFFIX);
    }

    public static void printRemainderCoinCount(HashMap<Coin, Integer> remainderCoinCount) {
        System.out.println(NormalMessage.REMAINDER_AMOUNT);
        for (Coin coin : Coin.values()) {
            int count = remainderCoinCount.get(coin);
            if (count != 0) {
                System.out.println(coin + " - " + count + NormalMessage.COIN_SUFFIX);
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
        System.out.println(ErrorMessage.ERROR_PREFIX + message);
    }

}
