package vendingmachine.domain.product;

import java.util.HashMap;
import java.util.Map;

public class ProductStore {
    private final Map<String, Product> productStore;

    private ProductStore() {
        this.productStore = new HashMap<>();
    }

    public static ProductStore getInstance() {
        return new ProductStore();
    }

    public void putProduct(String name, Product product) {
        productStore.put(name, product);
    }

    // for test
    public boolean hasProduct(String productName) {
        return productStore.containsKey(productName);
    }
}
