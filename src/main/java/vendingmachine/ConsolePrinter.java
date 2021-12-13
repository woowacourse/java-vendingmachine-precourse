package vendingmachine;

import java.util.Map;

public class ConsolePrinter {
    private ConsolePrinter() {}

    public static void printCoins(Map<Coin, Integer> coinMap, Message headMessage) {
        System.out.println(headMessage.getMessage());
        for (Coin coin : coinMap.keySet()) {
            System.out.println(coin.getAmount() + "원 - " + coinMap.get(coin) + "개");
        }
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printUserAmount(int userAmount) {
        System.out.println("투입 금액: " + userAmount + "원");
    }
}
