package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private Coins coins;
    private final List<Product> products = new ArrayList<>();

    public VendingMachine(Coins coins) {
        this.coins = coins;
    }

    public Map<Coin, Integer> getCoins() {
        return this.coins.getCoins();
    }

    public void addAll(List<Product> products) {
        this.products.addAll(products);
    }

    public void buyProduct(Order order) {
        products.stream()
            .filter(product -> product.isEqualToName(order.getProductName()))
            .findAny()
            .ifPresent(product -> product.processPurchasing(order));
    }
}
