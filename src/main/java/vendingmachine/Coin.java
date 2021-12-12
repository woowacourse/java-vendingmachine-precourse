package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final String COIN_NAME_PREFIX = "COIN_";
    private static final String PRINT_MESSAGE_NUMBER_OF_COIN_PREFIX = "원 - ";
    private static final String PRINT_MESSAGE_NUMBER_OF_COIN_SUFFIX = "개";
    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Integer> createCoinAmountList() {
        List<Integer> list = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            list.add(coin.amount);
        }
        return list;
    }

    public void printNumberOfCoin(int number) {
        System.out.println(this.amount + PRINT_MESSAGE_NUMBER_OF_COIN_PREFIX + number + PRINT_MESSAGE_NUMBER_OF_COIN_SUFFIX);
    }

    public int calcChangePrice(int amount) {
        return this.amount * amount;
    }

    public int returnChange(int customerMoney, int amount) {
        if (customerMoney < this.amount * amount) {
            amount = customerMoney / this.amount;
        }
        printReturnChange(amount);
        return amount;
    }

    private void printReturnChange(int amount) {
        if (amount == 0) {
            return;
        }
        System.out.println(this.amount + PRINT_MESSAGE_NUMBER_OF_COIN_PREFIX + amount + PRINT_MESSAGE_NUMBER_OF_COIN_SUFFIX);
    }

    public static Coin getCoinByAmount(int amount) {
        return Coin.valueOf(COIN_NAME_PREFIX + amount);
    }
}
