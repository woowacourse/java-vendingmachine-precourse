package vendingmachine.exception;

public class ProductSoldOutException extends IllegalArgumentException {
	public ProductSoldOutException(String message) {
		super(message);
	}
}
