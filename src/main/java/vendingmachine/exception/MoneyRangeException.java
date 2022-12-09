package vendingmachine.exception;

public class MoneyRangeException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_MONEY_RANGE = "[ERROR] 돈은 %d 원 이상, %d 원 이하 이어야 합니다.";

    public MoneyRangeException(int minMoney, int maxMoney) {
        super(String.format(EXCEPTION_MESSAGE_MONEY_RANGE, minMoney, maxMoney));
    }
}
