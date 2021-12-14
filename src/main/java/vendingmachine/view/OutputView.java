package vendingmachine.view;

import vendingmachine.model.HoldingCoins;
import vendingmachine.model.VendingMachine;

public class OutputView {
    private static final String CHANGE = "잔돈";
    private static final String HOLDING_COINS = "자판기가 보유한 동전";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String AMOUNT_UNIT = "원";
    private static final String TO_STRING_INPUT_AMOUNT_PREFIX = "투입 금액: ";

    public static void printHoldingCoins(HoldingCoins holdingCoins) {
        System.out.println(HOLDING_COINS);
        System.out.println(holdingCoins);
    }

    public static void printInputAmount(VendingMachine vendingMachine) {
        System.out.println(TO_STRING_INPUT_AMOUNT_PREFIX + vendingMachine.getInputAmount() + AMOUNT_UNIT);
    }

    public static void printChanges(VendingMachine vendingMachine) {
        System.out.println(CHANGE);
        System.out.println(vendingMachine.getChange());
    }

    public static void printError(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
