package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

import static vendingmachine.utils.ErrorMessage.NOT_EXIST_PRODUCT;
import static vendingmachine.utils.ErrorMessage.PRODUCT_CANNOT_FOUNT;

public class Inventory {
    private final List<Product> products = new ArrayList<>();

    public void add(Product product) {
        this.products.add(product);
    }

    public Product get(String name) {
        return products.stream()
                .filter(o -> o.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_PRODUCT.getMessage()));
    }

    public Product consume(String name) {
        Product product = this.get(name);
        product.consume();
        return product;
    }

    public int getMinAmount() {
        return products.stream()
                .mapToInt(Product::getAmount)
                .min()
                .orElseThrow(() -> new IllegalArgumentException(PRODUCT_CANNOT_FOUNT.getMessage()));
    }

    public boolean isEmpty() {
        int total = products.stream()
                .mapToInt(Product::getTotal)
                .sum();
        return total == 0;
    }

    public boolean contains(String name) {
        return products.stream()
                .anyMatch(product -> product.getName().equals(name));
    }
}
