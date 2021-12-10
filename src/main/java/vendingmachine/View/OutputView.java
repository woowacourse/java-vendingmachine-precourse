package vendingmachine.View;

import vendingmachine.constant.SystemMessage;
import vendingmachine.domain.Coin;

public class OutputView {
    public static void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printCoinStatus(Coin coin) {
        System.out.println(SystemMessage.COIN_STATUS_MESSAGE.print());
        for (Coin c : coin.values()) {
            System.out.println(c.toString());
        }
    }
}
