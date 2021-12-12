package vendingmachine.exception;

public class ProductNameEmptyException extends IllegalArgumentException {

    private static final String PRODUCT_NAME_EMPTY_ERROR_MESSAGE = "[ERROR] 상품의 이름은 공백이 들어올 수 없습니다.";

    public ProductNameEmptyException() {
        super(PRODUCT_NAME_EMPTY_ERROR_MESSAGE);
    }
}
