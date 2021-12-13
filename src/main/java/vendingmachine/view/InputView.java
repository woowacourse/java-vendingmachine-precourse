package vendingmachine.view;

import static vendingmachine.resource.MessageResource.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private InputView() {
	}

	public static String haveAmount() {
		System.out.println(INPUT_HAVE_AMOUNT_MESSAGE);
		return Console.readLine();
	}

	public static String inputProducts() {
		System.out.println(INPUT_PRODUCTS_MESSAGE);
		return Console.readLine();
	}

	public static String inputAmount() {
		System.out.println(INPUT_AMOUNT_MESSAGE);
		return Console.readLine();
	}

	public static String inputBuyProduct() {
		System.out.println(INPUT_BUY_PRODUCT_MESSAGE);
		return Console.readLine();
	}
}
