package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.Validation;

public class InputView {

	public static final String INPUT_HOLDING_AMOUNT = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static int getHoldingAmount() {
		System.out.println(INPUT_HOLDING_AMOUNT);
		String holdingAmount = Console.readLine();
		System.out.println();

		try {
			Validation.isHoldingAmount(holdingAmount);
			return Integer.parseInt(holdingAmount);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getHoldingAmount();
		}
	}
}
