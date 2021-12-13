package vendingmachine.domain.product;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private List<Product> products;

    public Products() {
        products = new ArrayList<>();
    }

    public void add(Product product) {
        products.add(product);
    }

    public void print() {
        for (Product product : products) {
            product.print();
        }
    }
}
