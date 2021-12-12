package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {

    private final Coins coins;
    private final Products products;

    public VendingMachine(Coins coins, Products products) {
        this.coins = coins;
        this.products = products;
    }

    public Map<Coin, Integer> currentRemainCoins() {
        return coins.currentRemainCoins();
    }
}
