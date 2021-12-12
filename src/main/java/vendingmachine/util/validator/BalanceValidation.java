package vendingmachine.util.validator;

public class BalanceValidation {
    public static void verifyBalanceInput(String userInput) {
        StringValidation.isNotInteger(userInput, () -> new IllegalArgumentException("[ERROR]"));
        StringValidation.isOutOfIntegerRange(userInput,  () -> new IllegalArgumentException("[ERROR]"));

        int userInputAsInt = Integer.parseInt(userInput);

        IntegerValidation.isNegative(userInputAsInt,  () -> new IllegalArgumentException("[ERROR]"));
        IntegerValidation.isNotMultiplyByTen(userInputAsInt,  () -> new IllegalArgumentException("[ERROR]"));

    }
}
