package vendingmachine.view;

import java.util.Map;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String REMAINING_COINS_MESSAGE = "자판기가 보유한 동전";
    private static final String PRICE_MESSAGE = "원 - ";
    private static final String NUMBER_OF_MESSAGE = "개";

    public static void printRemainingCoins(Map<Integer, Integer> coins) {
        System.out.println(NEW_LINE + REMAINING_COINS_MESSAGE);
        for (int coin : coins.keySet()) {
            System.out.println(coin + PRICE_MESSAGE + coins.get(coin) + NUMBER_OF_MESSAGE);
        }
        System.out.println();
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
