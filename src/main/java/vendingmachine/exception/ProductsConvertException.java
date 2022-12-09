package vendingmachine.exception;

public class ProductsConvertException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_CONVERT_PRODUCT =
            "[ERROR] 입력 형식이 잘못됬습니다. [상품,가격,수량];[상품,가격,수량]";

    public ProductsConvertException() {
        super(EXCEPTION_MESSAGE_CONVERT_PRODUCT);
    }
}
