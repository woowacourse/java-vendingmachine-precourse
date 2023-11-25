package provider;

import domain.Product;
import domain.Products;

import java.util.List;

public class TestProvider {
    public static Products createTestProducts(final String productsInfo) {
        return new Products(productsInfo);
    }
}
