package vendingmachine.view;

import vendingmachine.constants.CoinConstants;

import java.util.HashMap;

public class OutputView {
    public static void printCoinsInfo(HashMap<Integer, Integer> coins) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n자판기가 보유한 동전\n");

        for (Integer value : CoinConstants.getCoinValues()) {
            sb.append(value).append("원 - ");
            sb.append(coins.get(value)).append("개");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void printMoneyLeft(int moneyLeft) {
        System.out.println("\n투입 금액: " + moneyLeft + "원\n");
    }
}