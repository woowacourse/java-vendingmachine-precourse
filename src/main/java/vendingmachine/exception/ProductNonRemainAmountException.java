package vendingmachine.exception;

public class ProductNonRemainAmountException extends RuntimeException {

    private static final String PRODUCT_NON_REMAIN_AMOUNT_ERROR_MESSAGE = "[ERROR] 상품의 수량이 0보다 작은 경우 더이상 구매할 수 없습니다.";

    public ProductNonRemainAmountException() {
        super(PRODUCT_NON_REMAIN_AMOUNT_ERROR_MESSAGE);
    }
}
