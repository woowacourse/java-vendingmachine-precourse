package vendingmachine.Domain;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private static VendingMachine instance = new VendingMachine();
    private static List<Product> products;
    private static int inputAmount;

    private VendingMachine() {
        this.products = new ArrayList<>();
        this.inputAmount = 0;
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

    public static void inputMoney(int amount) {
        inputAmount += amount;
    }
}


