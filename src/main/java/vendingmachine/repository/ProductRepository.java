package vendingmachine.repository;

import vendingmachine.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProductRepository {
    private static final ProductRepository instance = new ProductRepository();
    private static final Map<String, Product> productInfo = new HashMap<>();

    private ProductRepository() {
    }

    public static ProductRepository getInstance() {
        return instance;
    }

    public void saveProductInfo(Map<String, Product> productMap) {
        productMap.keySet().forEach(k -> productInfo.put(k, productMap.get(k)));
    }

    public Set<String> getProductNameSet() {
        return productInfo.keySet();
    }

    public int getProductPrice(String name, int change) {
        return productInfo.get(name).getPrice();
    }

    public int getProductQuantity(String name) {
        return productInfo.get(name).getQuantity();
    }

    public int substractProductQuantity(String name) {
        productInfo.get(name).sellProduct();
        return productInfo.get(name).getPrice();
    }

    public static boolean isExist(String name) {
        if (!productInfo.containsKey(name)) {
            return false;
        }
        return true;
    }
}
