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

    public static void printRemainingInputAmount(int amount) {
        System.out.println("투입 금액: " + amount + "원");
    }

    public static void printChanges(Map<String, Integer> coins) {
        System.out.println("잔돈");
        for (String coin : coins.keySet()) {
            System.out.println(coin + " - " + coins.get(coin) + "개");
        }
    }
}
