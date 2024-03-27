package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;

import java.util.Map;
import java.util.Set;

public class OutputView {
    private OutputView() {
    }

    public static void printCoins(Coins coins) {
        System.out.println("자판기가 보유한 동전");
        Map<Coin, Integer> map = coins.getCoins();
        System.out.println("500원 - " + map.get(Coin.COIN_500) + "개");
        System.out.println("100원 - " + map.get(Coin.COIN_100) + "개");
        System.out.println("50원 - " + map.get(Coin.COIN_50) + "개");
        System.out.println("10원 - " + map.get(Coin.COIN_10) + "개");
        System.out.println();
    }

    public static void printChange(Coins change) {
        System.out.println("잔돈");
        Map<Coin, Integer> map = change.getCoins();
        Set<Coin> keys = map.keySet();
        for(Coin key : keys) {
            if(map.get(key) > 0) System.out.println(key.getAmount() + "원 - " + map.get(key) + "개");
        }
    }

    public static void printCurrentUsersMoney(int currentUsersMoney) {
        System.out.println("투입 금액: " + currentUsersMoney + "원");
    }
}
