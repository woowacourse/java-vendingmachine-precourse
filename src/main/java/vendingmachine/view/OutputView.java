package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;

import java.util.Map;

public class OutputView {
    private OutputView() {
    }

    public static void printCoins(Coins coins) {
        System.out.println("자판기가 보유한 동전");
        Map<Coin, Integer> map = coins.getCoins();
        map.forEach((k, v) -> System.out.println(k.getAmount() + "원 - " + v + "개"));
        System.out.println();
    }

    public static void printCurrentUsersMoney(int currentUsersMoney) {
        System.out.println("투입 금액: " + currentUsersMoney + "원");
    }
}
