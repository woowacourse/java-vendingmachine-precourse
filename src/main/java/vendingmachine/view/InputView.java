package vendingmachine.view;

import static vendingmachine.resource.MessageResource.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private InputView() {
	}

	public static int haveAmount() {
		System.out.println(INPUT_HAVE_AMOUNT_MESSAGE);
		return Integer.parseInt(Console.readLine());
	}

	public static String inputProducts() {
		System.out.println(INPUT_PRODUCTS_MESSAGE);
		return Console.readLine();
	}
}
