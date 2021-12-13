package vendingmachine.view;

import vendingmachine.domain.Money;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class OutputView {

    private static final String COINS_HELD_BY_VENDING_MACHINE_MESSAGE = "자판기가 보유한 동전";
    private static final String REMAINING_AMOUNT_MESSAGE = "투입 금액: ";
    private static final String CHANGES_MESSAGE = "잔돈";
    private static final String WON = "원";
    private static final String DASH = " - ";
    private static final String UNIT = "개";
    private static final String LINE_SEPARATOR = "\n";

    public static void printCoinByVendingMachine(HashMap<Integer, Integer> coinTable) {
        System.out.println(LINE_SEPARATOR + COINS_HELD_BY_VENDING_MACHINE_MESSAGE);
        Object[] sortedCoin = coinTable.keySet().toArray();
        Arrays.sort(sortedCoin, Collections.reverseOrder());
        for (Object coin : sortedCoin) {
            System.out.println(coin + WON + DASH + coinTable.get(coin) + UNIT);
        }
    }

    public static void printRemainingAmount(Money money) {
        System.out.println(REMAINING_AMOUNT_MESSAGE + money.getCost() + WON);
    }

    public static void printChanges(HashMap<Integer, Integer> changes) {
        System.out.println(CHANGES_MESSAGE);
        Object[] sortedCoin = changes.keySet().toArray();
        Arrays.sort(sortedCoin, Collections.reverseOrder());
        for (Object coin : sortedCoin) {
            if (changes.get(coin) != 0) {
                System.out.println(coin + WON + DASH + changes.get(coin) + UNIT);
            }
        }
    }
}
