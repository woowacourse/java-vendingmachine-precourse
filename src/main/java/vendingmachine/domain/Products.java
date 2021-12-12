package vendingmachine.domain;

import java.util.List;
import java.util.Optional;

public class Products {
    private final List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public Optional<Product> findByName(String productPurchaseName) {
        return products.stream()
            .filter(product -> product.isSameName(productPurchaseName))
            .findFirst();
    }
}