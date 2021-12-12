package vendingmachine.exception;

public class ProductLeastPriceException extends IllegalArgumentException {

    private static final String PRODUCT_LEAST_PRICE_ERROR_MESSAGAE = "[ERROR] 상품 가격은 100원 이상의 값이 들어와야 합니다.";

    public ProductLeastPriceException() {
        super(PRODUCT_LEAST_PRICE_ERROR_MESSAGAE);
    }
}
