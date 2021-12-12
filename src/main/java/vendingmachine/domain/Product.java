package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private String productName;
    private int price;
    private int quantity;

    public Product(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity() {
        quantity = quantity - 1;
    }

    public static List<Product> createProductList(String input) {
        List<Product> productList = new ArrayList<>();

        String[] splitString = input.split(";");

        for (String s : splitString) {

            String[] resultStrings = splitProductInfo(s);

            Product product = createProduct(resultStrings);

            productList.add(product);
        }

        return productList;
    }

    private static String[] splitProductInfo(String splitString) {
        String resultString = splitString.substring(0, splitString.length() -1);

        String[] resultStrings = resultString.split(",");

        return resultStrings;
    }

    private static Product createProduct(String[] strings) {
        String productName = strings[0];

        int price = Integer.parseInt(strings[1]);

        int quantity = Integer.parseInt(strings[2]);

        Product product = new Product(productName, price, quantity);

        return product;
    }
}
