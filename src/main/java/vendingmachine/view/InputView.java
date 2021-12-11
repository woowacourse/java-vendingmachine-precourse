package vendingmachine.view;

import static vendingmachine.constant.Hint.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String inputMoney() {
		System.out.println(INPUT_MONEY.getHint());
		return Console.readLine();
	}

	public static String inputProductList() {
		System.out.println(INPUT_PRODUCT_LIST.getHint());
		return Console.readLine();
	}

	public static String inputProductName() {
		System.out.println(INPUT_PRODUCT_NAME.getHint());
		return Console.readLine();
	}

	public static String inputDeposit() {
		System.out.println(INPUT_DEPOSIT.getHint());
		return Console.readLine();
	}
}
