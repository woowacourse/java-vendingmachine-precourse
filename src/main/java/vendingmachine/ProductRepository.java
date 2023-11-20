package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private final Map<Product, Integer> repository;

    private ProductRepository() {
        repository = new HashMap<>();
    }

    public static ProductRepository getInstance() {
        return new ProductRepository();
    }

    public void addProduct(Product product, int quantity) {
        repository.put(product, repository.getOrDefault(product, 0) + quantity);
    }
}
