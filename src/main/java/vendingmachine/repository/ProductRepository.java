package vendingmachine.repository;

import vendingmachine.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private static final Map<String, Product> productInfo = new HashMap<>();

    public static void saveProductInfo(Map<String, Product> productMap) {
        productMap.keySet().forEach(k -> productInfo.put(k, productMap.get(k)));
    }

}
