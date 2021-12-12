package vendingmachine.util;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Coin;
import vendingmachine.util.validator.BalanceValidation;
import vendingmachine.util.validator.ProductsValidation;

public class IOProvider {
    private static final String ASK_MACHINE_BALANCE_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ASK_ALL_PRODUCT_INFO_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String ASK_CONSUMER_BALANCE_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String ASK_PRODUCT_NAME_MESSAGE = "구매할 상품명을 입력해 주세요.";

    public static int initVendingMachineBalance() {
        while(true) {
            print(ASK_MACHINE_BALANCE_MESSAGE);
            try {
                String userInput = Console.readLine();
                BalanceValidation.verifyBalanceInput(userInput);
                return Integer.parseInt(userInput);
            } catch (IllegalArgumentException e) {
                IOProvider.printMessage(e.getMessage());
                continue;
            }
        }
    }

    public static String readAllProductInfo() {

        while(true) {
            print(ASK_ALL_PRODUCT_INFO_MESSAGE);
            try {
                String userInput = Console.readLine();
                ProductsValidation.verifyProductsInput(userInput);

                return userInput;
            } catch (IllegalArgumentException e) {
                IOProvider.printMessage(e.getMessage());
                continue;
            }
        }
    }

    public static int initConsumerBalance() {
        while(true) {
            print(ASK_CONSUMER_BALANCE_MESSAGE);
            try {
                String userInput = Console.readLine();
                BalanceValidation.verifyBalanceInput(userInput);

                return Integer.parseInt(userInput);
            } catch (IllegalArgumentException e) {
                IOProvider.printMessage(e.getMessage());
                continue;
            }
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }

    public static String readProductName() {
        while(true) {
            print(ASK_PRODUCT_NAME_MESSAGE);
            try {
                String product = Console.readLine();
                ProductsValidation.verifyProductInputIsNull(product);

                return product;
            } catch (IllegalArgumentException e) {
                IOProvider.printMessage(e.getMessage());
                continue;
            }
         }
    }

    public static void printChangeEachCoin(Coin coin) {
        System.out.println(coin.getCountForChangeMessage());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void addNewLine() {
        System.out.println();
    }

    public static void printVendingMachineCoins(Coin coin) {
        System.out.println(coin.getCountForMessage());
    }
}
