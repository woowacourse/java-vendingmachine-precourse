package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {


    private static final String PRODUCT_INFO_SEPARATOR = ";";

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(getSeedMoneyFromUser());

        printSeedMoneyInVendingMachine(vendingMachine);
        registerProductsInVendingMachine(vendingMachine);
        vendingMachine.inputMoney(getInputMoneyFromUser());

        while (vendingMachine.isProvidable()) {
            printInputMoneyInVendingMachine(vendingMachine);
            buyProduct(vendingMachine);
        }

        printInputMoneyInVendingMachine(vendingMachine);
        Coins changes = vendingMachine.getChanges();
        printChanges(changes);
    }

    private static int getSeedMoneyFromUser() {
        while (true) {
            try {
                System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
                String input = Console.readLine();
                lineFeed();
                Validator.checkNumberFormat(input);
                int number = Integer.parseInt(input);
                Validator.checkPositive(number);
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printSeedMoneyInVendingMachine(VendingMachine vendingMachine) {
        System.out.println("자판기가 보유한 동전");
        vendingMachine.getCoins()
                .getCounter()
                .forEach((key, value) -> {
                    int amount = key.getAmount();
                    int count = value;
                    System.out.println(amount + "원 - " + count + "개");
                });
        lineFeed();
    }

    private static void registerProductsInVendingMachine(VendingMachine vendingMachine) {
        List<ProductInfo> productInfos = getProductInfosFromUser();
        productInfos.forEach(productInfo ->
                vendingMachine.addProduct(new Product(productInfo.getName(), productInfo.getPrice()), productInfo.getCount()));
    }

    private static List<ProductInfo> getProductInfosFromUser() {
        while (true) {
            try {
                String[] productNames = getProductNamesFromUser();
                return Arrays.stream(productNames)
                        .map(ProductInfo::new)
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String[] getProductNamesFromUser() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String[] result = Console.readLine().split(PRODUCT_INFO_SEPARATOR);
        lineFeed();
        return result;
    }

    private static int getInputMoneyFromUser() {
        while (true) {
            try {
                System.out.println("투입 금액을 입력해 주세요.");
                String input = Console.readLine();
                lineFeed();
                Validator.checkNumberFormat(input);
                int number = Integer.parseInt(input);
                Validator.checkPositive(number);
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printChanges(Coins changes) {
        System.out.println("잔돈");
        changes.getCounter().entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .forEach(entry -> {
                    int amount = entry.getKey().getAmount();
                    int count = entry.getValue();
                    System.out.println(amount + "원 - " + count + "개");
                });
    }

    private static void printInputMoneyInVendingMachine(VendingMachine vendingMachine) {
        System.out.println("투입 금액: " + vendingMachine.getInputMoney() + "원");
    }

    private static void buyProduct(VendingMachine vendingMachine) {
        try {
            System.out.println("구매할 상품명을 입력해 주세요.");
            Product product = vendingMachine.findProduct(Console.readLine());
            lineFeed();
            vendingMachine.get(product);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyProduct(vendingMachine);
        }
    }

    private static void lineFeed() {
        System.out.println();
    }
}
