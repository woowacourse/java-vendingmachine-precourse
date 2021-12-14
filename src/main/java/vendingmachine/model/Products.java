package vendingmachine.model;

import java.util.Comparator;
import java.util.List;

public class Products {
    private static final String BUY_ERROR_SENTENCE = "[ERROR] 존재하지 않는 상품입니다.";
    private static final int FAIL_NUMBER = -1;

    private final List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public int getMinPrice() {
        Product product = products.stream()
                .filter(Product::isNotSoldOut)
                .min(Comparator.comparing(Product::getPrice))
                .orElse(null);
        if (product == null) {
            return FAIL_NUMBER;
        }
        return product.getPrice();
    }

    public boolean isAllSoldOut() {
        return products.stream()
                .noneMatch(Product::isNotSoldOut);
    }

    public int buyProduct(String name, int payment) {
        Product product = findProduct(name);
        if (product == null) {
            throw new IllegalStateException(BUY_ERROR_SENTENCE);
        }
        product.buy(payment);
        return product.getPrice();
    }

    public Product findProduct(String name) {
        return products.stream()
                .filter(product -> product.isSameProduct(name))
                .findFirst()
                .orElse(null);
    }
}