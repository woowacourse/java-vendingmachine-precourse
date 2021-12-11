package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

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

        Coins changes = vendingMachine.getChanges();
        printChanges(vendingMachine, changes);
    }

    private static int getSeedMoneyFromUser() {
        while (true) {
            try {
                System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
                String input = Console.readLine();
                lineFeed();
                assertNumberFormat(input);
                int number = Integer.parseInt(input);
                assertPositiveGreaterThanZero(number);
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printSeedMoneyInVendingMachine(VendingMachine vendingMachine) {
        vendingMachine.printCoins();
        lineFeed();
    }

    private static void registerProductsInVendingMachine(VendingMachine vendingMachine) {
        List<ProductInfo> productInfos = getProductInfosFromUser();
        productInfos.forEach(productInfo ->
                vendingMachine.addProduct(new Product(productInfo.getName(), productInfo.getPrice()), productInfo.getCount()));
    }

    private static List<ProductInfo> getProductInfosFromUser() {
        while(true) {
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
                assertNumberFormat(input);
                int number = Integer.parseInt(input);
                assertPositiveGreaterThanZero(number);
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printChanges(VendingMachine vendingMachine, Coins changes) {
        printInputMoneyInVendingMachine(vendingMachine);
        System.out.println("잔돈");
        changes.printCoins();
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



    private static void assertPositiveGreaterThanZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액(수량)은 0 이상이어야 합니다.");
        }
    }

    private static void assertNumberFormat(String input) {
        try {
            int number = Integer.parseInt(input);
            assertPositiveGreaterThanZero(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액(수량)은 숫자여야 합니다.");
        }
    }


    private static void lineFeed() {
        System.out.println();
    }
}
