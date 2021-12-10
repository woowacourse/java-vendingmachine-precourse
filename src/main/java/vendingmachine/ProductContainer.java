package vendingmachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ProductContainer {

    Map<String, Product> productMap = new HashMap<>();

    public ProductContainer(List<Product> productList) {
        productList.forEach(product -> productMap.put(product.getName(), product));
    }
}
