package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.controller.ExceptionController;
import vendingmachine.util.Constant;

public class InputView {
	public static void askHoldingAmount() {
		System.out.println(Constant.ASK_HOLDING_AMOUNT);
		String input = Console.readLine();
		checkHoldingAmount(input);
	}

	private static void checkHoldingAmount(String input) {
		ExceptionController.isInteger(input);
		int holdingAmount = Integer.parseInt(input);
		ExceptionController.isPositive(holdingAmount);
		ExceptionController.isMultipleOfTen(holdingAmount);
	}




}
