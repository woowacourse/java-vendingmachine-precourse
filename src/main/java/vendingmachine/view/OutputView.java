package vendingmachine.view;

import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void printCoinsOfVendingMachine(Map<String, Integer> coins) {
        System.out.println("자판기가 보유한 동전");
        for (String coin : coins.keySet()) {
            System.out.println(coin + " - " + coins.get(coin) + "개");
        }
    }
}
