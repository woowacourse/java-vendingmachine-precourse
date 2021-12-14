package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class FormatIsNotCorrectMessageException extends VendingMachineException {

	public FormatIsNotCorrectMessageException() {
		super(ErrorMessage.FORMAT_IS_NOT_CORRECT_MESSAGE);
	}

}
