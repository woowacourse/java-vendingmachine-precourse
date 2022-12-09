package vendingmachine.exception;

public class PriceDividingException extends IllegalArgumentException{

    private static final String EXCEPTION_MESSAGE_PRICE_DIVIDING = "[ERROR] 가격은 %d 원으로 나누어 떨어져야 합니다.";

    public PriceDividingException(int dividing) {
        super(String.format(EXCEPTION_MESSAGE_PRICE_DIVIDING, dividing));
    }
}
