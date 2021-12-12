package vendingmachine.exception;

public class ProductNotDivisableException extends IllegalArgumentException {

    private static final String PRODUCT_NOT_DIVISABLE_ERROR_MESSAGE = "[ERROR] 상품 가격은 10원으로 나누어떠러져야 합니다.";

    public ProductNotDivisableException() {
        super(PRODUCT_NOT_DIVISABLE_ERROR_MESSAGE);
    }
}
