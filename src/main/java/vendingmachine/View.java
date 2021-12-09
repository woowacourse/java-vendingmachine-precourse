package vendingmachine;

import java.util.Map;

public class View {
    public static void printInitialCoin(Map coins) {
        System.out.println("자판기가 보유한 동전");
        System.out.println("500원 - " + coins.getOrDefault(Coin.COIN_500, 0) + "개");
        System.out.println("100원 - " + coins.getOrDefault(Coin.COIN_100, 0) + "개");
        System.out.println("50원 - " + coins.getOrDefault(Coin.COIN_50, 0) + "개");
        System.out.println("10원 - " + coins.getOrDefault(Coin.COIN_10, 0) + "개");
    }
}
