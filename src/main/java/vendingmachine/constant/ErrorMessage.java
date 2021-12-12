package vendingmachine.constant;

public class ErrorMessage {
	public static final String AMOUNT_IS_NOT_INTEGER_ERROR_MESSAGE = "[ERROR]금액은 2,147,483,647이하의 정수여야합니다.";
	public static final String LESS_THAN_CERTAIN_COIN_ERROR = "[ERROR] 금액은 %d원보다 커야 합니다.";
	public static final String NOT_DIVISIBLE_BY_SMALLEST_COIN_ERROR_MESSAGE = "[ERROR] 입력받은 금액이 %d원으로 나누어지떨어지지 않습니다.\n";
}
