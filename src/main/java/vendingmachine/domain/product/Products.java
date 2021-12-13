package vendingmachine.domain.product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Product reduce(String name) {
        List<Product> collect = products.stream()
                .filter(product -> product.hasName(name))
                .collect(Collectors.toList());
        Product product = collect.get(0);
        product.sell();
        return product;
    }
}
