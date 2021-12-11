package vendingmachine.exception;

public class ProductAlreadyExistMessageException extends VendingMachineException {

	public ProductAlreadyExistMessageException() {
		super("상품이 이미 존재합니다.");
	}

}
