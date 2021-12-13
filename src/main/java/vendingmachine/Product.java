package vendingmachine;

import java.util.ArrayList;
import java.util.Collections;

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

    public static ArrayList<Product> makeProductList(ArrayList<String> strings) throws Exception{
        ArrayList<Product> products = new ArrayList<Product>();
        for (String str : strings) {
            Utils.validateNumber(str.split(",")[1]);
            Utils.validateNumber(str.split(",")[2]);
            Utils.validatePositiveNumber(Integer.parseInt(str.split(",")[1]));
            Utils.validatePositiveNumber(Integer.parseInt(str.split(",")[2]));
            Utils.validateOvervalue(Integer.parseInt(str.split(",")[1]));
            Utils.validateDividableByValue(Integer.parseInt(str.split(",")[1]));
            Utils.validateDuplication(products, str.split(",")[0]);
            Utils.validateStrEmpty(str.split(",")[0]);
            products.add(new Product(str.split(",")[0], Integer.parseInt(str.split(",")[1]), Integer.parseInt(str.split(",")[2])));
        }
        return products;
    }
}
