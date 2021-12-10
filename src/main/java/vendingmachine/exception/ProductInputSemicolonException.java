package vendingmachine.exception;

public class ProductInputSemicolonException extends CustomException {
	private final String message = "[ERROR] 상품 입력 사이에 ';'가 존재해야 합니다.";

	public ProductInputSemicolonException() {
		getMessage(message);
	}

	@Override
	public void getMessage(String message) {
		System.out.println(message);
	}
}
