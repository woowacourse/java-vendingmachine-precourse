package vendingmachine.util;

import vendingmachine.domain.product.Product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSeparator {
    private static final String REGEX = "\\[([a-zA-Z가-힣0-9]+),(\\d{3,}+),(\\d+)]";
    private static final int PRODUCT_NAME_OF_GROUP = 1;
    private static final int PRODUCT_PRICE_OF_GROUP = 2;
    private static final int PRODUCT_AMOUNT_OF_GROUP = 3;

    public static Product mapInfoToProduct(String productInfo) {
        return matcherToProduct(matchInfoWithRegex(productInfo));
    }

    private static Matcher matchInfoWithRegex(String productInfo) {
        return Pattern.compile(REGEX).matcher(productInfo);
    }

    private static Product matcherToProduct(Matcher productInfoMatcher) {
        if (productInfoMatcher.find()) {
            return Product.of(productInfoMatcher.group(PRODUCT_NAME_OF_GROUP),
                    parseInt(productInfoMatcher.group(PRODUCT_PRICE_OF_GROUP)),
                    parseInt(productInfoMatcher.group(PRODUCT_AMOUNT_OF_GROUP)));
        }
        return null;
    }

    private static int parseInt(String target) {
        return Integer.parseInt(target);
    }
}
