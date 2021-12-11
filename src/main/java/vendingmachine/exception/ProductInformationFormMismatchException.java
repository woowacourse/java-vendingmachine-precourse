package vendingmachine.exception;

public class ProductInformationFormMismatchException extends IllegalArgumentException {
	public ProductInformationFormMismatchException(String message) {
		super(message);
	}
}
