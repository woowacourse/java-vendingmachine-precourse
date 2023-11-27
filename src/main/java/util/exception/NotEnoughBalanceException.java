package util.exception;

public class NotEnoughBalanceException extends IllegalArgumentException{
    public static final String ERROR_MESSAGE = "해당 상품을 구매하기에 잔여 투입 금액이 부족합니다.";
    public NotEnoughBalanceException() {
        super(ERROR_MESSAGE);
    }
}
