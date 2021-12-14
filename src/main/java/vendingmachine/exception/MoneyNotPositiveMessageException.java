package vendingmachine.exception;

public class MoneyNotPositiveMessageException extends VendingMachineException {

	public MoneyNotPositiveMessageException() {
		super("금액은 양수여야 합니다.");
	}

}
