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
        return products
                .stream()
                .filter(p -> p.isSameName(name))
                .findFirst()
                .orElse(null);
    }

    public static boolean isAnyThingToPurchase() {
        return products
                .stream()
                .filter(p -> p.isRemain() && p.canPurchase())
                .findFirst()
                .orElse(null)
                != null;
    }

    public static void findAndPurchase(String name) {
        findProductByName(name).purchase();
    }

}


