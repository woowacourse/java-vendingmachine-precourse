package vendingmachine.repository;

import vendingmachine.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProductRepository {
    private static final Map<String, Product> productInfo = new HashMap<>();

    public static void saveProductInfo(Map<String, Product> productMap) {
        productMap.keySet().forEach(k -> productInfo.put(k, productMap.get(k)));
    }

    public Set<String> getProductNameSet() {
        return productInfo.keySet();
    }

    public int getProductPrice(String name, int change) {
        return productInfo.get(name).getPrice();
    }

    public int getProductQuantity(String name, int change) {
        return productInfo.get(name).getQuantity();
    }

    public boolean isExist(String name) {
        if (!productInfo.containsKey(name)) {
            return false;
        }
        return true;
    }

    public boolean hasEnoughMoney(String name, int change) {
        if (change < productInfo.get(name).getPrice()) {
            return false;
        }
        return true;
    }

    public boolean hasEnoughQuantity(String name) {
        if (productInfo.get(name).getQuantity() > 0) {
            return true;
        }
        return false;
    }

}
