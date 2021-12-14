package vendingmachine.exception;

public class PriceNotMoreThanMinimumAmountMessageException extends VendingMachineException {

	public PriceNotMoreThanMinimumAmountMessageException() {
		super("금액은 100원 이상이어야 합니다.");
	}

}
