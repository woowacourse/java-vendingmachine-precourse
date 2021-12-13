package vendingmachine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Products {
    private static final int DEFAULT_VALUE = 0;
    private static final int START_INDEX = 1;
    private static final String SEMI_COLON = ";";
    private static final String COMMA = ",";

    private final List<Product> products;

    public Products(String products) {
        this.products = processProductsInput(products).stream()
                .map(Product::new)
                .collect(Collectors.toList());
    }

    private List<List<String>> processProductsInput(String products) {
        List<List<String>> processedProducts = new ArrayList<>();
        for (String product : products.split(SEMI_COLON)) {
            processedProducts.add(Arrays.asList(product.substring(START_INDEX, product.length() - START_INDEX).split(COMMA)));
        }

        return processedProducts;
    }


    public boolean existProductName(String productName) {
        return products.stream().anyMatch(product -> product.getName().equals(productName));
    }

    public int getCheapest() {
        return products.stream()
                .mapToInt(Product::getPrice)
                .min()
                .orElse(0);
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

    public boolean hasAnyProduct() {
        return products.size() > DEFAULT_VALUE;
    }

    public int existProductToBuy(int amount) {
        return products.stream()
                .filter(p -> p.getQuantity() > DEFAULT_VALUE)
                .filter(p -> p.getPrice() <= amount)
                .mapToInt(Product::getQuantity)
                .sum();
    }

    public int getPrice(String productName) {
        return products.stream()
                .filter(p -> p.getName().equals(productName))
                .mapToInt(Product::getPrice)
                .findAny().orElse(DEFAULT_VALUE);
    }

    public Product findByName(String productName) {
        return products.stream()
                .filter(p -> p.getName().equals(productName))
                .findAny()
                .orElse(null);
    }
}
