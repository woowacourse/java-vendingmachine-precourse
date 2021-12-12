package vendingmachine.util.validator;

public class BalanceValidation {
    public static void verifyBalanceInput(String userInput) {
        CommonValidation.isNull(userInput, () -> new IllegalArgumentException("[ERROR]"));
        CommonValidation.isBlank(userInput, () -> new IllegalArgumentException("[ERROR]"));

        StringValidation.isNotInteger(userInput, () -> new IllegalArgumentException("[ERROR]"));
        StringValidation.isOutOfIntegerRange(userInput,  () -> new IllegalArgumentException("[ERROR]"));

        int userInputAsInt = Integer.parseInt(userInput);

        IntegerValidation.isNegative(userInputAsInt,  () -> new IllegalArgumentException("[ERROR]"));
        IntegerValidation.isNotMultiplyByTen(userInputAsInt,  () -> new IllegalArgumentException("[ERROR]"));

    }
}
