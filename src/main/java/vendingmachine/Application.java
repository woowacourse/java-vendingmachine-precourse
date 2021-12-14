package vendingmachine;

import java.util.ArrayList;

public class Application {
    public static int getInitCoin() {
        System.out.println(Constants.coinInitMsg);
        while (true) {
            try {
                String input = camp.nextstep.edu.missionutils.Console.readLine();
                InputChecker.checkNumber(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }
        }
    }

    public static void printCoinStatus() {
        System.out.println();
        System.out.println(Constants.coinStatusMsg);
        for (Coin c: Coin.values()) {
            System.out.println(c.getAmount() + "원 - " + c.getCount() + "개");
        }
    }

    public static ArrayList<Product> getInitProduct() {
        System.out.println();
        System.out.println(Constants.productInitMsg);
        while (true) {
            try {
                String input = camp.nextstep.edu.missionutils.Console.readLine();
                return generateProducts(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }
        }
    }

    public static ArrayList<Product> generateProducts(String input) {
        ArrayList<Product> products = new ArrayList<>();
        String[] splited = input.split(";");
        // for (String s: splited) {
        //
        // }
        return products;
    }

    public static void main(String[] args) {
        int initCoin = getInitCoin();
        VendingMachine vm = new VendingMachine(initCoin);
        printCoinStatus();
        ArrayList<Product> products = getInitProduct();
    }
}
