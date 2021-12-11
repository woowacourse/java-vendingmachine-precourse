package vendingmachine.exception;

public class IntegerTooSmallException extends IllegalArgumentException {
	public IntegerTooSmallException(String message) {
		super(message);
	}
}
