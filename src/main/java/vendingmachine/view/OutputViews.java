package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.Map;

public class OutputViews {
    public static final String PRINT_MACHINE_COIN_MESSAGE = "\n자판기가 보유한 동전";
    public static final String REMAIN_MONEY = "잔돈";
    public static final String INSERT_MONEY = "\n투입 금액: ";
    public static final String WON = "원";
    public static final String COIN_PRINT_SEPORATOR = " - ";
    public static final String COIN_PRINT_UNIT = "개";

    public static void printMachineInitCoin(Map<Coin, Integer> remainCoin) {
        System.out.println(PRINT_MACHINE_COIN_MESSAGE);
        for (Coin c : remainCoin.keySet()) {
            System.out.println(c.getAmount() + WON + COIN_PRINT_SEPORATOR + remainCoin.get(c) + COIN_PRINT_UNIT);
        }
    }

    public static void printFinalChange(Map<Coin, Integer> finalChange) {
        System.out.println(REMAIN_MONEY);
        for (Coin coin : finalChange.keySet()) {
            System.out.println(coin.getAmount() + WON + COIN_PRINT_SEPORATOR + finalChange.get(coin) + COIN_PRINT_UNIT);
        }
    }

    public static void printCurrentChange(int change) {
        System.out.println(INSERT_MONEY + change + WON);
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
