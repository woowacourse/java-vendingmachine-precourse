package vendingmachine.exception;

public class ProductContentSizeException extends IllegalArgumentException {

    private static final String PRODUCT_CONTENT_SIZE_ERROR_MESSAGE = "[ERROR] 상품은 이름, 가격, 수량을 정확한 포맷으로 입력해야합니다.";

    public ProductContentSizeException() {
        super(PRODUCT_CONTENT_SIZE_ERROR_MESSAGE);
    }
}
