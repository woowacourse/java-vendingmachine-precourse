package vendingmachine.exception;

public class BalanceNotPositiveMessageException extends VendingMachineException {

	public BalanceNotPositiveMessageException() {
		super("금액은 양수여야 합니다.");
	}

}
