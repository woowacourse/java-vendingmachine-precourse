package vendingmachine.exceptions;

public class NotDivisibleByMinPriceCoinException extends IllegalArgumentException {
	public NotDivisibleByMinPriceCoinException(String errorMessage) {
		super(errorMessage);
	}
}
