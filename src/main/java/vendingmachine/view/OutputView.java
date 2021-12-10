package vendingmachine.view;

import vendingmachine.model.Coin;

import java.util.Map;

public class OutputView {
    private static final String REMAINING_COINS_MESSAGE = "자판기가 보유한 동전";
    private static final String INSERT_AMOUNT_MESSAGE = "투입 금액: ";
    private static final String NUMBER_OF_MESSAGE = "개";
    private static final String CHANGES_MESSAGE = "잔돈";
    private static final String PRICE_MESSAGE = "원";
    private static final String NEW_LINE = "\n";
    private static final String DASH = " - ";

    public static void printRemainingCoins(Map<Coin, Integer> coins) {
        System.out.println(NEW_LINE + REMAINING_COINS_MESSAGE);
        for (Coin coin : coins.keySet()) {
            System.out.println(coin.getAmount() + PRICE_MESSAGE + DASH + coins.get(coin) + NUMBER_OF_MESSAGE);
        }
        System.out.println();
    }

    public static void printRemainingInsertAmount(int amount) {
        System.out.println(NEW_LINE + INSERT_AMOUNT_MESSAGE + amount + PRICE_MESSAGE);
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printChanges(Map<Coin, Integer> changes) {
        System.out.println(CHANGES_MESSAGE);
        for (Coin change : changes.keySet()) {
            System.out.println(change.getAmount() + PRICE_MESSAGE + DASH + changes.get(change) + NUMBER_OF_MESSAGE);
        }
        System.out.println();
    }
}
