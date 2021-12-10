package vendingmachine.domain;

public class ProductPrice {
    public static final int MULTIPLE_STANDARD = 10;
    public static final int MULTIPLE_REMAINDER = 0;
    public static final int PRICE_THRESHOLD = 100;
    public static final String ERROR_PREFIX = "[ERROR] 상품 가격은 ";
    public static final String ERROR_NO_DIGIT_MESSAGE = "숫자로 입력해주세요.";
    public static final String ERROR_MULTIPLE_STANDARD_MESSAGE = MULTIPLE_STANDARD + "원 단위이어야 합니다.";
    public static final String ERROR_PRICE_THRESHOLD_MESSAGE = PRICE_THRESHOLD + "원 이상이어야 합니다.";

    private final int price;

    public ProductPrice(String price) {
        checkPrice(price);
        this.price = Integer.parseInt(price);
    }

    private static void checkPrice(String price) {
        checkIsDigit(price);
        checkIsLessThanThresholdOfPrice(price);
        checkIsMultipleOfStandard(price);
    }

    private static void checkIsDigit(String price) {
        if (!price.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_NO_DIGIT_MESSAGE);
        }
    }

    private static void checkIsMultipleOfStandard(String price) {
        if (Integer.parseInt(price) % MULTIPLE_STANDARD != MULTIPLE_REMAINDER) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_MULTIPLE_STANDARD_MESSAGE);
        }
    }

    private static void checkIsLessThanThresholdOfPrice(String price) {
        if (Integer.parseInt(price) < PRICE_THRESHOLD) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_PRICE_THRESHOLD_MESSAGE);
        }
    }

    public int get() {
        return price;
    }

    public boolean isOrLess(int price) {
        return this.price <= price;
    }
}
