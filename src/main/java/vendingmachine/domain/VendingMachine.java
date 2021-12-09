package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private final Coins coins;
    private final Map<Product, Integer> products = new HashMap<>();
    private int inputMoney = 0;

    public VendingMachine(int seedMoney) {
        coins = new Coins(seedMoney);
    }

    public VendingMachine(Coins coins) {
        this.coins = coins;
    }

    public Coins getCoins() {
        return coins;
    }

    public void addProduct(Product product, int quantity) {
        this.products.put(product, quantity);
    }

    public void inputMoney(int money) {
        inputMoney = money;
    }

    public void get(Product product) {
        if (!isProvidable(product)) {
            throw new IllegalArgumentException("[ERROR] 구매 조건을 충족하지 못합니다.");
        }

        products.put(product, products.get(product) - 1);
        inputMoney -= product.getPrice();
    }

    private boolean isProvidable(Product product) {
        return products.containsKey(product) && isEnoughMoney(product) && isNotSoldOut(product);
    }

    private boolean isNotSoldOut(Product product) {
        return products.get(product) > 0;
    }

    private boolean isEnoughMoney(Product product) {
        return product.getPrice() <= inputMoney;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public Coins getChanges() {
        Coins changes = Coins.getGreedyChanges(inputMoney, coins);
        inputMoney -= changes.sum();
        return changes;
    }
}
