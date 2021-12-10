package vendingmachine.exception;

import static vendingmachine.utils.Constant.*;

public class AmountIsNotRangedException extends CustomException {
	private final String message = "[ERROR] 금액의 최소 단위는 " + COIN_MIN + "원 이상이어야 합니다.";

	public AmountIsNotRangedException() {
		getMessage(message);
	}

	@Override
	public void getMessage(String message) {
		System.out.println(message);
	}
}
