package vendingmachine.domain.product;

public class Price {
    private static final String VALID_NUMBER_FORMAT = "[ERROR] 상품 가격은 숫자여야 합니다.";
    private static final String VALID_NUMBER_SIZE = "[ERROR] 상품 가격은 100원 이상이여야 합니다.";
    private static final String VALID_DIVIDE = "[ERROR] 상품 가격은 10으로 나누어 떨어져야 합니다.";

    private static final int DEFAULT_PRICE = 100;
    private static final int PRICE_QUOTIENT = 10;
    private static final int REMAINDER = 0;

    private final int price;

    public Price(String inputPrice) {
        validateNumberFormat(inputPrice);
        int price = Integer.parseInt(inputPrice);

        validateNumberSize(price);
        validateDivide(price);
        this.price = price;
    }

    private void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALID_NUMBER_FORMAT);
        }
    }

    private void validateNumberSize(int price) {
        if (price < DEFAULT_PRICE) {
            throw new IllegalArgumentException(VALID_NUMBER_SIZE);
        }
    }

    private void validateDivide(int price) {
        if (price % PRICE_QUOTIENT != REMAINDER) {
            throw new IllegalArgumentException(VALID_DIVIDE);
        }
    }

    protected int getPrice() {
        return price;
    }
}