package vendingmachine.domain;

import java.util.HashMap;

public class ProductList {
    private static final HashMap<String, Product> productList = new HashMap<>();
    private static int minimumPrice = Integer.MAX_VALUE;

    public void addProductList(String productName, Product product) {
        productList.put(productName, product);
        minimumPrice = product.isLessThanMinimumPrice(minimumPrice);
    }

    public void initProductMap() {
        productList.clear();
    }

    public Product getProductByName(String name) {
        return productList.get(name);
    }

    public boolean checkAvailableState(int customerMoney) {
        return checkProductStock() && compareMinimumPrice(customerMoney);
    }

    public boolean compareMinimumPrice(int customerMoney) {
        return customerMoney >= minimumPrice;
    }

    private boolean checkProductStock() {
        for (String name : productList.keySet()) {
            Product product = productList.get(name);
            if (product.existStock()) {
                return true;
            }
        }
        return false;
    }
}
