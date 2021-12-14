package vendingmachine;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    private static final Printer printer = new Printer();
    private static final Input input = new Input();

    private final Map<Coin, Integer> machineCoins;
    private final List<Product> products;
    private int customerMoney;

    public VendingMachine(Map<Coin, Integer> machineCoins, List<Product> products) {
        this.machineCoins = machineCoins;
        this.products = products;
    }

    public void run() {
        printer.printCustomerMoneyInputMessage();
        customerMoney = input.inputMoney();

        int minimumAmount = getMinimumAmount();
        while (minimumAmount != 0 && customerMoney >= minimumAmount) {
            printer.printCustomerMoney(customerMoney);
            printer.printPurchaseProductInputMessage();
            String productName = input.inputProductName();
            sellProduct(productName);
            minimumAmount = getMinimumAmount();
        }
        printer.printCustomerMoney(customerMoney);
        giveChanges();
    }

    private void sellProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                product.sell();
                customerMoney -= product.getPrice();
            }
        }
    }

    private void giveChanges() {
        Map<Coin, Integer> changes = new LinkedHashMap<>();
        if (customerMoney != 0) {
            changes = makeChanges();
        }

        printer.printChanges(changes);
    }

    private Map<Coin, Integer> makeChanges() {
        Map<Coin, Integer> changes = new LinkedHashMap<>();

        for (Coin coin : machineCoins.keySet()) {
            makeChange(changes, coin);
        }

        return changes;
    }

    private void makeChange(Map<Coin, Integer> changes, Coin coin) {
        int amount = coin.getAmount();
        int quantity = machineCoins.get(coin);

        if (quantity != 0 && customerMoney / amount >= quantity) {
            customerMoney -= amount * quantity;
            reduceMachineCoin(coin, quantity);
            changes.put(coin, quantity);
            return;
        }
        if (quantity != 0 && customerMoney / amount < quantity) {
            customerMoney -= amount * (customerMoney / amount);
            reduceMachineCoin(coin, customerMoney / amount);
            changes.put(coin, customerMoney / amount);
        }
    }

    private void reduceMachineCoin(Coin coin, int quantity) {
        this.machineCoins.put(coin, machineCoins.get(coin) - quantity);
    }

    private int getMinimumAmount() {
        return products.stream()
            .filter(product -> product.getQuantity() > 0)
            .min(Comparator.comparing(Product::getPrice))
            .map(Product::getPrice)
            .orElse(0);
    }
}
