package vendingmachine.exception;

public class MoneyLessThanUseMoneyException extends IllegalArgumentException {

    private static final String MONEY_LESS_THAN_USE_MONEY_ERROR_MESSAGE = "[ERROR] 차감하고자하는 금액이 현재 보유 금액보다 클 수 없습니다.";

    public MoneyLessThanUseMoneyException() {
        super(MONEY_LESS_THAN_USE_MONEY_ERROR_MESSAGE);
    }
}
