package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer{
    private static final int EMPTY_STOCK = 0;
    private ArrayList<Product> products = new ArrayList<>();
    private HashMap<Coin, Integer> coinStorage = new HashMap<>();
    private int customerMoney;

    public Customer(int customerMoney) {
        this.customerMoney = customerMoney;
    }

    public void buyProduct(Product product) {
        products.add(product);
        customerMoney = product.calcCustomerMoney(customerMoney);
        product.sell();
    }

    public int getCustomerMoney() {
        return customerMoney;
    }

    public void addCoin(Coin coin, int returnStock) {
        if (returnStock != EMPTY_STOCK) {
            coinStorage.put(coin, returnStock);
            customerMoney -= coin.calcChangePrice(returnStock);
        }
    }

    public HashMap<Coin, Integer> getCoinStorage() {
        return coinStorage;
    }
}
