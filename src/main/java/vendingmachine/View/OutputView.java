package vendingmachine.View;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

import java.util.ArrayList;

public class OutputView {
    public static void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printCoinStatus(ArrayList<Integer> coinCount) {
        int i = 0;
        for (Coin coin : Coin.values()) {
            System.out.println(coin.getName() + " - " + coinCount.get(i) + "개");
            i++;
        }
    }
}
