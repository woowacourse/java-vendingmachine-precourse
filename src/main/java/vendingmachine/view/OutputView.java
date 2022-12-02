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
    
}
