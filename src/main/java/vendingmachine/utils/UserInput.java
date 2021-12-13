package vendingmachine.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.function.Supplier;
import vendingmachine.domain.Product;
import vendingmachine.validator.InputValidator;

public class UserInput {

    public static List<Product> getProductList() {
        return getValidInput(
            () -> ProductParser.parse(Console.readLine())
        );
    }

    public static String getProductName() {
        return getValidInput(() -> {
            String input = Console.readLine();
            // TODO implement me
            return input;
        });
    }

    public static int getValidInputAmount() {
        return getValidNumber();
    }

    public static int getValidCash() {
        return getValidNumber();
    }

    private static int getValidNumber() {
        return getValidInput(() -> {
            String input = Console.readLine();
            InputValidator.validateNumeric(input);
            return Integer.parseInt(input);
        });
    }

    public static <T> T getValidInput(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidInput(supplier);
        }
    }
}
