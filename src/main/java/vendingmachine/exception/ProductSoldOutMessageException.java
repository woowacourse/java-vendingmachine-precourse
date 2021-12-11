package vendingmachine.exception;

public class ProductSoldOutMessageException extends VendingMachineException {

	public ProductSoldOutMessageException() {
		super("상품이 매진 되었습니다.");
	}

}
