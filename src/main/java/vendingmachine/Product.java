package vendingmachine;

import java.util.ArrayList;
import java.util.Collections;

public class Product {
    private String name;
    private int price;
    private int count;

    Product(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getCount() {
        return this.count;
    }

    public void reduceCount() {
        this.count -= 1;
    }

    public static ArrayList<Product> makeProductList(ArrayList<String> strings) throws Exception {
        ArrayList<Product> products = new ArrayList<Product>();
        for (String str : strings) {
            String name = str.split(",")[0];
            String price = str.split(",")[1];
            String count = str.split(",")[2];
            Utils.validateNameCommon(products, name);
            Utils.validatePriceCommon(price);
            Utils.validateCountCommon(count);
            products.add(new Product(name, Integer.parseInt(price), Integer.parseInt(count)));
        }
        return products;
    }
}
