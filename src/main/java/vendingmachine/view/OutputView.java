package vendingmachine.view;

import vendingmachine.model.Coin;

import java.util.Map;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String REMAINING_COINS_MESSAGE = "자판기가 보유한 동전";
    private static final String PRICE_MESSAGE = "원 - ";
    private static final String NUMBER_OF_MESSAGE = "개";

    public static void printRemainingCoins(Map<Coin, Integer> coins) {
        System.out.println(NEW_LINE + REMAINING_COINS_MESSAGE);
        for (Coin coin : coins.keySet()) {
            System.out.println(coin.getAmount() + PRICE_MESSAGE + coins.get(coin) + NUMBER_OF_MESSAGE);
        }
        System.out.println();
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
