package vendingmachine.model;

import java.util.HashMap;

public class Coins {
    private HashMap<Coin, Integer> coins;

    public Coins(HashMap<Coin, Integer> coins) {
        this.coins = coins;
    }
}
