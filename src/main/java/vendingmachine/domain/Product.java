package vendingmachine.domain;

import java.util.HashMap;

public class Product {
    HashMap<String, Integer> productPrice;
    HashMap<String, Integer> productCount;

    public Product() {
        productPrice = new HashMap<>();
        productCount = new HashMap<>();
    }

    public void putProductPrice(String name, int price) {
        productPrice.put(name, price);
    }

    public void putProductCount(String name, int count) {
        productCount.put(name, count);
    }

    public void replaceProductPrice(String name, int price) {
        productPrice.replace(name, price);
    }

    public void replaceProductCount(String name, int count) {
        productCount.replace(name, count);
    }
}
