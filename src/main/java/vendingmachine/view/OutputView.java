package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinCase;
import vendingmachine.domain.VendingMachine;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String HOLDING_COIN_INFO_MESSAGE = "자판기가 보유한 동전";
    private static final String NUMBER_UNIT = "개";
    private static final String INSERT_AMOUNT_INFO_MESSAGE = "투입 금액: ";
    private static final String WON_UNIT = "원";
    private static final String CHANGE_INFO_MESSAGE = "잔돈";
    private static final String ERROR_SYMBOL = "[ERROR] ";

    public static void printHoldingCoins(final HashMap<Coin, Integer> holdingCoins) {
        System.out.println(HOLDING_COIN_INFO_MESSAGE);
        for (Coin coin : Coin.getCoinListDecreasingOrder()) {
            System.out.print(coin.toString());
            System.out.print(holdingCoins.get(coin));
            System.out.println(NUMBER_UNIT);
        }
        System.out.print(NEW_LINE);
    }

    public static void printInsertAmount(final int insertAmount) {
        System.out.print(INSERT_AMOUNT_INFO_MESSAGE);
        System.out.println(insertAmount + WON_UNIT);
    }

    public static void printChangeInfoMessage() {
        System.out.println(CHANGE_INFO_MESSAGE);
    }

    public static void printChangeCoins(final Coin coin, final int numberOfChangeCoins) {
        if (numberOfChangeCoins > 0) {
            System.out.print(coin.toString());
            System.out.print(numberOfChangeCoins);
            System.out.println(NUMBER_UNIT);
        }
    }

    public static void printErrorMessage(final String errorMessage) {
        System.out.println(ERROR_SYMBOL + errorMessage);
    }

}
