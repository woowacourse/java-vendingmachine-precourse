package vendingmachine.exception;

public class FormatIsNotCorrectMessageException extends VendingMachineException {

	public FormatIsNotCorrectMessageException() {
		super("형식이 맞지 않습니다.");
	}

}
