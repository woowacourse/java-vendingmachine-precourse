package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class CoinNotFoundMessageException extends VendingMachineException {

	public CoinNotFoundMessageException() {
		super(ErrorMessage.COIN_NOT_FOUND_MESSAGE);
	}

}
