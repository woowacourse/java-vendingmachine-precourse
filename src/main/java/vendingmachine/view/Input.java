package vendingmachine.view;

import static vendingmachine.utils.Message.*;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public static int holdingAmount() {
		System.out.println(HOLDING_AMOUNT_INPUT_MESSAGE);
		return Integer.parseInt(Console.readLine());
	}
}
