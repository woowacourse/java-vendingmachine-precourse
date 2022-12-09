package vendingmachine.exception;

public class ProductsDuplicatedNameException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_PRODUCTS_DUPLICATED_NAME = "[ERROR] 중복되는 제품이름이 있습니다.";

    public ProductsDuplicatedNameException() {
        super(EXCEPTION_MESSAGE_PRODUCTS_DUPLICATED_NAME);
    }
}
