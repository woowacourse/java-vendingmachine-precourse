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

    public void purchase(String productName, InputAmount inputAmount) {
        Product productForPurchase = products.stream()
                .filter(product -> product.isName(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 상품입니다."));
        productForPurchase.decreaseQuantity();
        inputAmount.decrease(productForPurchase.getPrice());
    }

    public Map<Coin, Integer> changes(InputAmount inputAmount) {
        Map<Coin, Integer> changes = new EnumMap<>(Coin.class);
        for (Coin coin : Coin.values()) {
            int count = coins.get(coin);
            for (int i = 0; i < count; i++) {
                if (inputAmount.getAmount() <= 0) {
                    break;
                }
                inputAmount.decrease(coin.getAmount());
                coins.replace(coin, coins.get(coin) - 1);
                changes.put(coin, changes.getOrDefault(coin, 0) + 1);
            }
        }
        return changes;
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }
}
