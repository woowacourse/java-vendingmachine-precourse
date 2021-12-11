package vendingmachine.model;

import java.util.HashMap;

public class ProductTable {
    private final HashMap<String, Product> productTable = new HashMap<>();

    public void addProduct(String name, int price, int stock) {
        checkExists(name, false);
        productTable.put(name, new Product(name, price, stock));
    }

    public boolean isExist(String productName) {
        return productTable.containsKey(productName);
    }

    private void checkExists(String productName, boolean bool) {
        if (isExist(productName) != bool) {
            throw new IllegalArgumentException();
        }
    }
}
