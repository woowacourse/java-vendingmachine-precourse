package vendingmachine;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setRandomValueToEachCoin();
        ArrayList<Product> productList = vendingMachine.insertProductToVendingMachine();
        User user = new User();
        vendingMachine.startVendingMachine(productList, user);
    }
}
