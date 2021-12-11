package vendingmachine.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    private static final String MONEY_ERROR_SENETENCE = "[ERROR] 금액은 숫자여야 합니다.";
    private static final String PRODUCT_ERROR_SENETENCE = "[ERROR] 올바른 상품 정보를 입력해주십시오.";
    private static final String DIVISOR_PRODUCT_LIST = ";";
    private static final String DIVISOR_PRODUCT = ",";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private static final int DIVISOR_PRICE = 10;
    private static final int MIN_PRICE = 100;
    private static final char OPEN_BRACKET = '[';
    private static final int CLOSE_BRACKET = ']';
    private static final int NEGATIVE_NUMBER = -1;

    public boolean isValidMoney(String input) {
        if (!isNumber(input)
                || !isNaturalNumber(input)
                || !isDivideByDivisor(input)) {
            throw new IllegalArgumentException(MONEY_ERROR_SENETENCE);
        }
        return true;
    }

    public boolean isValidProduct(String input) {
        if (!isValidProductList(input)) {
            throw new IllegalArgumentException(PRODUCT_ERROR_SENETENCE);
        }
        return true;
    }

    private boolean isValidBracket(String input) {
        return input.charAt(0) == OPEN_BRACKET
                && input.charAt(input.length() - 1) == CLOSE_BRACKET;
    }

    private boolean isValidProductList(String input) {
        List<String> names = new ArrayList<>();

        for (String product : input.split(DIVISOR_PRODUCT_LIST, NEGATIVE_NUMBER)) {
            if (isStringEmpty(product) || !isValidBracket(product)) {
                return false;
            }
            String[] productInfo = splitProductInfo(product);
            if (isDuplicateName(names, productInfo[0])
                    || !isValidPrice(productInfo[1])
                    || !isValidStock(productInfo[2])) {
                return false;
            }
            names.add(productInfo[0]);
        }
        return true;
    }

    private boolean isStringEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private String[] splitProductInfo (String input) {
        return input.substring(1, input.length() - 1).split(DIVISOR_PRODUCT);
    }

    private boolean isValidPrice(String input) {
        return isNumber(input)
                && isNaturalNumber(input)
                && isDivideByDivisor(input)
                && isOverMinPrice(input);
    }

    private boolean isValidStock(String input) {
        return isNumber(input) && isNaturalNumber(input);
    }

    private boolean isOverMinPrice(String input) {
        return Integer.parseInt(input) >= MIN_PRICE;
    }

    private boolean isDuplicateName(List<String> names, String name) {
        return names != null && names.contains(name);
    }

    private boolean isNumber(String input) {
        return NUMBER_PATTERN.matcher(input).matches();
    }

    private boolean isNaturalNumber(String input) {
        return Integer.parseInt(input) >= 0;
    }

    private boolean isDivideByDivisor(String input) {
        return Integer.parseInt(input) % DIVISOR_PRICE == 0;
    }
}
