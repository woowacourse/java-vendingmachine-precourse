package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private static final String BUY_ERROR_SENTENCE = "[ERROR] 존재하지 않는 상품입니다.";
    
    private List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public boolean buyProduct(String name, int payment) {
        Product product = findProduct(name);
        if (product == null) {
            System.out.println(BUY_ERROR_SENTENCE);
            return false;
        }
        return product.buy(payment);
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
