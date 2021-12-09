package vendingmachine.products;

import vendingmachine.ValidatorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsValidator {
    private static final String PREFIX = ValidatorMessage.ERROR_MESSAGE;
    private static final String PRODUCTS_SEPARATE_UNIT = ";";
    private static final String PRODUCT_INFO_SEPARATE_UNIT = ",";
    private static final char START_BRACKET = '[';
    private static final char END_BRACKET = ']';
    private static final int START_INDEX = 0;

    private static final int PRODUCT_NAME_INFO_INDEX = 0;
    private static final int PRODUCT_PRICE_INFO_INDEX = 1;
    private static final int PRODUCT_COUNTS_INFO_INDEX = 2;

    public static void validateProductInfo(String productInfo) {
        if (!checkAnyInput(productInfo)) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.NULL_MESSAGE);
        }
        if (!checkForm(productInfo)) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.PRODUCT_INFO_INVALID_MESSAGE);
        }
    }

    public static void validateRightInfo(String rightFormInfo) {
        List<String> infoList = eliminateSemiColonAndBracket(rightFormInfo);
        checkNameValidForm(collectOnlyInfos(infoList, PRODUCT_NAME_INFO_INDEX));
        checkPriceValid(collectOnlyInfos(infoList, PRODUCT_PRICE_INFO_INDEX));
        checkCountsValid(collectOnlyInfos(infoList, PRODUCT_COUNTS_INFO_INDEX));
    }

    public static boolean checkAnyInput(String productInfo) {
        return !productInfo.isEmpty();
    }

    public static boolean checkForm(String productInfo) {
        return checkSemiColonAndBracket(productInfo) && checkRestMarkCounts(productInfo);
    }

    private static void checkNameValidForm(List<String> productsName) {
        if (productsName.stream().anyMatch(name -> name.contains(String.valueOf(START_BRACKET))
                || name.contains(String.valueOf(END_BRACKET))
                || name.contains(PRODUCT_INFO_SEPARATE_UNIT))) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.PRODUCT_NAME_INVALID_MESSAGE);
        }
        if (productsName.stream().distinct().count() != productsName.size()) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.PRODUCT_NAME_DUPLICATE_MESSAGE);
        }
        if (productsName.stream().anyMatch(name -> name.length() == 0)) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.NULL_MESSAGE);
        }
    }

    private static void checkPriceValid(List<String> productsPrice) {
        if (productsPrice.stream().anyMatch(price -> !price.matches(ValidatorMessage.NUMBER_REGEX))) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.IS_NUMBER_MESSAGE);
        }
        if (productsPrice.stream().anyMatch(price -> Integer.parseInt(price) < 100)) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.PRODUCT_MIN_PRICE_MESSAGE);
        }
        if (productsPrice.stream().anyMatch(price -> Integer.parseInt(price) % 10 != 0)) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.PRODUCT_PRICE_TENFOLD_MESSAGE);
        }
    }

    private static void checkCountsValid(List<String> productsCounts) {
        if (productsCounts.stream().filter(counts -> counts.matches(ValidatorMessage.NATURAL_NUMBER_REGEX))
                .count() != productsCounts.size()) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.IS_NATURAL_NUMBER_MESSAGE);
        }
    }

    private static boolean checkRestMarkCounts(String productInfo) {
        return eliminateSemiColonAndBracket(productInfo).size() % 3 == 0
                && eliminateSemiColonAndBracket(productInfo).size() != 0;
    }

    private static boolean checkSemiColonAndBracket(String productInfo) {
        return Arrays.stream(productInfo.split(PRODUCTS_SEPARATE_UNIT))
                .filter(info -> info.length() >= 2 && info.charAt(START_INDEX) == START_BRACKET
                        && info.charAt(info.length() - 1) == END_BRACKET)
                .count() == productInfo.split(PRODUCTS_SEPARATE_UNIT).length;
    }

    private static List<String> collectOnlyInfos(List<String> infoList, int particularIndex) {
        List<String> infos = new ArrayList<>();
        for (int i = particularIndex; i < infoList.size(); i += 3) {
            infos.add(infoList.get(i));
        }
        return infos;
    }

    public static List<String> eliminateSemiColonAndBracket(String productInfo) {
        return Arrays.asList(productInfo.replace(";", ",")
                .replace("[", "")
                .replace("]", "")
                .split(PRODUCT_INFO_SEPARATE_UNIT));
    }
}
