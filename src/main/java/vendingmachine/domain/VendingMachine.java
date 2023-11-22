package vendingmachine.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import vendingmachine.RandomNumberGenerator;

public class VendingMachine {

    private Map<Coin, Integer> coins = new EnumMap<>(Coin.class);
    private List<Product> products = new ArrayList<>();

    public VendingMachine() {
        coins.put(Coin.COIN_500, 0);
        coins.put(Coin.COIN_100, 0);
        coins.put(Coin.COIN_50, 0);
        coins.put(Coin.COIN_10, 0);
    }

    public void addCoins(int amount) {
        while (amount > 0) {
            int generatedNumber = RandomNumberGenerator.generate(Coin.getCoinAmounts());
            if (generatedNumber > amount) {
                continue;
            }
            Coin coin = Coin.from(generatedNumber);
            coins.put(coin, coins.get(coin) + 1);
            amount -= generatedNumber;
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean isAllPriceGreaterThan(int amount) {
        return products.stream()
                .allMatch(product -> product.isPriceGreaterThan(amount));
    }

    public boolean isAllProductSoldOut() {
        return products.stream()
                .allMatch(Product::isSoldOut);
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }
}
