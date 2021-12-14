package vendingmachine.exception;

public class MoneyNotMultipleOfTenMessageException extends VendingMachineException {

	public MoneyNotMultipleOfTenMessageException() {
		super("금액은 10의 배수여야 합니다.");
	}

}
