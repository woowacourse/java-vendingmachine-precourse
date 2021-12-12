package vendingmachine.exception;

public class ProductNotEnoughMoneyException extends RuntimeException {

    private static final String PRODUCT_NOT_ENOUGH_MONEY_ERROR_MESSAGE = "[ERROR] 현재 돈으로는 구매할 수 없는 상품의 가격입니다.";

    public ProductNotEnoughMoneyException() {
        super(PRODUCT_NOT_ENOUGH_MONEY_ERROR_MESSAGE);
    }
}
