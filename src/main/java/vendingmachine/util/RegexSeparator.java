package vendingmachine.util;

import vendingmachine.domain.product.Product;
import vendingmachine.util.validator.IntegerValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSeparator {
    private static final String REGEX = "\\[([a-zA-Z가-힣0-9]+),([1-9]\\d{3,}),(\\d+)]";
    private static final int PRODUCT_NAME_OF_GROUP = 1;
    private static final int PRODUCT_PRICE_OF_GROUP = 2;
    private static final int PRODUCT_AMOUNT_OF_GROUP = 3;

    public static String getNameFromProductInfo(String productInfo) {
        return getNameAfterRegex(matchInfoWithRegex(productInfo));
    }

    public static Product mapInfoToProduct(String productInfo) {
        return convertMatcherToProduct(matchInfoWithRegex(productInfo));
    }

    private static Matcher matchInfoWithRegex(String productInfo) {
        return Pattern.compile(REGEX).matcher(productInfo);
    }
    private static String getNameAfterRegex(Matcher productInfoMatcher) {
        String name = null;
        if(productInfoMatcher.find())
            name = productInfoMatcher.group(PRODUCT_NAME_OF_GROUP);

        return name;
    }
    private static Product convertMatcherToProduct(Matcher productInfoMatcher) {
        if (productInfoMatcher.find()) {
            verifyPrice(parseInt(productInfoMatcher.group(PRODUCT_PRICE_OF_GROUP)));
            verifyAmount(parseInt(productInfoMatcher.group(PRODUCT_AMOUNT_OF_GROUP)));

            return Product.of(productInfoMatcher.group(PRODUCT_NAME_OF_GROUP),
                    parseInt(productInfoMatcher.group(PRODUCT_PRICE_OF_GROUP)),
                    parseInt(productInfoMatcher.group(PRODUCT_AMOUNT_OF_GROUP)));
        }
        return null;
    }

    private static void verifyPrice(int price) {
        IntegerValidator.isNotMultiplyByTen(price, () -> new IllegalArgumentException("[ERROR]"));
    }

    private static void verifyAmount(int amount) {
        IntegerValidator.isNegative(amount, () -> new IllegalArgumentException("[ERROR]"));
    }

    private static int parseInt(String target) {
        return Integer.parseInt(target);
    }

    public static boolean isNotValid(String userInput) {
        return !Pattern.matches(REGEX, userInput);
    }
}
