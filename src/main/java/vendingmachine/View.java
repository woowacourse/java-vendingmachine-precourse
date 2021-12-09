package vendingmachine;

import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public static void printInitialCoin(Map coins) {
        System.out.println("자판기가 보유한 동전");
        System.out.println("500원 - " + coins.getOrDefault(Coin.COIN_500, 0) + "개");
        System.out.println("100원 - " + coins.getOrDefault(Coin.COIN_100, 0) + "개");
        System.out.println("50원 - " + coins.getOrDefault(Coin.COIN_50, 0) + "개");
        System.out.println("10원 - " + coins.getOrDefault(Coin.COIN_10, 0) + "개");
    }

    public static void printUserBalance(InputAmount inputAmount) {
        System.out.println("투입 금액: " + inputAmount.toString() + "원");
    }

    public static void printCoins(Map<Coin, Integer> coins) {
        System.out.println("잔돈");
        coins.forEach((coin, count) -> System.out.println(coin.getAmount() + "원 - " + count + "개"));
    }

    public static String printIndexPage() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return Console.readLine().replace(" ", "");
    }
}
