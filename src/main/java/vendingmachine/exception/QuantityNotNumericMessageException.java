package vendingmachine.exception;

public class QuantityNotNumericMessageException extends VendingMachineException {

	public QuantityNotNumericMessageException() {
		super("수량은 숫자여야 합니다.");
	}

}
