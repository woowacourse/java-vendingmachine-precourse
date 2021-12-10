package vendingmachine.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Products {
    private static final int DEFAULT_VALUE = 0;

    private final List<Product> products;

    public Products(List<List<String>> products) {
        this.products = products.stream()
                .map(Product::new)
                .collect(Collectors.toList());
    }

    public boolean exist(String productName) {
        return products.stream().anyMatch(product -> product.getName().equals(productName));
    }

    public int getCheapest() {
        return products.stream()
                .mapToInt(Product::getPrice)
                .min()
                .orElseThrow(IllegalArgumentException::new);
    }


    public boolean isQuantityEnough(String product) {
        return products.stream()
                .filter(p -> p.getName().equals(product))
                .mapToInt(Product::getQuantity)
                .findAny().orElse(DEFAULT_VALUE) != DEFAULT_VALUE;

    }

    public boolean isAffordable(int amount, String product) {
        return amount >= products.stream()
                .filter(p -> p.getName().equals(product))
                .mapToInt(Product::getPrice)
                .findAny().orElse(DEFAULT_VALUE);
    }

    public int reduceQuantity(String productName) {
        return Objects.requireNonNull(products.stream()
                .filter(p -> p.getName().equals(productName))
                .findAny().orElse(null)).popProduct();
    }

    public int getSize() {
        return products.stream()
                .mapToInt(Product::getQuantity)
                .sum();
    }
}
