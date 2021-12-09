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

    public boolean findProduct(String productName) {
        return products.stream().anyMatch(product -> product.getName().equals(productName));
    }

    public int getCheapest() {
        return products.stream()
                .mapToInt(Product::getPrice)
                .min()
                .orElseThrow(IllegalArgumentException::new);
    }
}
