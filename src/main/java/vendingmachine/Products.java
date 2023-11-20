package vendingmachine;

import java.util.Map;

public class Products {

    private final Map<String, Product> productMap;

    public Products(Map<String, Product> productMap) {
        this.productMap = productMap;
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public int findInputAmount(String inputName) {
        for (String name : productMap.keySet()) {
            if (name.equals(inputName)) {
                return productMap.get(name).getPrice();
            }
        }
        return 0;
    }

    public int getMininumProduct() {
        int minimumPrice = Integer.MAX_VALUE;
        for (Product product : productMap.values()) {
            int price = product.getPrice();
            if (price < minimumPrice) {
                minimumPrice = price;
            }
        }
        return minimumPrice;
    }
}
