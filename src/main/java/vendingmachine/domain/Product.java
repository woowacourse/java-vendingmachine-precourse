package vendingmachine.domain;

import java.util.HashMap;

public class Product {
    HashMap<String, Integer> productPrice;
    HashMap<String, Integer> productCount;
    int minPrice;
    int sumCount;

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

    public int getPrice(String name) {
        return productPrice.get(name);
    }

    public int getCount(String name) {
        return productCount.get(name);
    }

    public void setMinPrice() {
        minPrice = Integer.MAX_VALUE;
        for (Integer price : productPrice.values()) {
            if (minPrice > price) {
                minPrice = price;
            }
        }
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setSumCount() {
        sumCount = 0;
        for (Integer count : productCount.values()) {
            sumCount += count;
        }
    }

    public int getSumCount() {
        return sumCount;
    }

    public boolean hasInProduct(String name) {
        if (productPrice.keySet().contains(name)) {
            return true;
        }
        return false;
    }
}
