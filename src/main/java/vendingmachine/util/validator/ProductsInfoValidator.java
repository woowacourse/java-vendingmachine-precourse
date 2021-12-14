package vendingmachine.util.validator;

import vendingmachine.util.RegexSeparator;
import vendingmachine.util.validator.ThrowIllegalSupplier;

import java.util.HashSet;
import java.util.Set;

import static vendingmachine.util.validator.Validator.acceptThrow;

public class ProductsInfoValidator {
    private static final int NO_LENGTH = 1;
    private static Set<String> productNameSet;


    public static void verifySeparator(String userInput, ThrowIllegalSupplier validator) {
        if (userInput.split(";").length == NO_LENGTH) {
            acceptThrow(() -> validator.get());
        }
    }

    public static void verifyEachRegex(String eachProduct, ThrowIllegalSupplier validator) {
        if (RegexSeparator.isNotValid(eachProduct)) {
            acceptThrow(() -> validator.get());
        }
    }

    public static void verifyRegex(String userInput, ThrowIllegalSupplier validator) {
        for (String eachProduct : userInput.split(";")) {
            verifyEachRegex(eachProduct, validator);
        }
    }

    public static void verifyDuplicateProductName(String productsInfo, ThrowIllegalSupplier validator) {
        productNameSet = new HashSet<>();

        for (String eachProduct : productsInfo.split(";")) {
            verifyDuplicate(eachProduct, validator);
        }
    }

    private static void verifyDuplicate(String eachProduct, ThrowIllegalSupplier validator) {
        String productName = RegexSeparator.getNameFromProductInfo(eachProduct);
        if (productNameSet.contains(productName)) {
            acceptThrow(() -> validator.get());
        }

        productNameSet.add(productName);
    }
}
