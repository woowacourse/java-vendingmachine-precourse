package vendingmachine;

import java.util.HashMap;

public class ProductManager {
    private HashMap<String, Integer> products = new HashMap<>();

    public ProductManager() {
    }

    public void addProduct(Product product, int amount) {
        if (!products.containsKey(product.getName())) {
            products.put(product.getName(), 0);
        }

        products.put(product.getName(), products.get(product.getName()) + amount);
    }

    public void popProduct(String productName) throws MyIllegalArgumentException {
        if (!products.containsKey(productName)) {
            throw new MyIllegalArgumentException(
                    String.format("Nonexistence product name [%s]", productName)
            );
        }

        if (products.get(productName) < 1) {
            throw new MyIllegalArgumentException(
                    String.format("Product [%s] is out of an order", productName)
            );
        }

        products.put(productName, Integer.max(0, products.get(productName) - 1));
    }
}
