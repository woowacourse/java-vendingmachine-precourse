package vendingmachine.domain;

import java.util.ArrayList;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static ArrayList<Integer> getCoins() {
        ArrayList<Integer> coins = new ArrayList<>();
        Coin[] coin = Coin.values();
        for (Coin value : coin) {
            coins.add(value.getAmount());
        }
        return coins;
    }
}