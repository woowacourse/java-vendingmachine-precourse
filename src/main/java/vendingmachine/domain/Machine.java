package vendingmachine.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import vendingmachine.Coin;

public class Machine {
    private Map<Coin, Integer> coins;
    private List<Product> products;

    public Machine(Map<Coin, Integer> coins, List<Product> products) {
        this.coins = coins;
        this.products = products;
    }


    public int buy(String productName) {
        for (Product product : products) {
            if (productName.equals(product.getName())) {
                product.soldProduct();
                return product.getPrice();
            }
        }
        return 0;
    }

    public boolean canBuyWithMoney(int userAmount) {
        return products.stream().anyMatch(product -> userAmount >= product.getPrice());
    }

    public boolean canBuyWithQuantity() {
        return products.stream().anyMatch(product -> product.getQuantity() > 0);
    }

    public void isExistsQuantity(String productName) {
        boolean productAvailable = products.stream()
                .filter(product -> product.getName().equals(productName))
                .anyMatch(product -> product.getQuantity() > 0);

        if (!productAvailable) {
            throw new IllegalArgumentException("[ERROR] 주문하려는 상품이 소진되었습니다. 다른 상품을 주문해 주세요.");
        }
    }

    public void isExistsProduct(String productName) {
        boolean productExists = products.stream()
                .anyMatch(product -> productName.equals(product.getName()));

        if (!productExists) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 상품입니다.");
        }
    }

    public Map<Coin, Integer> calculateChange(int userAmount) {
        Map<Coin, Integer> sortedCoins = new TreeMap<>(Comparator.comparing(Coin::getAmount).reversed());

        for (Entry<Coin, Integer> entry : coins.entrySet()) {
            Coin change = entry.getKey();
            int count = entry.getValue();

            while (userAmount >= change.getAmount() && count > 0) {
                userAmount -= change.getAmount();
                count--;
                sortedCoins.merge(change, 1, Integer::sum);
            }
            coins.put(change, count);
        }

        return sortedCoins;
    }

}
