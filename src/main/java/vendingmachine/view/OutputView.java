package vendingmachine.view;

import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Customer;

import java.util.HashMap;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String CHANGE_IN_VENDING_MACHINE_MESSAGE = "자판기가 보유한 동전";
    private static final String PRINT_MONEY_PREFIX = "투입 금액: ";
    private static final String PRINT_MONEY_SUFFIX = "원";
    private static final String PRINT_CHANGE = "잔돈";
    private static final String PRINT_COIN_PREFIX = "원 - ";
    private static final String PRINT_COIN_SUFFIX = "개";

    public void printCoinList(Change change) {
        HashMap<Coin, Integer> coinStorage = change.getCoinStorage();
        System.out.println(NEW_LINE + CHANGE_IN_VENDING_MACHINE_MESSAGE);
        for (Coin coin : Coin.values()) {
            System.out.println(coin.getAmount() + PRINT_COIN_PREFIX + coinStorage.get(coin) + PRINT_COIN_SUFFIX);
        }
    }

    public void printMoney(int money) {
        System.out.println(NEW_LINE + PRINT_MONEY_PREFIX + money + PRINT_MONEY_SUFFIX);
    }

    public void printChange(Customer customer) {
        System.out.println(PRINT_CHANGE);
        HashMap<Coin, Integer> coinStorage = customer.getCoinStorage();
        for (Coin coin : Coin.values()) {
            if (coinStorage.get(coin) != null) {
                System.out.println(coin.getAmount() + PRINT_COIN_PREFIX + coinStorage.get(coin) + PRINT_COIN_SUFFIX);
            }
        }
    }

    public void printError(String error) {
        System.out.println(error + NEW_LINE);
    }

}
