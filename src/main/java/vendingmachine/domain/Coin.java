package vendingmachine.domain;

import vendingmachine.view.OutputMessage;

import java.util.ArrayList;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final String COIN_NAME_PREFIX = "COIN_";
    private static final OutputMessage outputMessage = new OutputMessage();
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

    public int getAmount() {
        return this.amount;
    }

    public int calcChangePrice(int stock) {
        return this.amount * stock;
    }

    public int returnChange(int customerMoney, int returnStock) {
        if (customerMoney < this.amount * returnStock) {
            returnStock = customerMoney / this.amount;
        }
        outputMessage.printReturnChange(this.amount, returnStock);
        return returnStock;
    }

    public static Coin getCoinByAmount(int amount) {
        return Coin.valueOf(COIN_NAME_PREFIX + amount);
    }
}
