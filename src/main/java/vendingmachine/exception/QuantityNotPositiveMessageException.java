package vendingmachine.exception;

public class QuantityNotPositiveMessageException extends VendingMachineException {

	public QuantityNotPositiveMessageException() {
		super("수량은 양수여야 합니다.");
	}

}
