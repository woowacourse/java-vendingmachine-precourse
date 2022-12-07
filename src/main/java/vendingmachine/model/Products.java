package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.util.ExceptionMessage;

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

    public Product findProduct(String productName) {
        return products.stream().filter(product -> product.isSame(productName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_NO_SUCH_PRODUCT.getMessage()));
    }

    public List<Product> getProducts() {
        return products;
    }
}
