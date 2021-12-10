package vendingmachine.exception;

public abstract class CustomException extends IllegalArgumentException {

	public CustomException() {
	}

	protected abstract void getMessage(String message);

}
