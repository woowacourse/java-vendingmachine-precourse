package vendingmachine.View;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

import java.util.ArrayList;

public class OutputView {
    public static void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printCoinStatus(Coin coin) {
        for (Coin c : coin.values()) {
            System.out.println(c.toString());
        }
    }
}
