package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean isAllPriceGreaterThan(int amount) {
        return products.stream()
                .allMatch(product -> product.isPriceGreaterThan(amount));
    }

    public boolean isAllProductSoldOut() {
        return products.stream()
                .allMatch(Product::isSoldOut);
    }
}
