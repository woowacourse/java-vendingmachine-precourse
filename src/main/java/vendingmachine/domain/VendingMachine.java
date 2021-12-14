package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {
    private final List<Product> products = new ArrayList<>();
    private final CoinCollection coins = new CoinCollection();
    private int money = -1;

    public void insertCoins(List<Coin> coins) {
        for (Coin coin : coins) {
            this.coins.addCoin(coin);
        }
        System.out.println(this.coins);
    }

    public void registerProducts(String input) {
        String[] products = input
                .replaceAll("[]\\[]", "")
                .split(";");

        Arrays.stream(products)
                .map(s -> s.split(","))
                .map(s -> new Product(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2])))
                .forEach(this.products::add);
    }

    public void insertMoney(int money) {
        this.money = money;
    }

    public boolean isReadyToStartBuying() {
        return money != -1 && !products.isEmpty() && !coins.isEmpty();
    }

    public int remainMoney() {
        return money;
    }

    public boolean hasProduct(String name) {
        return products.stream().anyMatch(p -> p.isSameNameWith(name));
    }

    public boolean canBuyWith(int money) {
        return !products.isEmpty() && products.stream().anyMatch(p -> p.isPriceLowerOrEqualWith(money));
    }

    public void buy(String name) {
        Product product = products.stream()
                .filter(p -> p.isSameNameWith(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        product.countDownQuantity();
        money -= product.getPrice();

        if (product.isEmpty()) {
            products.remove(product);
        }
    }

    public CoinCollection returnChange() {
        CoinCollection change = new CoinCollection();
        List<Coin> coinsInOrder = Coin.getCoinsInOrder();

        for (Coin coin : coinsInOrder) {
            while (coin.isLessOrEqualWith(money) && coins.isRemain(coin)) {
                coins.pullCoin(coin);
                change.addCoin(coin);
                money = coin.subtractFrom(money);
            }
        }

        return change;
    }
}
