package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int seedMoney = getSeedMoneyFromUser();
        List<ProductInfo> productInfos = getProductInfosFromUser();

        VendingMachine vendingMachine = new VendingMachine(seedMoney);
        for (ProductInfo productInfo : productInfos) {
            vendingMachine.addProduct(new Product(productInfo.getName(), productInfo.getPrice()), productInfo.getCount());
        }


        int inputMoney = getInputMoneyFromUser();
        vendingMachine.inputMoney(inputMoney);


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

    private static List<ProductInfo> getProductInfosFromUser() {
        while(true) {
            try {
                String[] productNames = getProductNamesFromUser();
                return Arrays.stream(productNames)
                        .map(rawString -> new ProductInfo(rawString))
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<String> toList(String[] arguments) {
        List<String> result = new ArrayList<>();
        for (String argument : arguments) {
            result.add(argument);
        }
        return result;
    }


    private static String[] getProductNamesFromUser() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        return Console.readLine().split(";");
    }

    private static int getSeedMoneyFromUser() {
        while (true) {
            try {
                System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
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


}
