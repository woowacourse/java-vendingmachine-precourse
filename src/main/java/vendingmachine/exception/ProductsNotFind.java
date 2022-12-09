package vendingmachine.exception;

public class ProductsNotFind extends IllegalArgumentException{

    private static final String EXCEPTION_MESSAGE_PRODUCTS_NOT_FIND_NAME = "[ERROR] 존재하지 않는 제품입니다.";

    public ProductsNotFind() {
        super(EXCEPTION_MESSAGE_PRODUCTS_NOT_FIND_NAME);
    }
}
