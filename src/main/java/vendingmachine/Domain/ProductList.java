package vendingmachine.Domain;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private static ProductList instance = new ProductList();
    private static List<Product> products;

    private ProductList() {
        this.products = new ArrayList<>();
    }

    public static void addProduct(Product p) {
        products.add(p);
    }

    public static void clearList() {
        products.clear();
    }

    public static boolean isDuplicatedProductName(String name) {
        for (Product p : products) {
            if (p.isSameName(name)) {
                return true;
            }
        }
        return false;
    }
}


