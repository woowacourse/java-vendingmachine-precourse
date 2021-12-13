package vendingmachine.util;

public final class ErrorMessageConstants {
	public static final String INTEGER_EXCEPTION_MESSAGE = "[ERROR] 금액은 숫자여야 합니다.";
	public static final String POSITIVE_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 0이상의 금액만 입력할 수 있습니다.";
	public static final String DIVISION_EXCEPTION_MESSAGE = "[ERROR] 10의 배수인 금액만 입력할 수 있습니다.";
	public static final String NO_SUCH_PRODUCT_EXCEPTION_MESSAGE = "[ERROR] 해당 상품은 존재하지 않습니다.";

	private ErrorMessageConstants() {
	}
}
