package vendingmachine.view;

import java.util.Map;
import vendingmachine.domain.Coin;

public class OutputView {

    private OutputView() {
    }

    public static void printCoinsOfVendingMachine(Map<Coin, Integer> coins) {
        System.out.println("자판기가 보유한 동전");
        for (Coin coin : coins.keySet()) {
            System.out.println(coin.getAmount() + "원 - " + coins.get(coin) + "개");
        }
    }

    public static void printRemainingInputAmount(int amount) {
        System.out.println("투입 금액: " + amount + "원");
    }

    public static void printChanges(Map<Coin, Integer> coins) {
        System.out.println("잔돈");
        for (Coin coin : coins.keySet()) {
            System.out.println(coin.getAmount() + "원 - " + coins.get(coin) + "개");
        }
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
