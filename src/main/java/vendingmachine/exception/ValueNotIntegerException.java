package vendingmachine.exception;

public class ValueNotIntegerException extends IllegalArgumentException {
	public ValueNotIntegerException(String message) {
		super(message);
	}

	public ValueNotIntegerException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
