package vendingmachine.Domain;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private static VendingMachine instance = new VendingMachine();
    private static List<Product> products;

    private VendingMachine() {
        this.products = new ArrayList<>();
    }

    public static void addProduct(Product p) {
        products.add(p);
    }

    public static void clearList() {
        products.clear();
    }

    public static Product findProductByName(String name) {
        for (Product p : products) {
            if (p.isSameName(name)) {
                return p;
            }
        }
        return null;
    }

    public static boolean isAnyThingToPurchase() {
        for (Product p : products) {
            if (p.isRemain() && p.canPurchase()) {
                return true;
            }
        }
        return false;
    }

    public static void findAndPurchase(String name) {
        findProductByName(name).purchase();
    }

}


