package vendingmachine.view;

import java.util.Map;
import vendingmachine.Coin;
import vendingmachine.Money;
import vendingmachine.message.ExceptionMessage;
import vendingmachine.message.ViewMessage;

public class OutputView {
    public static void printError(IllegalArgumentException error) {
        System.out.println(ExceptionMessage.ERROR_PREFIX + error.getMessage());
    }
    public static void printHoldingCoins(Map<Coin, Integer> coinMap) {
        System.out.println();
        System.out.println(ViewMessage.OUTPUT_HOLDING_COIN_PRE_MESSAGE);
        printCoins(coinMap);
    }

    public static void printChangeCoins(Map<Coin, Integer> coinMap) {
        System.out.println(ViewMessage.OUTPUT_CHANGE);
        printCoins(coinMap);
    }

    public static void printCoins(Map<Coin, Integer> coinMap) {
        Coin.getCoinOrderedList().forEach((coin) -> {
            System.out.printf(ViewMessage.OUTPUT_COIN_FORMAT, coin.getAmount(), coinMap.getOrDefault(coin, 0));
        });
        System.out.println();
    }

    public static void printLeftMoney(Money money) {
        System.out.println();
        System.out.printf(ViewMessage.OUTPUT_MONEY_FORMAT, money.getAmount());
    }
}
