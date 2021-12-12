package vendingmachine.view;

import java.util.Map;
import vendingmachine.domain.Coin;

public class OutputView {

    private static final String PRINT_VENDING_MACHINE_OWN_COINS_MESSAGE = "자판기가 보유한 동전";

    private OutputView() {
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printCurrentOwnCoins(Map<Coin, Integer> coins) {
        System.out.println(PRINT_VENDING_MACHINE_OWN_COINS_MESSAGE);
        for (Coin coin : coins.keySet()) {
            System.out.printf("%d원 - %d개\n", coin.amount(), coins.get(coin));
        }
    }
}
