package vendingmachine.view;

import java.util.Map;
import vendingmachine.Coin;

public class OutputView {

    public static final String ERROR_PREFIX = "[ERROR] : ";

    public static void printError(IllegalArgumentException error) {
        System.out.println(ERROR_PREFIX + error.getMessage());
    }

    public static void printCoins(Map<Coin, Integer> coinMap) {
        Coin.getCoinOrderedList().forEach((coin) -> {
            System.out.println(coin.getAmount() + "원 - " + coinMap.getOrDefault(coin, 0) + "개");
        });
        System.out.println();
    }

    public static void printLeftMoney(int money) {
        System.out.printf("투입 금액: %d원\n", money);
    }

    public static void printLeft() {
        System.out.println("잔돈");
    }
}
