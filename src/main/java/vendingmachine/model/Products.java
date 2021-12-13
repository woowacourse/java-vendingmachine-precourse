package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private static final String BUY_ERROR_SENTENCE = "[ERROR] 존재하지 않는 상품입니다.";
    
    private List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public int getMinPrice() {
        int min = Integer.MAX_VALUE;
        for(Product product : products) {
            if (!product.isSoldOut() && min > product.getPrice()) {
                min = product.getPrice();
            }
        }
        return min;
    }

    public boolean isAllSoldOut() {
        for(Product product : products) {
            if (!product.isSoldOut()) {
                return false;
            }
        }
        return true;
    }

    public int buyProduct(String name, int payment) {
        Product product = findProduct(name);
        if (product == null) {
            throw new IllegalStateException(BUY_ERROR_SENTENCE);
        }
        product.buy(payment);
        return product.getPrice();
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
