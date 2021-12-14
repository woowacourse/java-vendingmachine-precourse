package vendingmachine;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private static final int EMPTY_VALUE = 0;

    private final Coins coins;
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
            .filter(Product::isExistedProduct)
            .findAny()
            .orElseThrow(ErrorMessage.NOT_FOUND_PRODUCT::getException)
            .processPurchasing(order);
    }

    public boolean isCheckedStockByProduct(int holdingAmount) {
        for (Product product : products) {
            if (product.isPossibleBuyProduct(holdingAmount)) {
                return true;
            }
        }
        return false;
    }

    public Map<Coin, Integer> getChangeMoney(int holdingAmount) {
        Map<Coin, Integer> changeMoney = new EnumMap<>(Coin.class);
        for (Coin coin : Coin.values()) {
            holdingAmount = countCoin(holdingAmount, changeMoney, coin);
        }
        return changeMoney;
    }

    private int countCoin(int holdingAmount, Map<Coin, Integer> changeMoney, Coin coin) {
        int count = 0;
        while (holdingAmount > EMPTY_VALUE) {
            int amount = coins.takeOut(coin);
            if (amount == EMPTY_VALUE) {
                break;
            }
            count += 1;
            holdingAmount -= amount;
            changeMoney.put(coin, count);
        }
        return holdingAmount;
    }
}
