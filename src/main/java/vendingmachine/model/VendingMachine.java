package vendingmachine.model;

import vendingmachine.util.RandomNumberGenerator;

import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {
    public static final int DEFAULT_VALUE = 0;
    public static final int INCREMENT_BY_ONE = 1;

    private final Map<Coin, Integer> coins;
    private Products products;
    private int userInsertAmount;

    public VendingMachine() {
        coins = initializeCoins();
    }

    private Map<Coin, Integer> initializeCoins() {
        Map<Coin, Integer> coins = new TreeMap<>();
        Coin.getCoinList().forEach(coin -> coins.put(coin, DEFAULT_VALUE));
        return coins;
    }

    private void createRandom(int amount) {
        while (amount != DEFAULT_VALUE) {
            int randomCoin = RandomNumberGenerator.generateRandomCoins(Coin.getCoinValues());
            amount = addCoin(randomCoin, amount);
        }
    }

    private int addCoin(int randomCoin, int amount) {
        if (amount >= randomCoin) {
            Coin coin = Coin.findCoin(randomCoin);
            coins.put(coin, coins.get(coin) + INCREMENT_BY_ONE);
            amount -= randomCoin;
        }

        return amount;
    }

    public boolean hasProduct(String productName) {
        return products.existProductName(productName);
    }


    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public Map<Coin, Integer> getChanges() {
        return calculateChanges();
    }

    public Map<Coin, Integer> calculateChanges() {
        Map<Coin, Integer> changes = new TreeMap<>();
        coins.keySet().forEach(coin -> {
            int changesCount = userInsertAmount / coin.getAmount();
            changesCount = Math.min(changesCount, coins.get(coin));
            if (changesCount > 0) {
                changes.put(coin, changesCount);
            }
            userInsertAmount -= changesCount * coin.getAmount();
        });

        return changes;
    }

    public int getUserInsertAmount() {
        return userInsertAmount;
    }

    public void setInitialAmount(int initialAmount) {
        createRandom(initialAmount);
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public void setUserInsertAmount(int userInsertAmount) {
        this.userInsertAmount = userInsertAmount;
    }

    public void reduceAmount(int productPrice) {
        userInsertAmount -= productPrice;
    }
}