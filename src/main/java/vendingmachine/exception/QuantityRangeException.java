package vendingmachine.exception;

public class QuantityRangeException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_QUANTITY_RANGE = "[ERROR] 수량은 %d 원 이상, %d 원 이하 이어야 합니다.";

    public QuantityRangeException(int minQuantity, int maxQuantity) {
        super(String.format(EXCEPTION_MESSAGE_QUANTITY_RANGE, minQuantity, maxQuantity));
    }
}
