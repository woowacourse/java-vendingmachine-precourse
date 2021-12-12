package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    List<Product> productList;

    public ProductList() {
        productList = new ArrayList<>();
    }

    public void insertProduct(Product product) {
        productList.add(product);
    }

    public boolean checkExistUsingName(String name) {
        return productList.stream()
                .anyMatch(product -> product.name.equals(name));
    }

    public Product[] returnProductUsingName(String name) {
        return productList.stream()
                .filter(product -> product.name.equals(name))
                .toArray(Product[]::new);

    }

    public boolean checkPurchasePossible(int restMoney) {
        return productList.stream()
                .anyMatch(product -> product.price <= restMoney);
    }

    public boolean checkAllProductsSoldOut() {
        return productList.stream()
                .anyMatch(product -> product.quantity > 0);
    }
}
