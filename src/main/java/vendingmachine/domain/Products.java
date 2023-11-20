package vendingmachine.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import vendingmachine.validators.ProductsValidator;

public class Products {
    private final Map<Product, Integer> products;

    private Products(final Map<Product, Integer> products) {
        this.products = products;
    }

    public static Products from(final Map<Product, Integer> input){
        List<Integer> counts = input.values().stream().collect(Collectors.toList());
        ProductsValidator.validate(counts);
        return new Products(input);
    }
}
