package vendingmachine.exception;

public class AmountNumberFormatException extends CustomException {
	private final String message = "[ERROR] 금액은 숫자여야 합니다.";

	public AmountNumberFormatException() {
		getMessage(message);
	}

	@Override
	public void getMessage(String message) {
		System.out.println(message);
	}
}
