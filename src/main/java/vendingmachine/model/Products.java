package vendingmachine.model;

import java.util.List;
import java.util.stream.Collectors;

public class Products {
    private final List<Product> products;

    public Products(List<List<String>> products) {
        this.products = products.stream()
                .map(Product::new)
                .collect(Collectors.toList());
    }
}
