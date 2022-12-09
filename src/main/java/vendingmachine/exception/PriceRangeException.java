package vendingmachine.exception;

public class PriceRangeException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_PRICE_RANGE = "[ERROR] 가격은 %d 원 이상, %d 원 이하 이어야 합니다.";

    public PriceRangeException(int minPrice, int maxPrice) {
        super(String.format(EXCEPTION_MESSAGE_PRICE_RANGE, minPrice, maxPrice));
    }
}
