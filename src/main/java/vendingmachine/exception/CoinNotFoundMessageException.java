package vendingmachine.exception;

public class CoinNotFoundMessageException extends VendingMachineException {

	public CoinNotFoundMessageException() {
		super("동전을 찾을 수 없습니다.");
	}

}
