package vendingmachine.exception;

public class ProductNotFoundLeastException extends RuntimeException {

    private static final String PRODUCT_LEAST_VALUE_NOT_FOUND_ERROR_MESSAGE = "[ERROR] 상품의 최소금액이 존재하지 않습니다.";

    public ProductNotFoundLeastException() {
        super(PRODUCT_LEAST_VALUE_NOT_FOUND_ERROR_MESSAGE);
    }
}
