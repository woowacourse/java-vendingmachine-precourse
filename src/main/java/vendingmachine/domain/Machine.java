package vendingmachine.domain;

import java.util.List;
import java.util.Map;
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
}
