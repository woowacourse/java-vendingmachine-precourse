package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Products {
    private final List<Product> products;

    public Products(String value) {
        products = new ArrayList<>();
        Arrays.stream(value.split(";")).forEach(content -> {
                String[] elements = content.replaceAll("[\\[\\]]","").split(",");
                products.add(Product.of(elements[0], Integer.parseInt(elements[1]), Integer.parseInt(elements[2])));
            }
        );
    }

    public void reduce(String productName) {
        products.stream().filter(product -> product.equals(productName)).findFirst().get().reduce();
    }

    public int getPriceByName(String productName) {
        return products.stream().filter(product -> product.equals(productName)).findFirst().get().getPrice();
    }

    public boolean isValidAmount(InputAmount inputAmount) {
        return !isOutOfStock() && canBuy(inputAmount);
    }

    private boolean canBuy(InputAmount inputAmount) {
        return products.stream().anyMatch(product -> product.isLessThan(inputAmount));
    }

    private boolean isOutOfStock() {
        return products.stream().allMatch(Product::isOutOfStock);
    }
}
