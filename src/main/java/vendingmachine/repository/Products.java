package vendingmachine.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Product;

public class Products {
    public static final String PRODUCTS_DELIMITER = ";";
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERROR_INVALID_PRODUCT_NAME_MESSAGE = "존재하지 않는 상품입니다.";

    private final List<Product> products;

    public Products(String value) {
        products = new ArrayList<>();
        Arrays.stream(value.split(PRODUCTS_DELIMITER))
            .forEach(productElements -> products.add(new Product(productElements)));
    }

    public void reduceQuantityByName(String productName) {
        findByName(productName).reduceQuantity();
    }

    public int getPriceByName(String productName) {
        return findByName(productName).getPrice();
    }

    public Product findByName(String productName) {
        return products.stream().filter(product -> product.isSameName(productName)).findFirst()
            .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + ERROR_INVALID_PRODUCT_NAME_MESSAGE));
    }

    public boolean isValidAmount(int amount) {
        return !isOutOfStock() && canBuy(amount);
    }

    private boolean isOutOfStock() {
        return products.stream().allMatch(Product::isOutOfStock);
    }

    private boolean canBuy(int amount) {
        return products.stream().anyMatch(product -> product.isOrLess(amount));
    }
}