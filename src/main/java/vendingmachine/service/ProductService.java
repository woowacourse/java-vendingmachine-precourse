package vendingmachine.service;

import vendingmachine.domain.Product;

import java.util.ArrayList;

public class ProductService {
    private static ArrayList<Product> productsList = new ArrayList<>();

    public static ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void addProducts(String[] products) {
        for (String product : products) {
            String removedBrackets = product.substring(1, product.length() - 1);
            String[] divided = removedBrackets.split(",");
            productsList.add(new Product(divided[0], Integer.parseInt(divided[1]), Integer.parseInt(divided[2])));
        }
    }

    public int getMaxPrice() {
        int result = 0;
        for (Product p : productsList) {
            result = Math.max(result, p.getPrice());
        }
        return result;
    }

    public int calculateProduct(String name) {
        for (Product p : productsList) {
            if (p.isSameName(name)) {
                p.decreaseNumber();
                return p.getPrice();
            }
        }
        return 0;
    }
}
