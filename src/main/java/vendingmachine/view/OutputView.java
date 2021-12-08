package vendingmachine.view;

import java.util.Map;

public class OutputView {
    public static void printRemainingCoins(Map<Integer, Integer> coins) {
        System.out.println("자판기가 보유한 동전");

        for (int coin : coins.keySet()) {
            System.out.println(coin + "원 - " + coins.get(coin) + "개");
        }
    }
}
