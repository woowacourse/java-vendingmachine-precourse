package vendingmachine;

public class ProductInfo {

    // 기본 이름 형식을 지킨 경우 최소 길이가 7이다.
    private static int MIN_NAME_LENGTH = 7;

    private String name;
    private int price;
    private int count;

    public ProductInfo(String rawString) {
        assertNameFormat(rawString);
        String noParenthesis = stripParenthesis(rawString);

        String[] arguments = noParenthesis.split(",");
        assertArgumentsSize(arguments);

        name = arguments[0];

        assertNumberFormat(arguments[1]);
        assertNumberFormat(arguments[2]);
        price = Integer.parseInt(arguments[1]);
        count = Integer.parseInt(arguments[2]);
    }

    private String stripParenthesis(String productName) {
        return productName.substring(1, productName.length() - 1);
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

    private void assertArgumentsSize(String[] arguments) {
        if (arguments.length < 3) {
            throw new IllegalArgumentException("[ERROR] 상품 입력 형식이 올바르지 않습니다.");
        }
    }

    private void assertPriceConstraints(String input) {
        assertNumberFormat(input);
        int price = Integer.parseInt(input);

        if (price < 100 || price % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 100원부터 시작하며 10으로 나누어떨어져야 합니다. 현재 가격 = " + price);
        }

    }

    private void assertNumberFormat(String input) {
        try {
            int number = Integer.parseInt(input);
            assertPositiveGreaterThanZero(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액(수량)은 숫자여야 합니다.");
        }
    }

    private void assertPositiveGreaterThanZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액(수량)은 0 이상이어야 합니다.");
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
