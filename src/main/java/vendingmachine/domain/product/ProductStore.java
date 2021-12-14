package vendingmachine.domain.product;

import vendingmachine.domain.consumer.Consumer;

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

    public boolean verifyEnoughConsumerBalance(Consumer consumer) {
        return productStore.values().stream().anyMatch((product) -> consumer.possibleToBuy(product));
    }

    public Product getProduct(String productName) {
        if(!hasProduct(productName)) {
            throw new IllegalArgumentException("[ERROR] 해당 이름의 상품이 존재하지 않습니다.");
        }
        return productStore.get(productName);
    }

    // for test
    public boolean hasProduct(String productName) {
        return productStore.containsKey(productName);
    }
}
