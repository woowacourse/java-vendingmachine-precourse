package vendingmachine;

import vendingmachine.utils.Validator;

public class ProductInfo {

    // 기본 이름 형식을 지킨 경우 최소 길이가 7이다.
    private static final int MIN_NAME_LENGTH = 7;
    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int COUNT_INDEX = 2;
    private static final String ARGUMENT_SEPARATOR = ",";
    private static final int REQUIRED_ARGUMENT_SIZE = 3;
    private static final int MIN_PRICE = 100;
    private static final int REQUIRED_PRICE_RATIO = 10;
    public static final char PRODUCT_NAME_OPEN_PARENTHESIS = '[';
    public static final char PRODUCT_NAME_CLOSE_PARENTHESIS = ']';

    private final String name;
    private final int price;
    private final int count;

    public ProductInfo(String rawString) {
        checkNameFormat(rawString);
        String noParenthesis = stripParenthesis(rawString);
        String[] arguments = noParenthesis.split(ARGUMENT_SEPARATOR);

        validateNumberArguments(arguments);
        name = arguments[NAME_INDEX];
        price = Integer.parseInt(arguments[PRICE_INDEX]);
        count = Integer.parseInt(arguments[COUNT_INDEX]);
    }

    private void checkNameFormat(String productName) {
        if (productName.length() < MIN_NAME_LENGTH && !hasParenthesis(productName)) {
            throw new IllegalArgumentException("[ERROR] 상품 입력 형식이 올바르지 않습니다.");
        }
    }

    private boolean hasParenthesis(String productName) {
        return productName.length() > 0
                && productName.charAt(0) == PRODUCT_NAME_OPEN_PARENTHESIS
                && productName.charAt(productName.length() - 1) == PRODUCT_NAME_CLOSE_PARENTHESIS;
    }

    private String stripParenthesis(String productName) {
        return productName.substring(1, productName.length() - 1);
    }

    private void validateNumberArguments(String[] arguments) {
        checkArgumentsSize(arguments);
        Validator.checkNumberFormat(arguments[PRICE_INDEX]);
        checkPriceConstraints(arguments[PRICE_INDEX]);
        Validator.checkNumberFormat(arguments[COUNT_INDEX]);
    }

    private void checkArgumentsSize(String[] arguments) {
        if (arguments.length < REQUIRED_ARGUMENT_SIZE) {
            throw new IllegalArgumentException("[ERROR] 상품 입력 형식이 올바르지 않습니다.");
        }
    }

    private void checkPriceConstraints(String input) {
        int price = Integer.parseInt(input);
        if (price < MIN_PRICE || isValidPriceValue(price)) {
            throw new IllegalArgumentException(
                    "[ERROR] 상품 가격은 " + MIN_PRICE + "원부터 시작하며 "
                            + REQUIRED_PRICE_RATIO + "으로 나누어떨어져야 합니다. 현재 가격 = " + price
            );
        }
    }

    /*
    * 상품 가격은 10으로 나누어떨어져야한다.
    * */
    private boolean isValidPriceValue(int price) {
        return price % REQUIRED_PRICE_RATIO != 0;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
