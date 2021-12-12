package vendingmachine.util.validator;

public class ProductsValidation {

    public static void verifyProductsInput(String userInput) {
        CommonValidation.isNull(userInput, () -> new IllegalArgumentException("[ERROR]"));

        ProductsInfoValidation.verifySeparator(userInput, () -> new IllegalArgumentException("[ERROR]"));
        ProductsInfoValidation.verifyRegex(userInput, () -> new IllegalArgumentException("[ERROR]"));
        ProductsInfoValidation.verifyDuplicateProductName(userInput, () -> new IllegalArgumentException("[ERROR]"));
    }

    public static void verifyProductInputIsNull(String productName) {
        CommonValidation.isNull(productName, () -> new IllegalArgumentException());
    }
}
