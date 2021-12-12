package vendingmachine.exception;

public class ProductNameNotFoundException extends IllegalArgumentException {

    private static final String PRODUCT_NAME_NOT_FOUND_ERROR_MESSAGE = "[ERROR] 상품의 이름을 찾을 수 없습니다.";

    public ProductNameNotFoundException() {
        super(PRODUCT_NAME_NOT_FOUND_ERROR_MESSAGE);
    }
}
