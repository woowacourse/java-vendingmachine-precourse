package vendingmachine.exception;

public class PriceNotPurchaseException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_PRICE_NOT_PURCHASE = "[ERROR] 소지금액으로 해당 제품을 구매할 수 없습니다";

    public PriceNotPurchaseException() {
        super(String.format(EXCEPTION_MESSAGE_PRICE_NOT_PURCHASE));
    }
}
