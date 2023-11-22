package vendingmachine.domain;

import vendingmachine.Coin;

import java.util.List;
import java.util.Map;

public class vendingMachine {

    private final Map<Coin, Integer> coins;
    private final List<Item> items;

    public vendingMachine(Map<Coin, Integer> coins, List<Item> items) {
        this.coins = coins;
        this.items = items;
    }
}
