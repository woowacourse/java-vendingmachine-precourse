package vendingmachine.view;

import vendingmachine.Coin;

import java.util.Map;

public class OutputView {

    public static void printBalanceCoin(Map<Coin, Integer> coins) {
        System.out.println("\n자판기가 보유한 동전");

        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            System.out.println(entry.getKey().get() + "원 - " + entry.getValue() + "개");
        }
    }
    public static void printAmountOfInput(int amountOfInput) {
        System.out.println("\n투입 금액: " + amountOfInput + "원");
    }

    public static void printChange(Map<Coin, Integer> balanceCoins) {
        System.out.println("잔돈");
        for (Map.Entry<Coin, Integer> entry : balanceCoins.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(entry.getKey().get() + "원 - " + entry.getValue() + "개");
            }
        }
    }
}
