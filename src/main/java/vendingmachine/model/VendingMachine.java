package vendingmachine.model;

import vendingmachine.util.RandomNumberGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VendingMachine {
    public static final int DEFAULT_VALUE = 0;
    public static final int INCREMENT_BY_ONE = 1;

    private Map<Coin, Integer> coins;
    private Products products;
    private int userInsertAmount;

    public VendingMachine(int amount) {
        this.coins = createCoins(amount);
    }

    private Map<Coin, Integer> createCoins(int amount) {
        Map<Coin, Integer> coins = new HashMap<>();
        while (amount != DEFAULT_VALUE) {
            int randomCoin = RandomNumberGenerator.generateRandomCoins(
                    Stream.of(Coin.values())
                            .map(Coin::getAmount)
                            .collect(Collectors.toList()));
            amount = addCoin(coins, randomCoin, amount);
        }

        return coins;
    }

    private int addCoin(Map<Coin, Integer> coins, int randomCoin, int amount) {
        if (amount >= randomCoin) {
            Coin coin = Coin.findCoin(randomCoin);
            coins.put(coin, coins.getOrDefault(coin, DEFAULT_VALUE) + INCREMENT_BY_ONE);
            amount -= randomCoin;
        }

        return amount;
    }

    public boolean hasProduct(String productName) {
        return products.exist(productName);
    }

    public boolean hasEnoughAmount() {
        return userInsertAmount >= products.getCheapest();
    }

    public boolean hasAnyProduct() {
        return products.getSize() > 0;
    }

    public void checkProductQuantity(String product) {
        if (!products.isQuantityEnough(product)) {
            throw new IllegalArgumentException("상품 수량이 부족합니다. 다시 선택해 골라주세요.");
        }
    }

    public void buyProduct(String product) {
        if (!products.isAffordable(userInsertAmount, product)) {
            throw new IllegalArgumentException("잔액이 부족합니다. 다시 선택해 주세요.");
        }
        userInsertAmount -= products.reduceQuantity(product);
    }

    public void calculateChanges(Map<Coin, Integer> changes) {
        coins.keySet().forEach(coin -> {
            int count = 0;
            while (coin.getAmount() <= userInsertAmount && coins.getOrDefault(coin, 0) > 0) {
                coins.merge(coin, -1, Integer::sum);
                userInsertAmount -= coin.getAmount();
                count++;
            }
            if (count > 0) {
                changes.put(coin, count);
            }
        });
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public Map<Coin, Integer> getChanges() {
        Map<Coin, Integer> changes = new TreeMap<>();
        calculateChanges(changes);

        return changes;
    }

    public int getUserInsertAmount() {
        return userInsertAmount;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public void setUserInsertAmount(int userInsertAmount) {
        this.userInsertAmount = userInsertAmount;
    }
}