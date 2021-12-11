package vendingmachine.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import vendingmachine.Coin;

public class OutputView {

    private static final String CHANGE_INFO_MESSAGE = "자판기가 보유한 동전";
    private static final String CHANGE = "잔돈";
    private static final String MONEY_INFO_MESSAGE = "투입 금액: %s원%n";
    private static final String CHANGE_STATE = "%s원 - %s개%n";

    public static void printChangesState(Map<Integer, Integer> changes) {
        System.out.println(CHANGE_INFO_MESSAGE);
        for (Coin coin : Coin.values()) {
            int change = coin.getAmount();
            int frequency = changes.get(change);
            System.out.printf(CHANGE_STATE, change, frequency);
        }

    }

    public static void printExistMoney(int money) {
        System.out.printf(MONEY_INFO_MESSAGE, money);
    }

    public static void returnChanges(Map<Integer, Integer> changes) {
        System.out.println(CHANGE);
        for (Integer change : changes.keySet()) {
            int frequency = changes.get(change);
            System.out.printf(CHANGE_STATE, change, frequency);
        }
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
