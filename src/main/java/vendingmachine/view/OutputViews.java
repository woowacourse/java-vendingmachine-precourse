package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.Map;

public class OutputViews {
    public static final String PRINT_MACHINE_COIN_MESSAGE = "\n자판기가 보유한 동전";

    public static final String WON = "원";
    public static final String COIN_PRINT_SEPORATOR = " - ";
    public static final String COIN_PRINT_UNIT = "개";

    public static void printMachineInitCoin(Map<Coin, Integer> remainCoin) {
        System.out.println(PRINT_MACHINE_COIN_MESSAGE);
        for (Coin c : remainCoin.keySet()) {
            System.out.println(c.getAmount() + WON + COIN_PRINT_SEPORATOR + remainCoin.get(c) + COIN_PRINT_UNIT);
        }
    }

}
