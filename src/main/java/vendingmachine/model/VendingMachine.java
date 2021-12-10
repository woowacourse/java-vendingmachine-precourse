package vendingmachine.model;

import vendingmachine.util.RandomNumberGenerator;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VendingMachine {
    public static final int DEFAULT_VALUE = 0;
    public static final int INCREMENT_BY_ONE = 1;
    public static final int DECREMENT_BY_ONE = -1;
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String NOT_ENOUGH_QUANTITY_MESSAGE = "상품 수량이 부족합니다.";
    private static final String NOT_ENOUGH_MONEY_MESSAGE = "잔액이 부족합니다.";
    private static final String TRY_AGAIN_MESSAGE = " 다시 선택해 주세요.";

    private final Map<Coin, Integer> coins;
    private Products products;
    private int userInsertAmount;

    public VendingMachine(int amount) {
        this.coins = createCoins(amount);
    }

    private Map<Coin, Integer> createCoins(int amount) {
        Map<Coin, Integer> coins = new TreeMap<>();
        initialize(coins);
        createRandom(coins, amount);

        return coins;
    }

    private void initialize(Map<Coin, Integer> coins) {
        Arrays.stream(Coin.values()).forEach(coin -> coins.put(coin, DEFAULT_VALUE));
    }

    private void createRandom(Map<Coin, Integer> coins, int amount) {
        while (amount != DEFAULT_VALUE) {
            int randomCoin = RandomNumberGenerator.generateRandomCoins(
                    Stream.of(Coin.values()).map(Coin::getAmount).collect(Collectors.toList()));
            amount = addCoin(coins, randomCoin, amount);
        }
    }

    private int addCoin(Map<Coin, Integer> coins, int randomCoin, int amount) {
        if (amount >= randomCoin) {
            Coin coin = Coin.findCoin(randomCoin);
            coins.put(coin, coins.get(coin) + INCREMENT_BY_ONE);
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
        return products.getSize() > DEFAULT_VALUE;
    }

    public void checkProductQuantity(String product) {
        if (!products.isQuantityEnough(product)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_ENOUGH_QUANTITY_MESSAGE + TRY_AGAIN_MESSAGE);
        }
    }

    public void buyProduct(String product) {
        if (!products.isAffordable(userInsertAmount, product)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_ENOUGH_MONEY_MESSAGE + TRY_AGAIN_MESSAGE);
        }
        userInsertAmount -= products.reduceQuantity(product);
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public Map<Coin, Integer> getChanges() {
        Map<Coin, Integer> changes = new TreeMap<>();
        calculateChanges(changes);

        return changes;
    }

    public void calculateChanges(Map<Coin, Integer> changes) {
        coins.keySet().forEach(coin -> {
            int count = DEFAULT_VALUE;
            while (coin.getAmount() <= userInsertAmount && coins.getOrDefault(coin, DEFAULT_VALUE) > DEFAULT_VALUE) {
                coins.merge(coin, DECREMENT_BY_ONE, Integer::sum);
                userInsertAmount -= coin.getAmount();
                count++;
            }
            if (count > DEFAULT_VALUE) {
                changes.put(coin, count);
            }
        });
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