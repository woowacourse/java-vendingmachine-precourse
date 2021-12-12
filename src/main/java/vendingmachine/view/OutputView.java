package vendingmachine.view;

import vendingmachine.domain.enums.Coin;

import java.util.HashMap;

public class OutputView {

    public static void printCoinsInfo(HashMap<Coin, Integer> coins) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n자판기가 보유한 동전\n");

        for (Coin coin : Coin.getCoinsDesc()) {
            sb.append(coin.getAmountFormat()).append(" - ");
            sb.append(coins.get(coin)).append("개");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void printMoneyLeft(int moneyLeft) {
        System.out.println("\n투입 금액: " + moneyLeft + "원");
    }

    public static void printCoinChanges(HashMap<Coin, Integer> coinChanges) {
        StringBuilder sb = new StringBuilder();
        sb.append("잔돈\n");

        for (Coin coin : coinChanges.keySet()) {
            sb.append(coin.getAmountFormat()).append(" - ");
            sb.append(coinChanges.get(coin)).append("개");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}