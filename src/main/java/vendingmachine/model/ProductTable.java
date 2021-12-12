package vendingmachine.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class ProductTable {
    private final HashMap<String, Product> productTable = new HashMap<>();

    public void addProduct(String name, int price, int stock) {
        checkExists(name, false);
        productTable.put(name, new Product(name, price, stock));
    }

    public void deleteProduct(String productName) {
        productTable.remove(productName);
    }

    public void buyProduct(String productName) {
        checkBuyable(productName, true);
        productTable.get(productName).sell();
    }

    public boolean isExist(String productName) {
        return productTable.containsKey(productName);
    }

    public boolean isBuyable(String productName) {
        checkExists(productName, true);
        return productTable.get(productName).isAvailable();
    }

    public int getCheapestPrice() {
        if (productTable.size() == 0) {
            return -1;
        }
        ArrayList<Product> list = new ArrayList<>(productTable.values());
        list.sort(Comparator.naturalOrder());
        for (Product product : list) {
            if (product.isAvailable()) {
                return product.getPrice();
            }
        }
        return -1;
    }

    public boolean isAvailable() {
        for (Product product : productTable.values()) {
            if (product.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    public void clearTable() {
        productTable.clear();
    }

    private void checkExists(String productName, boolean bool) {
        if (isExist(productName) != bool) {
            throw new IllegalArgumentException();
        }
    }

    private void checkBuyable(String productName, boolean bool) {
        if (isBuyable(productName) != bool) {
            throw new IllegalArgumentException();
        }
    }
}
