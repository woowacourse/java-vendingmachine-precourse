package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class ProductManager {
    private HashMap<String, Integer> products = new HashMap<>();
    private HashMap<String, Integer> priceByName = new HashMap<>();

    public ProductManager() {
    }

    public int getProductPrice(String productName) {
        return priceByName.get(productName);
    }

    public void addProduct(String productName, int productPrice, int amount) {

        if (!products.containsKey(productName)) {
            products.put(productName, 0);
        }

        if (!priceByName.containsKey(productName)) {
            priceByName.put(productName, productPrice);
        }

        products.put(productName, products.get(productName) + amount);
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

    public int getMinPrice() {
        int ret = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            if (entry.getValue() < 1) {
                continue;
            }
            ret = Integer.min(ret, entry.getValue());
        }

        return ret;
    }

    public boolean isProductAvailable() {
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            if (entry.getValue() > 0) {
                return true;
            }
        }

        return false;
    }
}
