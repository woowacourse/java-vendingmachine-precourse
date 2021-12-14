package vendingmachine.exception;

public class BalanceNotNumericMessageException extends VendingMachineException {

	public BalanceNotNumericMessageException() {
		super("금액은 숫자여야 합니다.");
	}

}
