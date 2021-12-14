package vendingmachine.domain.product;

import vendingmachine.domain.consumer.Consumer;

import java.util.HashMap;
import java.util.Map;

import static vendingmachine.util.validator.error.Error.NOT_FOUND_PRODUCT;

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

    public boolean verifyEnoughConsumerBalance(Consumer consumer) {
        return productStore.values().stream().anyMatch((product) -> consumer.possibleToBuy(product));
    }

    public Product getProduct(String productName) {
        if(!hasProduct(productName)) {
            throw new IllegalArgumentException(NOT_FOUND_PRODUCT.getMessage());
        }
        return productStore.get(productName);
    }

    // for test
    public boolean hasProduct(String productName) {
        return productStore.containsKey(productName);
    }
}
