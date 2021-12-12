package vendingmachine.exception;

public class MoneyLessThanCoinException extends IllegalArgumentException {

    private static final String MONEY_LESS_THEN_USE_COIN_ERROR_MESSAGE = "[ERROR] 차감하려는 동전이 현재 남아있는 금액보다 클 수 없습니다.";

    public MoneyLessThanCoinException() {
        super(MONEY_LESS_THEN_USE_COIN_ERROR_MESSAGE);
    }
}
