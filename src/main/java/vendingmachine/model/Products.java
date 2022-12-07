package vendingmachine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import vendingmachine.util.Util;

public class Products {

    private final List<Product> products;

    private Products(List<Product> products) {
        this.products = products;
    }

    public static Products from(List<String> productsInfo) {
        List<Product> products = new ArrayList<>();
        for (String productInfo : productsInfo) {
            products.add(Product.from(productInfo));
        }
        return new Products(products);
    }

    public List<Product> getProducts() {
        return products;
    }
}
