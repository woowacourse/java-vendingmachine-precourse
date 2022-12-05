package vendingmachine.Domain;

import vendingmachine.Constant.ProductSeparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Product {

    private final HashMap<String, HashMap<String, Integer>> product;
    Integer cheapestPrice = null;

    public Product() {
        this.product = new HashMap<>();
    }

    public void addProduct(String name, int price, int count) {
        this.product.put(name, new HashMap<>() {{
            put(ProductSeparator.PRICE, price);
            put(ProductSeparator.COUNT, count);
        }});

        if (cheapestPrice == null) {
            cheapestPrice = price;
            return;
        }

        cheapestPrice = Math.min(cheapestPrice, price);
    }

    public List<String> getNames() {
        return new ArrayList<>(this.product.keySet());
    }

    public int getPrice(String name) {
        return this.product.get(name).get(ProductSeparator.PRICE);
    }

    public int getCount(String name) {
        return this.product.get(name).get(ProductSeparator.COUNT);
    }

    public void sold(String name) {
        int count = this.product.get(name).get(ProductSeparator.COUNT) - 1;
        this.product.get(name).put(ProductSeparator.COUNT, count);
    }

}
