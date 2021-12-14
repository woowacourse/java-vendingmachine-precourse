package vendingmachine.exception;

public class MoneyNotNumericMessageException extends VendingMachineException {

	public MoneyNotNumericMessageException() {
		super("금액은 숫자여야 합니다.");
	}

}
