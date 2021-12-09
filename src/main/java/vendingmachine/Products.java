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
}
