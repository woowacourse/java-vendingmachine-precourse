package vendingmachine.model;

import java.util.List;
import vendingmachine.util.validator.ProductsValidator;

public class Product {
    private Product() {
    }

    public static Product from(String productInfo) {
        new ProductsValidator().validate(productInfo);
        return new Product();
    }
}
