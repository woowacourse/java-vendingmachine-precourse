package vendingmachine.model;

import vendingmachine.util.RandomNumberGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VendingMachine {
    public static final int DEFAULT_VALUE = 0;
    public static final int INCREMENT_BY_ONE = 1;

    private Map<Integer, Integer> coins;
    private Products products;

    public VendingMachine(int amount) {
        this.coins = createCoins(amount);
    }

    private Map<Integer, Integer> createCoins(int amount) {
        Map<Integer, Integer> coins = new HashMap<>();
        while (amount != DEFAULT_VALUE) {
            int randomCoin = RandomNumberGenerator.generateRandomCoins(
                    Stream.of(Coin.values())
                            .map(Coin::getAmount)
                            .collect(Collectors.toList()));
            amount = addCoin(coins, randomCoin, amount);
        }

        return coins;
    }

    private int addCoin(Map<Integer, Integer> coins, int randomCoin, int amount) {
        if (amount >= randomCoin) {
            coins.put(randomCoin, coins.getOrDefault(randomCoin, DEFAULT_VALUE) + INCREMENT_BY_ONE);
            amount -= randomCoin;
        }

        return amount;
    }

    public Map<Integer, Integer> getCoins() {
        return coins;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
