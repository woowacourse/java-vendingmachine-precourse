package vendingmachine.repository;


import vendingmachine.model.Coin;
import vendingmachine.model.VendingMachine;

import java.util.Map;

public class MachineRepository {
    private static final VendingMachine vendingMachine = new VendingMachine();

    public static void saveInitialAmount(String amount) {
        int initialAmount = Integer.parseInt(amount);
        vendingMachine.setInitialAmount(initialAmount);
    }

    public static void saveUserInsertAmount(String userAmount) {
        int amount = Integer.parseInt(userAmount);
        vendingMachine.setUserInsertAmount(amount);
    }

    public static Map<Coin, Integer> getCoins() {
        return vendingMachine.getCoins();
    }

    public static int getUserInsertAmount() {
        return vendingMachine.getUserInsertAmount();
    }

    public static Map<Coin, Integer> getChanges() {
        return vendingMachine.getChanges();
    }

    public static void reduceUserAmount(int productPrice) {
        vendingMachine.reduceAmount(productPrice);
    }
}
