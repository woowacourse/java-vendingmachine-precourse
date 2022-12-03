package vendingmachine.Domain;

import java.util.HashMap;


public class Change {

    private final HashMap<Integer, Integer> coins;

    public Change(HashMap<Integer, Integer> coins) {
        this.coins = coins;
    }

    public HashMap<Integer, Integer> getCoins() {
        return coins;
    }

}
