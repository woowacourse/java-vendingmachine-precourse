package vendingmachine;

import java.util.ArrayList;

public class Product {
    private String name;
    private int price;
    private int count;

    Product (String name, int price, int count) {
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

    public static ArrayList<Product> makeProductList(ArrayList<String> strings) {
        ArrayList<Product> products = new ArrayList<Product>();
        for (String str : strings) {
            products.add(new Product(str.split(",")[0], Integer.parseInt(str.split(",")[1]), Integer.parseInt(str.split(",")[2])));
        }
        return products;
    }
}
