package vendingmachine.exception;

public class NameDuplicatedException extends IllegalArgumentException {
	public NameDuplicatedException(String message) {
		super(message);
	}
}
