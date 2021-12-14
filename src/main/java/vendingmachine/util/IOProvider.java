package vendingmachine.util;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.coin.Coin;
import vendingmachine.util.validator.validation.BalanceValidation;
import vendingmachine.util.validator.validation.ProductsValidation;

import static vendingmachine.util.finalstring.Message.*;

public class IOProvider {
    public static int initVendingMachineBalance() {
        while (true) {
            printMessage(ASK_MACHINE_BALANCE_MESSAGE.getMessage());
            try {
                return inputVendingMachineBalance();
            } catch (IllegalArgumentException e) {
                IOProvider.printMessage(e.getMessage());
                continue;
            }
        }
    }

    private static int inputVendingMachineBalance() {
        String userInput = Console.readLine();
        BalanceValidation.verifyBalanceInput(userInput);

        return Integer.parseInt(userInput);
    }

    public static String readAllProductInfo() {
        while (true) {
            printMessage(ASK_ALL_PRODUCT_INFO_MESSAGE.getMessage());
            try {
                return inputAllProductInfo();
            } catch (IllegalArgumentException e) {
                IOProvider.printMessage(e.getMessage());
                continue;
            }
        }
    }

    private static String inputAllProductInfo() {
        String userInput = Console.readLine();
        ProductsValidation.verifyProductsInput(userInput);

        return userInput;
    }

    public static int initConsumerBalance() {
        while (true) {
            printMessage(ASK_CONSUMER_BALANCE_MESSAGE.getMessage());
            try {
                return inputConsumerBalance();
            } catch (IllegalArgumentException e) {
                IOProvider.printMessage(e.getMessage());
                continue;
            }
        }
    }

    private static int inputConsumerBalance() {
        String userInput = Console.readLine();
        BalanceValidation.verifyBalanceInput(userInput);

        return Integer.parseInt(userInput);
    }

    public static String readProductName() {
        while (true) {
            printMessage(ASK_PRODUCT_NAME_MESSAGE.getMessage());
            try {
                return inputProductToBuy();
            } catch (IllegalArgumentException e) {
                IOProvider.printMessage(e.getMessage());
                continue;
            }
        }
    }

    private static String inputProductToBuy() {
        String product = Console.readLine();
        ProductsValidation.verifyProductInputIsNull(product);

        return product;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void addNewLine() {
        System.out.println();
    }

    public static void printChangeEachCoin(Coin coin) {
        System.out.println(coin.toStringChange());
    }

    public static void printVendingMachineCoins(Coin coin) {
        System.out.println(coin.toStringRemaining());
    }
}
