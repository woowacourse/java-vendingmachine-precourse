package vendingmachine;

import java.util.HashMap;

public class ProductManager {
    private HashMap<String, Integer> products = new HashMap<>();

    public ProductManager() {
    }

    public void addProduct(String productName, int amount) {
        if (!products.containsKey(productName)) {
            products.put(productName, 0);
        }

        products.put(productName, products.get(productName) + amount);
    }
}
