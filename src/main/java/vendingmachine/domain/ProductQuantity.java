package vendingmachine.domain;

public class ProductQuantity {
    public static final int QUANTITY_THRESHOLD = 1;
    public static final String ERROR_PREFIX = "[ERROR] 상품 수량은 ";
    public static final String ERROR_NO_DIGIT_MESSAGE = "숫자로 입력해주세요.";
    public static final String ERROR_QUANTITY_THRESHOLD_MESSAGE = "1이상의 숫자로 입력해주세요.";

    private int quantity;

    public ProductQuantity(String quantity) {
        checkQuantity(quantity);
        this.quantity = Integer.parseInt(quantity);
    }

    private static void checkQuantity(String quantity) {
        checkIsDigit(quantity);
        checkIsLessThanThresholdOfQuantity(quantity);
    }

    private static void checkIsLessThanThresholdOfQuantity(String quantity) {
        if (Integer.parseInt(quantity) < QUANTITY_THRESHOLD) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_QUANTITY_THRESHOLD_MESSAGE);
        }
    }

    private static void checkIsDigit(String quantity) {
        if (!quantity.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_NO_DIGIT_MESSAGE);
        }
    }

    public void reduce() {
        quantity--;
    }

    public boolean isLessThanThreshold() {
        return quantity < QUANTITY_THRESHOLD;
    }
}
