package vendingmachine.exception;

public class OutOfBoundException extends RuntimeException {
	public OutOfBoundException(String message) {
		super(message);
	}
}
