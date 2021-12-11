package vendingmachine;

import vendingmachine.utils.Validator;

public class ProductInfo {

    // 기본 이름 형식을 지킨 경우 최소 길이가 7이다.
    private static final int MIN_NAME_LENGTH = 7;
    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int COUNT_INDEX = 2;
    private static final String ARGUMENT_SEPARATOR = ",";

    private final String name;
    private final int price;
    private final int count;

    public ProductInfo(String rawString) {
        assertNameFormat(rawString);
        String noParenthesis = stripParenthesis(rawString);
        String[] arguments = noParenthesis.split(ARGUMENT_SEPARATOR);

        validateNumberArguments(arguments);
        name = arguments[NAME_INDEX];
        price = Integer.parseInt(arguments[PRICE_INDEX]);
        count = Integer.parseInt(arguments[COUNT_INDEX]);
    }

    private void assertNameFormat(String productName) {
        if (productName.length() < MIN_NAME_LENGTH && !hasParenthesis(productName)) {
            throw new IllegalArgumentException("[ERROR] 상품 입력 형식이 올바르지 않습니다.");
        }
    }

    private boolean hasParenthesis(String productName) {
        return productName.length() > 0
                && productName.charAt(0) == '['
                && productName.charAt(productName.length() - 1) == ']';
    }

    private String stripParenthesis(String productName) {
        return productName.substring(1, productName.length() - 1);
    }

    private void validateNumberArguments(String[] arguments) {
        assertArgumentsSize(arguments);
        Validator.assertNumberFormat(arguments[PRICE_INDEX]);
        assertPriceConstraints(arguments[PRICE_INDEX]);
        Validator.assertNumberFormat(arguments[COUNT_INDEX]);
    }

    private void assertArgumentsSize(String[] arguments) {
        if (arguments.length < 3) {
            throw new IllegalArgumentException("[ERROR] 상품 입력 형식이 올바르지 않습니다.");
        }
    }

    private void assertPriceConstraints(String input) {
        int price = Integer.parseInt(input);
        if (price < 100 || price % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 100원부터 시작하며 10으로 나누어떨어져야 합니다. 현재 가격 = " + price);
        }
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
