package vendingmachine.domain.product;

import vendingmachine.validator.ProductValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.constant.SystemMessage.NAME;

public class Products {
    private final List<Product> products;
    private int cheapestPrice = Integer.MAX_VALUE;
    public Products() {
        products = new ArrayList<>();
    }

    public void add(Product product) {
        cheapestPrice = Math.min(cheapestPrice, product.getPrice());
        products.add(product);
    }

    public boolean hasProduct(String name) {
        for (Product product : products) {
            if (product.hasName(name) && product.hasCount()) {
                return true;
            }
        }
        return false;
    }

    public Product reduce(String name) {
        List<Product> targetProduct = products.stream()
                .filter(product -> product.hasName(name))
                .filter(Product::hasCount)
                .collect(Collectors.toList());
        Product product = targetProduct.get(0);
        product.sell();
        return product;
    }

    public int getCheapestPrice() {
        return cheapestPrice;
    }

    public boolean isSoldOut() {
        for (Product product : products) {
            if (product.getCount() != 0) {
                return false;
            }
        }
        return true;
    }
}
