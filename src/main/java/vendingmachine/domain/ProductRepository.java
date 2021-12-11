package vendingmachine.domain;

import vendingmachine.constant.Condition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {
    private static final ProductRepository instance = new ProductRepository();
    private List<Product> products = new ArrayList<>();

    private ProductRepository() {
    }

    public static ProductRepository getInstance() {
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getMinCost() {
        List<Product> productCollect = products.stream()
                .sorted().collect(Collectors.toList());

        for (Product product : productCollect) {
            if (product.getQuantity() > Condition.QUANTITY_0.getNumber()) {
                return product.getCost();
            }
        }
        return Condition.NOTHING.getNumber();
    }

    public int getAllAmount() {
        int allAmount = Condition.QUANTITY_0.getNumber();
        for (Product product : products) {
            allAmount += product.getQuantity();
        }
        return allAmount;
    }

    public void purchaseProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                product.sellProduct();
            }
        }
    }
}
