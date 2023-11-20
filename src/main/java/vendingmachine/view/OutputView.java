package vendingmachine.view;

import java.util.Map;
import vendingmachine.Coin;
import vendingmachine.Money;

public class OutputView {

    public static final String ERROR_PREFIX = "[ERROR] : ";

    public static void printError(IllegalArgumentException error) {
        System.out.println(ERROR_PREFIX + error.getMessage());
    }
    public static void printHoldingCoins(Map<Coin, Integer> coinMap) {
        System.out.println();
        System.out.println("자판기가 보유한 동전");
        printCoins(coinMap);
    }

    public static void printChangeCoins(Map<Coin, Integer> coinMap) {
        System.out.println("잔돈");
        printCoins(coinMap);
    }

    public static void printCoins(Map<Coin, Integer> coinMap) {
        Coin.getCoinOrderedList().forEach((coin) -> {
            System.out.println(coin.getAmount() + "원 - " + coinMap.getOrDefault(coin, 0) + "개");
        });
        System.out.println();
    }

    public static void printLeftMoney(Money money) {
        System.out.println();
        System.out.printf("투입 금액: %d원\n", money.getAmount());
    }


}
