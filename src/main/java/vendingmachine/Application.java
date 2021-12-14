package vendingmachine;

import java.util.ArrayList;

public class Application {
    public static int getCoin() {
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
        for (String s: splited) {
            InputChecker.checkProduct(s);
            String[] productInfo = s.substring(1, s.length() - 1).split(",");
            Product p = new Product(productInfo[0], Integer.parseInt(productInfo[1]), Integer.parseInt(productInfo[2]));
            products.add(p);
        }
        return products;
    }

    public static void main(String[] args) {
        // 자판기 초기 세팅
        System.out.println(Constants.coinInitMsg);
        int initCoin = getCoin();
        VendingMachine vm = new VendingMachine(initCoin);
        printCoinStatus();
        // 상품들 초기 세팅
        ArrayList<Product> products = getInitProduct();
        vm.setInitProducts(products);
        // 돈 받아서 상품 구매 및 잔돈 출력
        System.out.println();
        System.out.println(Constants.coinInputMsg);
        int inputCoin = getCoin();
        vm.buyProducts(inputCoin);
    }
}
