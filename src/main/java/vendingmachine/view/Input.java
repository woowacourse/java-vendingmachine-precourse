package vendingmachine.view;

import static vendingmachine.utils.Message.*;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public static String holdingAmount() {
		System.out.println(HOLDING_AMOUNT_INPUT_MESSAGE);
		return Console.readLine();
	}

	public static String item() {
		System.out.println(ITEM_INPUT_MESSAGE);
		return Console.readLine();
	}

	public static String inputAmount() {
		System.out.println(INPUT_AMOUNT_INPUT_MESSAGE);
		return Console.readLine();
	}
}
