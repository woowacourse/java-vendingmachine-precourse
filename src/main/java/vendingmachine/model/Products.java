package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private static final String BUY_ERROR_SENTENCE = "[ERROR] 존재하지 않는 상품입니다.";
    
    private List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public void buyProduct(String name, int payment) {
        Product product = findProduct(name);
        if (product == null) {
            throw new IllegalStateException(BUY_ERROR_SENTENCE);
        }
        product.buy(payment);
    }

    public Product findProduct(String name) {
        for (Product product : products) {
            if (product.isSameProduct(name)) {
                return product;
            }
        }
        return null;
    }
}
