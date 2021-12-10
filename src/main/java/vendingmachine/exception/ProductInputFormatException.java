package vendingmachine.exception;

import static vendingmachine.utils.Constant.*;

public class ProductInputFormatException extends CustomException {
	private final String message = "[ERROR] 상품 입력이 올바르지 않습니다. ex) [상품이름,가격(" + COIN_MIN + "원 이상),수량(1개 이상)]";

	public ProductInputFormatException() {
		getMessage(message);
	}

	@Override
	public void getMessage(String message) {
		System.out.println(message);
	}
}
