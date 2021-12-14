package vendingmachine.exception;

public class ProductNameDuplicatedMessageException extends VendingMachineException {

	public ProductNameDuplicatedMessageException() {
		super("상품 이름이 중복됩니다.");
	}

}
