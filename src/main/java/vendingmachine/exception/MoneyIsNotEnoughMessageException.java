package vendingmachine.exception;

public class MoneyIsNotEnoughMessageException extends VendingMachineException {

	public MoneyIsNotEnoughMessageException() {
		super("보유하신 금액이 부족합니다.");
	}

}
