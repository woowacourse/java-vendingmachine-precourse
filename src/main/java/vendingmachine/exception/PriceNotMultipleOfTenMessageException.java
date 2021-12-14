package vendingmachine.exception;

public class PriceNotMultipleOfTenMessageException extends VendingMachineException {

	public PriceNotMultipleOfTenMessageException() {
		super("금액은 10원으로 나누어 떨어져야 합니다.");
	}

}
