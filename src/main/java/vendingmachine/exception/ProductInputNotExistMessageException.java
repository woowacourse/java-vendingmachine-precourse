package vendingmachine.exception;

public class ProductInputNotExistMessageException extends VendingMachineException {

	public ProductInputNotExistMessageException() {
		super("등록할 상품 정보가 없습니다.");
	}

}
