package vendingmachine.exception;

public class ProductNotFoundMessageException extends VendingMachineException {

	public ProductNotFoundMessageException() {
		super("상품을 찾을 수 없습니다.");
	}

}
