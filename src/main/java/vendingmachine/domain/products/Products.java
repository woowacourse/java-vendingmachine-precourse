package vendingmachine.domain.products;

import vendingmachine.exception.ProductsDuplicatedNameException;

import java.util.List;
import java.util.stream.Collectors;

public class Products {

    private final List<Product> products;

    public Products(List<Product> products) {
        validate(products);
        this.products = products;
    }

    public static Products from(List<Product> products) {
        return new Products(products);
    }

    private void validate(List<Product> products) {
        validateDuplicatedName(products);
    }

    private void validateDuplicatedName(List<Product> products) {
        if (products.size() != products.stream().distinct().count()) {
            throw new ProductsDuplicatedNameException();
        }
    }
}
