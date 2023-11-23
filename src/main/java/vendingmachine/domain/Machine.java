package vendingmachine.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import vendingmachine.Coin;

public class Machine {
    private Map<Coin, Integer> coins;
    private List<Product> products;

    public Machine(Map<Coin, Integer> coins, List<Product> products) {
        this.coins = coins;
        this.products = products;
    }


    public int buy(String productName) {
        for (int i = 0; i < products.size(); i++) {
            if (productName.equals(products.get(i).getName())) {
                products.get(i).soldProduct();
                return products.get(i).getPrice();
            }
        }
        return 0;
    }

    public boolean canBuy(int userAmount) {
        boolean flag = false;
        for (int i = 0; i < products.size(); i++) {
            if (userAmount >= products.get(i).getPrice()) {
                flag = true;
            }
        }
        return flag;
    }

    public void isExistsProduct(String productName) {
        boolean flag = false;
        for (int i = 0; i < products.size(); i++) {
            if (productName.equals(products.get(i).getName())) {
                flag = true;
            }
        }
        if (!flag) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 상품입니다.");
        }
    }

    public Map<Coin,Integer> calculateChange(int userAmount) {
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
