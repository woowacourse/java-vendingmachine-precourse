package vendingmachine.exceptions;

public class NotDivisibleByMinPriceCoinException extends RuntimeException {
	public NotDivisibleByMinPriceCoinException(String errorMessage) {
		super(errorMessage);
	}
}
