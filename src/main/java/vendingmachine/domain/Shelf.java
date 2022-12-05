package vendingmachine.domain;

import vendingmachine.util.ErrorMessage;

import java.util.List;
import java.util.stream.IntStream;

import static vendingmachine.util.ErrorMessage.*;

public class Shelf {
    private final List<Product> products;

    public Shelf(List<Product> products) {
        this.products = products;
    }

    public void productExist(String productName) {
       products.stream().filter(o -> o.getName().equals(productName))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(PRODUCT_NOT_EXIST.getMessage()));
    }

    public int getMinPrice() {
        return products.stream()
                .mapToInt(Product::getPrice)
                .min()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void consumeProduct(String productName) {
        products.stream().filter(o -> o.equals(productName))
                .forEach(o -> {
                    if (o.getPrice() == 0) {
                        throw new IllegalArgumentException(PRODUCT_SOLD_OUT.getMessage());
                    }
                    o.sell();
                });
    }

    public boolean allProductSoldOut() {
        int totalCount = products.stream().mapToInt(o -> o.getCount()).sum();
        if (totalCount == 0) return true;
        return false;
    }
}
