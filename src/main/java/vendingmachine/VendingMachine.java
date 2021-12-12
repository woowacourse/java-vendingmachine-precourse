package vendingmachine;

import java.util.Map;

public class VendingMachine {
    private Coins coins;

    public VendingMachine(Coins coins) {
        this.coins = coins;
    }

    public Map<Coin, Integer> getCoins() {
        return this.coins.getCoins();
    }
}
