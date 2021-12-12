package vendingmachine.view;

import java.util.Map;
import vendingmachine.domain.Coin;

public class OutputView {

    private static final String PRINT_VENDING_MACHINE_OWN_COINS_MESSAGE = "자판기가 보유한 동전";
    private static final String PRINT_VENDING_MACHINE_REMAIN_MONEY_MESSAGE = "투입 금액: %d원\n";
    private static final String PRINT_CHANGE = "잔돈";
    private static final String PRINT_CHANGE_COIN_MESSAGE = "%d원 - %d개\n";

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

    public static void printCurrentMoney(int money) {
        System.out.printf(PRINT_VENDING_MACHINE_REMAIN_MONEY_MESSAGE, money);
    }

    public static void printChangeCoins(Map<Coin, Integer> coins) {
        System.out.println(PRINT_CHANGE);
        for (Coin coin : coins.keySet()) {
            printRemainCoin(coins, coin);
        }
    }

    private static void printRemainCoin(Map<Coin, Integer> coins, Coin coin) {
        if (coins.get(coin) != 0) {
            System.out.printf(PRINT_CHANGE_COIN_MESSAGE, coin.amount(), coins.get(coin));
        }
    }
}
