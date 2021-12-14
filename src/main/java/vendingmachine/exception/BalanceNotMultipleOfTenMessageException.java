package vendingmachine.exception;

public class BalanceNotMultipleOfTenMessageException extends VendingMachineException {

	public BalanceNotMultipleOfTenMessageException() {
		super("금액은 10의 배수여야 합니다.");
	}

}
