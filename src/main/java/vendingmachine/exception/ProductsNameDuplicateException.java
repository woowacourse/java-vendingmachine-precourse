package vendingmachine.exception;

public class ProductsNameDuplicateException extends IllegalArgumentException {

    private static final String PRODUCT_NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복되는 이름의 상품은 같이 입력될 수 없습니다.";

    public ProductsNameDuplicateException() {
        super(PRODUCT_NAME_DUPLICATE_ERROR_MESSAGE);
    }
}
